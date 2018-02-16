package WS1718;

import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
 * Es muss kein MVP benutzt werden.
 * a) TableView verwenden. (Mit Punktabzug darf auch ListView verwendet werden). Oberflaeche aufgaben. Buttons initialisieren, methoden anlegen, methoden noch leer.
 * b) AddMethode schreiben um neues Obj in Liste hinzuzufuegen. Ausgegangen ist er von einer Pane. es darf auch Dialog verwendet werden, ohne das Punkte abgezogen werden.
 * 	Wichtig ist Ausnahmebehandlung bei fehlerhafter Eingabe.
 * c) DeleteMethode zum loeschen aus der Liste schreiben.
 * d) EditMethode schreiben. Kann neuer Dialog angelegt werden.
 * e) was noch fehlt. man Soll die DoubleWerte aus der Tabelle mit einem eingegebenen Double in einem extra Dialog 
 * prozentual erhoehen. Sprich bei Eingabe 2, werden saemtliche Double mit 1,02 multipliziert.(+2%)
 * 
 * BonusAufgabe) Alerts hinzufuegen. Sollte kein Item ausgewaehlt sein, kommt bei Edit und Delete eine ErrorAlert, "Kein Item ausgewaehlt". 
 * Beim Loeschen eines Obj. muss ein Alert folgen "Sind Sie sich sicher, dass sie das Obj loeschen wollen".
 *
 */


public class View extends Application
{

	private GridPane root;
	private HBox btnBox;

	private ObservableList<StringDoubleProp> obsList;
	private TableView<StringDoubleProp> list;
	private TableColumn<StringDoubleProp, String> names;
	private TableColumn<StringDoubleProp, Double> gehalt;

	private Button add, delete, edit, editAll;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		root = new GridPane();
		btnBox = new HBox();

		obsList = FXCollections.observableArrayList();
		list = new TableView<>(obsList);

		names = new TableColumn<>("Namen");
		gehalt = new TableColumn<StringDoubleProp, Double>("Gehalt");

		names.setCellValueFactory(new PropertyValueFactory<>("string"));
		gehalt.setCellValueFactory(new PropertyValueFactory<>("double"));

		obsList.add(new StringDoubleProp("E8", 100.00));

		list.getColumns().addAll(names, gehalt);
		
		// setup Buttons
		add = new Button("Hinzufuegen");
		delete = new Button("Loeschen");
		edit = new Button("Editieren");
		editAll = new Button("Alles bearbeiten");

		add.setOnAction(e -> add());
		delete.setOnAction(e -> delete());
		edit.setOnAction(e -> edit());
		editAll.setOnAction(e -> editAll());

		btnBox.getChildren().addAll(add, edit, delete, editAll);

		// Init
		root.add(list, 0, 0);
		root.add(btnBox, 0, 1);

		stage.setScene(new Scene(root));
		stage.setTitle("Gehaelter Mitarbeiter - Rheinland-Pfalz 2018");
		stage.show();

	}

	private void editAll()
	{
		EditAllDialog ead = new EditAllDialog();
		Optional<Double> result = ead.showAndWait();
		result.ifPresent(d -> multiply(d));
	}

	private void multiply(Double result)
	{
		for(int i = 0; i < obsList.size(); i++)
		{
			double temp =  obsList.get(i).getDouble();
			
//			result = result*(100);
			temp += result;
			System.out.println(obsList.get(i).getDouble());
			System.out.println(temp);
		}
	}

	private void edit()
	{
		if (getItem() != null)
		{
			StringDoubleProp old = getItem();
			EditDialog ed = new EditDialog(old);
			Optional<StringDoubleProp> result = ed.showAndWait();
			result.ifPresent(obj -> editObj(old, obj));
		} else
		{
			noItemSelctedAlert();
		}
	}

	private void editObj(StringDoubleProp old, StringDoubleProp obj)
	{
		int i = obsList.indexOf(old);
		obsList.remove(i);
		obsList.add(i, obj);
	}

	private StringDoubleProp getItem()
	{
		return list.getSelectionModel().getSelectedItem();
	}

	private void add()
	{
		AddDialog ad = new AddDialog();
		Optional<StringDoubleProp> result = ad.showAndWait();
		result.ifPresent(obj -> addSDP(obj));
	}

	private void addSDP(StringDoubleProp obj)
	{
		obsList.add(obj);
	}

	private void delete()
	{
		if (getItem() != null)
		{
			Alert a = new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("");
			a.setContentText("Wollen Sie das Elemente loeschen?");
			a.showAndWait();

			if (a.getResult() == ButtonType.OK)
			{
				obsList.remove(getItem());
			}
		} else
		{
			noItemSelctedAlert();
		}
	}

	private void noItemSelctedAlert()
	{
		Alert a = new Alert(AlertType.ERROR);
		a.setHeaderText("");
		a.setContentText("Kein Item ausgewaehlt");
		a.showAndWait();
	}

}
