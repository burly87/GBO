package gui.Ubeung4;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Aufgabe1 extends Application
{

    public void start(Stage primaryStage)
    {
        Pane root = new Pane();

        root.widthProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldSize, Number newSize)
            {

                changeSize(root);

            }

        });

        root.heightProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldSize, Number newSize)
            {
                changeSize(root);

            }

        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pane-Beispiel");
        primaryStage.show();

        Button start = (Button) root.getChildren();

    }

    double lerp(double v0, double v1, double t)
    {
        return v0 + t * (v1 - v0);
    }

    public void changeSize(Pane root)
    {

        Number width = root.widthProperty().getValue();
        Number height = root.heightProperty().getValue();

        // double oldBtnX = btn.getWidth();
        // double oldBtnY = btn.gehtHeight();

        for (int i = 0; i <= 10; i++)
        {
            Button btn = (Button) root.getChildren().get(i);
            btn.setLayoutX(lerp(0, (double) width, i));
            btn.setLayoutY(lerp(0, (double) height, i));

            root.getChildren().add(btn);
        }

        System.out.println("width:" + width);
        System.out.println("height:" + height);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
