package gui.Ubeung4;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PaneBeispiel extends Application
{

    private double xSize = 0;

    private double ySize = 0;

    private Pane root = new Pane();

    public void start(Stage primaryStage)
    {

        root.widthProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth)
            {
                xSize = (double) newSceneWidth;
                root.getChildren().clear();
                System.out.println("cleared");
                drawFunction();
                System.out.println("Width: " + newSceneWidth);
            }
        });
        root.heightProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight)
            {
                ySize = (double) newSceneHeight;

                root.getChildren().clear();
                System.out.println("cleared");
                drawFunction();
                System.out.println("Height: " + newSceneHeight);
            }
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Pane-Beispiel");
        primaryStage.show();

    }

    double lerp(double v0, double v1, double t)
    {
        double test = v0 + t * (v1 - v0);
        return test;
    }

    void drawFunction()
    {

        for (double i = 0; i < 10; i++)
        {
            Button b = new Button("Button " + i);

            b.setLayoutX(lerp(0, xSize - 70, i / 9));
            b.setLayoutY(lerp(0, ySize - 25, i / 9));

            root.getChildren().add(b);

        }

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
