package gui.controls.withBinding;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderSlider extends Application
{
    public void start(Stage primaryStage)
    {
        Slider slider1 = new Slider(0, 100, 50);
        Slider slider2 = new Slider(0, 100, 50);
        Slider slider3 = new Slider(0, 100, 50);
        Slider slider4 = new Slider();
        slider4.setMax(slider1.getMax() + slider2.getMax() + slider3.getMax());

        slider4.valueProperty().bind((slider3.valueProperty()).add(slider2.valueProperty()).add(slider1.valueProperty()));

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