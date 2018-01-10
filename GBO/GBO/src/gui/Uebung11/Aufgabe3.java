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

public class Aufgabe3 extends Application
{
    private Circle start, p1, p2, p3, p4, p5, p6, p7, end;

    private Pane root;

    @Override
    public void start(Stage primaryStage)
    {
        root = new Pane();

        start = new Circle(50, 50, 10, Color.BLACK);
        start.setOnMouseDragged(mouseDragged);
        end.setOnMouseDragged(pkt2);

        for (int i = 1; i < 10; i++)
        {
            Circle p = new Circle();

        }

        p1 = new Circle(100, 200, 10, Color.BLACK);
        p1.setOnMouseDragged(pkt0);
        p2 = new Circle(250, 200, 10, Color.BLACK);
        p2.setOnMouseDragged(pkt1);
        p3 = new Circle(300, 200, 10, Color.BLACK);
        p3.setOnMouseDragged(pkt3);
        p4 = new Circle(400, 200, 10, Color.BLACK);
        p4.setOnMouseDragged(pkt4);
        p5 = new Circle(500, 200, 10, Color.BLACK);
        p5.setOnMouseDragged(pkt5);
        p6 = new Circle(250, 500, 10, Color.BLACK);
        p6.setOnMouseDragged(pkt6);
        p7 = new Circle(100, 300, 10, Color.BLACK);
        p7.setOnMouseDragged(pkt7);
        end = new Circle(300, 50, 10, Color.BLACK);

        root.getChildren().add(start);
        root.getChildren().add(p1);
        root.getChildren().add(p2);
        root.getChildren().add(p3);
        root.getChildren().add(p4);
        root.getChildren().add(p5);
        root.getChildren().add(p6);
        root.getChildren().add(p7);
        root.getChildren().add(end);

        drawPolygon();

        primaryStage.setTitle("Gefülltest Polygon");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    private void drawPolygon()
    {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]
        { start.getCenterX(), start.getCenterY(), p1.getCenterX(), p1.getCenterY(), p2.getCenterX(), p2.getCenterY(), p3.getCenterX(), p3.getCenterY(), p4.getCenterX(), p4.getCenterY(), p5.getCenterX(), p5.getCenterY(), p6.getCenterX(), p6.getCenterY(), p7.getCenterX(), p7.getCenterY(), end.getCenterX(), end.getCenterY() });

        polygon.setStroke(Color.RED);
        polygon.setFill(Color.BLUE.deriveColor(0, 0.5, 1.0, 0.8));
        polygon.setStrokeWidth(3);
        root.getChildren().add(polygon);
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    private EventHandler<MouseEvent> mouseDragged = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            start.setCenterX(t.getX());
            start.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawPolygon();
        }
    };

    private EventHandler<MouseEvent> pkt0 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            p1.setCenterX(t.getX());
            p1.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawPolygon();
        }
    };

    private EventHandler<MouseEvent> pkt1 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            p2.setCenterX(t.getX());
            p2.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawPolygon();
        }
    };

    private EventHandler<MouseEvent> pkt2 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            end.setCenterX(t.getX());
            end.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawPolygon();
        }
    };

    private EventHandler<MouseEvent> pkt3 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            p3.setCenterX(t.getX());
            p3.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawPolygon();
        }
    };

    private EventHandler<MouseEvent> pkt4 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            p4.setCenterX(t.getX());
            p4.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawPolygon();
        }
    };

    private EventHandler<MouseEvent> pkt5 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            p5.setCenterX(t.getX());
            p5.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawPolygon();
        }
    };

    private EventHandler<MouseEvent> pkt6 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            p6.setCenterX(t.getX());
            p6.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawPolygon();
        }
    };

    private EventHandler<MouseEvent> pkt7 = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            p7.setCenterX(t.getX());
            p7.setCenterY(t.getY());

            root.getChildren().remove(9);
            drawPolygon();
        }
    };
}
