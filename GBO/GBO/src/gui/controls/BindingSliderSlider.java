package gui.controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderSlider extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Slider slider1 = new Slider(0, 100, 50);
        Slider slider2 = new Slider(0, 100, 50);
        Slider slider3 = new Slider(0, 100, 50);
        Slider slider4 = new Slider(0, 300, 50);

        slider1.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                double help = (slider1.valueProperty().getValue() + slider2.valueProperty().getValue() + slider3.valueProperty().getValue());
                slider4.valueProperty().setValue(help);
            }

        });

        slider2.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                double help = (slider1.valueProperty().getValue() + slider2.valueProperty().getValue() + slider3.valueProperty().getValue());
                slider4.valueProperty().setValue(help);
            }

        });

        slider3.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                double help = (slider1.valueProperty().getValue() + slider2.valueProperty().getValue() + slider3.valueProperty().getValue());
                slider4.valueProperty().setValue(help);
            }

        });

        // slider1.valueProperty().bindBidirectional(slider2.valueProperty());
        // slider2.valueProperty().bindBidirectional(slider3.valueProperty());
        // slider4.valueProperty().bind(slider3.valueProperty());

        GridPane grid = new GridPane();

        grid.add(slider1, 0, 0);
        grid.add(slider2, 0, 1);
        grid.add(slider3, 0, 2);
        grid.add(slider4, 0, 3);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Scene scene = new Scene(grid, 400, 125);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Beispiel von Slider zu Slider");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}