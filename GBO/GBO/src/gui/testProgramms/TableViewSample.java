package gui.testProgramms;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewSample extends Application
{
    private TableView<Person> table = new TableView<Person>();

    private final ObservableList<Person> data = FXCollections.observableArrayList(new Person("Tobias", "Forve", "tobias.forve@gmx.de"), new Person("TEst", "test", "Test@test.de"));

    @Override
    public void start(Stage stage) throws Exception
    {

        Scene scene = new Scene(new Group());
        stage.setTitle("TableViewSample");
        stage.setHeight(500);
        stage.setWidth(450);

        final Label label = new Label("AdressBook");
        label.setFont(new Font("Arial", 20));

        // table = new TableView();
        table.setEditable(true);

        TableColumn column1 = new TableColumn("First Name");
        TableColumn column2 = new TableColumn("Last Name");
        TableColumn column3 = new TableColumn("Email");

        column1.setMinWidth(100);
        column2.setMinWidth(100);
        column3.setMinWidth(200);

        column1.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        column2.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        column3.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));

        table.setItems(data);
        table.getColumns().addAll(column1, column2, column3);

        final VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
