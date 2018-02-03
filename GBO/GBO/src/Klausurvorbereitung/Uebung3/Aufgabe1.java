package Klausurvorbereitung.Uebung3;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Aufgabe1 extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();

        SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop3 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop4 = new SimpleIntegerProperty();

        prop1.bind(prop2);
        prop2.bind(prop3);
        prop3.bind(prop4);
        prop4.set(2);

        System.out.println(prop1.get());

        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene);
        stage.setTitle("propertyBinding");
        stage.show();

    }

    public static void main(String[] args)
    {

        launch(args);
    }

}
