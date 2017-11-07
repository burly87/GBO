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

public class Aufgabe2Other extends Application

{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox root = new VBox(10);

        for (int i = 1; i <= 4; i++)
        {
            Button b = new Button("button " + i);
            b.setLayoutX(i);
            b.setLayoutY(i);

            if (i == 2)
            {
                b.setMaxWidth(Double.MAX_VALUE);
            }
            else if (i == 3)
            {
                b.setMaxHeight(Double.MAX_VALUE);
                VBox.setVgrow(b, Priority.ALWAYS);
            }
            else if (i == 4)
            {
                b.setMaxWidth(Double.MAX_VALUE);
                b.setMaxHeight(Double.MAX_VALUE);
                VBox.setVgrow(b, Priority.ALWAYS);
            }

            root.getChildren().add(b);

        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aufgabe 2");
        primaryStage.show();

    }

}
