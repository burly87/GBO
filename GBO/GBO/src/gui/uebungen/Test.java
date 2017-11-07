package gui.uebungen;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Text t = new Text("Hello World!");
        t.setX(10.0f);
        t.setY(50.0f);
        t.setFont(Font.font("Calibri", FontWeight.NORMAL, 30));
        t.setEffect(new GaussianBlur()); // Glow, SepiaTone, Shadow

        Group root = new Group(t);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Test Programm");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
