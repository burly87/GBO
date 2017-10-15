package gui.uebungen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main01 extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Label l = new Label("Hallo Welt");
        Label l2 = new Label("test");
        /* GridPane */
        GridPane root = new GridPane();
        root.add(l, 0, 0);
        root.add(l2, 0, 1);

        /* StackPane */
        // StackPane root = new StackPane(); //StackPane ben�tigt
        // .getChildren().add()

        // root.getChildren().add(l);
        // root.getChildren().add(l2);
        // kommt container �ber getChildren
        // zur�ck und da drauf wird add angewendet

        /* Scene */ // immer notwendig
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main01 Titel");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
