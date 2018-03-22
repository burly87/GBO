package gui.stayFit;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StayFit extends Application
{

    private Pane root;

    private BorderPane borderPane;

    private HBox btnBox;

    private Button add, delete, edit;

    private ObservableList<StayFitObject> list;

    private ListView viewList;

    @Override
    public void start(Stage stage) throws Exception
    {
        list = FXCollections.observableArrayList();
        list.add(new StayFitObject("Test", 1.2, 2.2));

        root = new Pane();
        btnBox = new HBox(5);
        borderPane = new BorderPane();

        add = new Button("Add");
        delete = new Button("Delete");
        edit = new Button("Edit");

        btnBox.getChildren().addAll(add, delete, edit);
        root.getChildren().addAll(borderPane, btnBox);

        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Test");
        stage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
