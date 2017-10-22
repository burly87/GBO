package gui.Bsp01;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main11 extends Application
{
    public void start(Stage primaryStage)
    {
        try
        {
            GridPane root = FXMLLoader.load(getClass().getResource("Main11.fxml"));
            // FXMLLoader loader = new
            // FXMLLoader(getClass().getResource("Main11.fxml"));
            // GridPane root = (GridPane)loader.load();

            Scene scene = new Scene(root, 310, 300);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hello World");
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
