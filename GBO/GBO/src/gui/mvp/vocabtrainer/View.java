package gui.mvp.vocabtrainer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TEST");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
