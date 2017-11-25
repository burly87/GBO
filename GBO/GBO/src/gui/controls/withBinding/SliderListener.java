package gui.controls.withBinding;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SliderListener extends Application
{

    public void start(Stage primaryStage)
    {
        GridPane grid = new GridPane();

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Slider slider = new Slider(0, 100, 50);
        Label label = new Label("Slider wurde noch nicht bewegt");

        slider.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                double sum = 0.0;
                sum = (double) oldValue - (double) newValue;
                String sum2 = Double.toString(sum);
                label.setText("Aenderung des Sliders um " + sum2);
            }
        });

        grid.add(slider, 0, 0);
        grid.add(label, 0, 1);

        Scene scene = new Scene(grid, 480, 80);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Slider mit Listener");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
