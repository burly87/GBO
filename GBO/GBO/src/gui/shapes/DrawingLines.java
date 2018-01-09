package gui.shapes;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawingLines extends Application
{
    private GridPane root;

    private Pane drawPane;

    private HBox btnBox;

    private double x, y;

    private Button delete;

    private ComboBox<Double> lineSize;

    private ComboBox<Color> lineColor;

    private ObservableList<Double> lineNmb;

    private ObservableList<Color> lineCol;

    @Override
    public void start(Stage primaryStage)
    {
        root = new GridPane();
        drawPane = new Pane();
        btnBox = new HBox();

        lineNmb = FXCollections.observableArrayList(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d);
        lineCol = FXCollections.observableArrayList(Color.BLUE, Color.RED, Color.GREEN);

        lineSize = new ComboBox(lineNmb);
        lineSize.setValue(1d);
        lineColor = new ComboBox(lineCol);
        lineColor.setValue(Color.BLUE);

        delete = new Button("Loeschen");
        delete.setOnAction(e -> delete());

        btnBox.getChildren().addAll(lineSize, lineColor, delete);
        root.add(btnBox, 0, 0);
        root.add(drawPane, 0, 1);
        root.setOnMousePressed(e -> mousePressed(e.getX(), e.getY()));
        root.setOnMouseDragged(e -> mouseDragged(e.getX(), e.getY()));

        primaryStage.setTitle("Freihandzeichnen");
        primaryStage.setScene(new Scene(root, 330, 300));
        primaryStage.show();
    }

    public void delete()
    {
        drawPane.getChildren().clear();
    }

    private void mousePressed(double newX, double newY)
    {
        x = newX;
        y = newY;
        mouseDragged(x, y);
    }

    private void mouseDragged(double newX, double newY)
    {
        Line line = new Line(x, y, newX, newY);
        line.setStroke(lineColor.getValue());
        line.setStrokeWidth(lineSize.getValue());
        drawPane.getChildren().add(line);

        if (newX > 0 && newX < drawPane.getScene().getWidth())
        {
            x = newX;
        }

        if (newY > 0 && newY < drawPane.getScene().getHeight())
            y = newY;
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
