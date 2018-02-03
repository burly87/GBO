package Klausurvorbereitung.Uebung4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Paneexample extends Application
{
    private VBox pane;

    @Override
    public void start(Stage stage) throws Exception
    {
        pane = new VBox();
        pane.setAlignment(Pos.TOP_RIGHT);

        for (int i = 0; i <= 4; i++)
        {
            Button b = new Button("Button " + i);
            pane.getChildren().add(b);

            if (i == 1 || i == 4)
            {
                b.setMaxWidth(Double.MAX_VALUE);
            }

            if (i == 2)
            {
                b.setMaxWidth(Double.MAX_VALUE);
                b.setMaxHeight(Double.MAX_VALUE);
                VBox.setVgrow(b, Priority.ALWAYS);
            }
        }

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
