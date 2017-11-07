package gui.Ubeung4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
2. Aufgabe:
Schreiben Sie ein Beispielprogramm, in dem mehrere Buttons in eine VBox gelegt werden. 
Mindestens ein Button soll sich nicht ausdehnen (button1), wenn das Fenster vergrößert wird, 
mindestens ein Button soll nur in der Breite wachsen (button2),
mindestens einer nur in der Höhe (button3)
und mindestens einer sowohl in der Breite als auch in der Höhe (button4).
*/

public class Aufgabe2 extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox root = new VBox(10);

        Button b;

        b = new Button("button1");
        root.getChildren().add(b);

        b = new Button("button2");
        b.setMaxWidth(Double.MAX_VALUE);
        root.getChildren().add(b);

        b = new Button("button3");
        b.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(b, Priority.ALWAYS);
        root.getChildren().add(b);

        b = new Button("button4");
        b.setMaxWidth(Double.MAX_VALUE);
        b.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(b, Priority.ALWAYS);
        root.getChildren().add(b);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aufgabe 2");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
