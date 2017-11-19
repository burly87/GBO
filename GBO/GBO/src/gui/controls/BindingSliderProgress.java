package gui.controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BindingSliderProgress extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();

        root.setVgap(5);
        root.setHgap(5);
        root.setPadding(new Insets(10));

        Slider slider1 = new Slider(-2, 2, 0);
        ProgressBar progressBar = new ProgressBar();
        ProgressIndicator progressIndicator = new ProgressIndicator();

        slider1.valueProperty().addListener(new ChangeListener<Number>()
        {
            public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal)
            {
                progressBar.setProgress(newVal.doubleValue());
                progressIndicator.setProgress(newVal.doubleValue());
            }
        });

        root.add(slider1, 0, 0);
        root.add(progressBar, 0, 1);
        root.add(progressIndicator, 1, 1);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binding-Beispiel: Slider und Progress");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
