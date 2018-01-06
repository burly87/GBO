package gui.shapes;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

public class Bezier extends Application
{
    private Circle start, end, control1, control2;

    private double startX, startY, controlX1, controlY1, controlX2, controlY2,
                    endX, endY;

    double orgSceneX, orgSceneY;

    @Override
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        drawBezier(root);

        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void drawBezier(Pane root)
    {
        CubicCurve bezier = new CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY);

        start = createCircle(50, 50, 5, Color.RED);
        end = createCircle(300, 50, 5, Color.RED);
        control1 = createCircle(100, 200, 5, Color.BLUE);
        control2 = createCircle(250, 200, 5, Color.BLUE);

        bezier.setStartX(50.0f);
        bezier.setStartY(50.0f);
        bezier.setControlX1(100.0f);
        bezier.setControlY1(200.0f);
        bezier.setControlX2(250.0f);
        bezier.setControlY2(200.0f);
        bezier.setEndX(300.0f);
        bezier.setEndY(50.0f);

        Line line = connect(start, bezier);

        bezier.setStroke(Color.BLACK);
        bezier.setFill(null);
        bezier.setStrokeWidth(3);

        bezier.toFront();

        root.getChildren().add(bezier);
        root.getChildren().add(line);
        root.getChildren().addAll(start, end, control1, control2);
    }

    private Circle createCircle(double x, double y, double r, Color color)
    {
        Circle circle = new Circle(x, y, r, color);

        circle.setCursor(Cursor.HAND);

        circle.setOnMousePressed((t) ->
        {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            Circle c = (Circle) (t.getSource());
            c.toFront();
        });
        circle.setOnMouseDragged((t) ->
        {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;

            Circle c = (Circle) (t.getSource());

            c.setCenterX(c.getCenterX() + offsetX);
            c.setCenterY(c.getCenterY() + offsetY);

            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
        });
        return circle;
    }

    private Line connect(Circle c1, CubicCurve c2)
    {
        Line line = new Line();

        line.startXProperty().bind(c1.centerXProperty());
        line.startYProperty().bind(c1.centerYProperty());
        line.endXProperty().bind(c2.endXProperty());
        line.endYProperty().bind(c2.endYProperty());

        line.setStrokeWidth(3);
        line.setStrokeLineCap(StrokeLineCap.ROUND);

        return line;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
