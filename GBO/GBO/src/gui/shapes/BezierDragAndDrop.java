package gui.shapes;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class BezierDragAndDrop extends Application
{

    private Anchor start, end, control1, control2;

    @Override
    public void start(final Stage stage) throws Exception
    {
        CubicCurve bezier = createStartingCurve();

        start = new Anchor(Color.RED, bezier.startXProperty(), bezier.startYProperty());
        control1 = new Anchor(Color.GOLD, bezier.controlX1Property(), bezier.controlY1Property());
        control2 = new Anchor(Color.GOLD, bezier.controlX2Property(), bezier.controlY2Property());
        end = new Anchor(Color.RED, bezier.endXProperty(), bezier.endYProperty());

        stage.setTitle("Cubic Curve Manipulation Sample");
        stage.setScene(new Scene(new Group(bezier, start, control1, control2, end), 400, 400));
        stage.show();
    }

    private CubicCurve createStartingCurve()
    {
        CubicCurve bezier = new CubicCurve();
        bezier.setStartX(100);
        bezier.setStartY(100);
        bezier.setControlX1(150);
        bezier.setControlY1(50);
        bezier.setControlX2(250);
        bezier.setControlY2(150);
        bezier.setEndX(300);
        bezier.setEndY(100);
        bezier.setStroke(Color.BLACK);
        bezier.setStrokeWidth(4);
        bezier.setFill(Color.GREEN.deriveColor(0, 1.2, 1, 0)); // FillColor
                                                               // change
        return bezier;
    }

    // a draggable anchor displayed around a point.
    class Anchor extends Circle
    {
        Anchor(Color color, DoubleProperty x, DoubleProperty y)
        {
            super(x.get(), y.get(), 10);
            setFill(color.deriveColor(1, 1, 1, 0.5));
            setStroke(color);
            setStrokeWidth(2);
            setStrokeType(StrokeType.OUTSIDE);

            x.bind(centerXProperty());
            y.bind(centerYProperty());
            enableDrag();
        }

        // make a node movable
        private void enableDrag()
        {
            final Delta dragDelta = new Delta();
            setOnMousePressed(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent mouseEvent)
                {
                    // delta distance for drag and drop
                    dragDelta.x = getCenterX() - mouseEvent.getX();
                    dragDelta.y = getCenterY() - mouseEvent.getY();
                    getScene().setCursor(Cursor.MOVE);
                }
            });

            setOnMouseDragged(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent mouseEvent)
                {
                    // checking if in Scene
                    double newX = mouseEvent.getX() + dragDelta.x; // new X Pos
                    if (newX > 0 && newX < getScene().getWidth())
                    {
                        setCenterX(newX);
                    }
                    double newY = mouseEvent.getY() + dragDelta.y; // new Y pos
                    if (newY > 0 && newY < getScene().getHeight())
                    {
                        setCenterY(newY);
                    }
                }
            });

            // Mouse style, just 4 fun
            setOnMouseEntered(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent mouseEvent)
                {
                    if (!mouseEvent.isPrimaryButtonDown())
                    {
                        getScene().setCursor(Cursor.HAND);
                    }
                }
            });
            setOnMouseExited(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent mouseEvent)
                {
                    if (!mouseEvent.isPrimaryButtonDown())
                    {
                        getScene().setCursor(Cursor.DEFAULT);
                    }
                }
            });
        }

        // records relative x and y co-ordinates.
        private class Delta
        {
            double x, y;
        }
    }

    public static void main(String[] args) throws Exception
    {
        launch(args);
    }
}