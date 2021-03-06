package gui.calculator;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Calculator extends Application
{

    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            AnchorPane root = FXMLLoader.load(getClass().getResource("calculator.fxml"));

            Scene scene = new Scene(root, 300, 350);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Calculator");
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
