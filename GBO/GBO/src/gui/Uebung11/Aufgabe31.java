package gui.Uebung11;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Aufgabe31 extends Application
{
    private Circle start, ctrp1, ctrp2, ctrp3, ctrp4, ctrp5, ctrp6, ctrp7, end;

    private Pane root;

    @Override
    public void start(Stage primaryStage)
    {
        root = new Pane();

        start = new Circle(50, 50, 10, Color.BLACK);
        start.setOnMouseDragged(p0);
        ctrp1 = new Circle(100, 200, 10, Color.BLACK);
        ctrp1.setOnMouseDragged(p1);
        ctrp2 = new Circle(250, 200, 10, Color.BLACK);
        ctrp2.setOnMouseDragged(p2);

        ctrp3 = new Circle(300, 200, 10, Color.BLACK);
        ctrp3.setOnMouseDragged(p4);
        ctrp4 = new Circle(400, 200, 10, Color.BLACK);
        ctrp4.setOnMouseDragged(p5);

        ctrp5 = new Circle(500, 200, 10, Color.BLACK);
        ctrp5.setOnMouseDragged(p6);
        ctrp6 = new Circle(250, 500, 10, Color.BLACK);
        ctrp6.setOnMouseDragged(p7);

        ctrp7 = new Circle(100, 300, 10, Color.BLACK);
        ctrp7.setOnMouseDragged(p8);

        end = new Circle(300, 50, 10, Color.BLACK);
        end.setOnMouseDragged(p3);

        root.getChildren().add(start);
        root.getChildren().add(ctrp1);
        root.getChildren().add(ctrp2);
        root.getChildren().add(ctrp3);
        root.getChildren().add(ctrp4);
        root.getChildren().add(ctrp5);
        root.getChildren().add(ctrp6);
        root.getChildren().add(ctrp7);
        root.getChildren().add(end);

        drawBezier();

        primaryStage.setTitle("Bezier-Kurve");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void drawBezier()
    {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]
        { start.getCenterX(), start.getCenterY(), ctrp1.getCenterX(), ctrp1.getCenterY(), ctrp2.getCenterX(), ctrp2.getCenterY(), ctrp3.getCenterX(), ctrp3.getCenterY(), ctrp4.getCenterX(), ctrp4.getCenterY(), ctrp5.getCenterX(), ctrp5.getCenterY(), ctrp6.getCenterX(), ctrp6.getCenterY(), ctrp7.getCenterX(), ctrp7.getCenterY(), end.getCenterX(), end.getCenterY() });

        polygon.setStroke(Color.BLACK);
        polygon.setFill(Color.GREEN.deriveColor(1, 1, 1, 0.5));
        polygon.setStrokeWidth(3);
        root.getChildren().add(polygon);
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    private EventHandler<MouseEvent> p0 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {

            start.setCenterX(t.getX());
            start.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawBezier();
        }
    };

    private EventHandler<MouseEvent> p1 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {

            ctrp1.setCenterX(t.getX());
            ctrp1.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawBezier();
        }
    };

    private EventHandler<MouseEvent> p2 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {

            ctrp2.setCenterX(t.getX());
            ctrp2.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawBezier();
        }
    };

    private EventHandler<MouseEvent> p3 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {

            end.setCenterX(t.getX());
            end.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawBezier();
        }
    };

    private EventHandler<MouseEvent> p4 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {

            ctrp3.setCenterX(t.getX());
            ctrp3.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawBezier();
        }
    };

    private EventHandler<MouseEvent> p5 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {

            ctrp4.setCenterX(t.getX());
            ctrp4.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawBezier();
        }
    };

    private EventHandler<MouseEvent> p6 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {

            ctrp5.setCenterX(t.getX());
            ctrp5.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawBezier();
        }
    };

    private EventHandler<MouseEvent> p7 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {

            ctrp6.setCenterX(t.getX());
            ctrp6.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawBezier();
        }
    };

    private EventHandler<MouseEvent> p8 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {

            ctrp7.setCenterX(t.getX());
            ctrp7.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawBezier();
        }
    };
}