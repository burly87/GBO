package gui.plusminus;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlusMinus extends Application
{

    private int counter = 0;

    public void start(Stage primaryStage)
    {

        Button plus = new Button("+");
        Button minus = new Button("-");
        Label counterL = new Label(String.valueOf(counter));

        plus.setId("plus");
        minus.setId("minus");
        counterL.setId("counterL");

        GridPane root = new GridPane();
        root.add(plus, 0, 0);
        root.add(counterL, 0, 1);
        root.add(minus, 0, 2);

        plus.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                counter++;
                counterL.setText(String.valueOf(counter));
            }

        });

        minus.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                counter--;
                counterL.setText(String.valueOf(counter));
            }

        });

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("PlusMinus");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
