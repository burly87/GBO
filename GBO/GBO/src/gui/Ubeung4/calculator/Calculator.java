package gui.Ubeung4.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();

        // just Gaps etc.
        root.setVgap(10);
        root.setHgap(10);
        Insets ins = new Insets(10);
        root.setPadding(ins);

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (i <= 3 || j <= 3)
                {
                    Button zahlen = new Button("" + i);
                    root.getChildren().add(zahlen);
                }
            }

        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Taschenrechner");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
