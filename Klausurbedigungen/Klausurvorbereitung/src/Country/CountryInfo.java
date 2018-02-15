package Country;

import javax.sound.midi.Synthesizer;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CountryInfo extends Application
{

	private ComboBox<Country> eNum;
	private ObservableList<Country> countries;

	private GridPane root;
	private VBox vLeft, vRight;
	private CheckBox roundingBox;
	private Label land, hauptstadt, einwohner, flaeche, dichte;
	private Label aLand, aHauptstadt, aEinwohner, aFlaeche, aDichte;
	
	private Button add, delete, edit;
	private HBox addBox;
	private TextField txtLand, txtStadt, txtPeople, txtFlaeche;

	@Override
	public void start(Stage stage) throws Exception
	{
		root = new GridPane();
		vLeft = new VBox();
		vRight = new VBox();

		countries = FXCollections.observableArrayList();
		eNum = new ComboBox<Country>(countries);

		countries.add(new Country("Deutschland", "Berlin", 8916800, 1000000));
		countries.add(new Country("Luxembourg", "Luxembourg", 5118, 3600));
		countries.add(new Country("Belgien", "Bruessel", 11000230, 31001));

		// create Components
		add = new Button("Hinzufuegen");
		delete = new Button("Loeschen");
		edit = new Button("Editieren");
		addBox = new HBox();
		txtLand = new TextField();
		txtStadt = new TextField();
		txtPeople = new TextField();
		txtFlaeche = new TextField();

		// Labels
		roundingBox = new CheckBox("Runden");
		land = new Label("Land: ");
		hauptstadt = new Label("Hauptstadt: ");
		einwohner = new Label("Einwohner: ");
		flaeche = new Label("Flaeche: ");
		dichte = new Label("Dichte: ");

		// Ausgaben
		aLand = new Label();
		aHauptstadt = new Label();
		aEinwohner = new Label();
		aFlaeche = new Label();
		aDichte = new Label();

		// Add Components
		root.add(eNum, 0, 0);
		root.add(roundingBox, 0, 1);
		root.add(vLeft, 0, 2);
		root.add(vRight, 1, 2);
		root.add(addBox, 0, 3, 3, 1);

		vLeft.getChildren().addAll(land, hauptstadt, einwohner, flaeche, dichte);
		vRight.getChildren().addAll(aLand, aHauptstadt, aEinwohner, aFlaeche, aDichte);
		addBox.getChildren().addAll(txtLand, txtStadt, txtPeople, txtFlaeche);
		root.add(add, 0, 4);
		root.add(delete, 1, 4);
		root.add(edit, 2,4);

		eNum.getSelectionModel().selectFirst();
		anzeige();
		// Button Actions
		eNum.setOnAction(e -> anzeige());
		add.setOnAction(e -> addCountry());
		delete.setOnAction(e -> deleteCountry());
		edit.setOnAction(e-> edit(countries.get(eNum.getSelectionModel().getSelectedIndex())));		
		
		// setScene
		Scene scene = new Scene(root, 700, 300);
		stage.setScene(scene);
		stage.setTitle("Laender Info");
		stage.show();

	}



	private Country edit(Country country)
	{
		getEditViewDialog(country);
		return country;
	}

	private void getEditViewDialog(Country c)
	{
		CountryEditView cev = new CountryEditView(c);
		cev.showAndWait();
	}



	private void deleteCountry()
	{
		try
		{
			if (countries != null)
			{
				Country selected = eNum.getSelectionModel().getSelectedItem();
				eNum.getItems().remove(selected);
				countries.get(eNum.getSelectionModel().getSelectedIndex());
			}
		} catch (ArrayIndexOutOfBoundsException e)
		{
			if (eNum.getSelectionModel().getSelectedIndex() == -1)
			{
				eNum.getSelectionModel().select(0);
			}
			System.out.println("Leere liste");
			
		}
	}

	private void addCountry()
	{
		String strLand = txtLand.getText();
		String strStadt = txtStadt.getText();
		String strPeople = txtPeople.getText();
		String strFlaeche = txtFlaeche.getText();
		long lPeople = Long.parseLong(strPeople);
		long lFlaeche = Long.parseLong(strFlaeche);

		if (!"".equals(txtLand.getText()) && !"".equals(txtStadt.getText()))
		{
			countries.add(new Country(strLand, strStadt, lPeople, lFlaeche));
		}

		txtLand.clear();
		txtFlaeche.clear();
		txtPeople.clear();
		txtStadt.clear();
	}

	private void anzeige()
	{
		Country name = eNum.getSelectionModel().getSelectedItem();
		aLand.setText(name.getName());
		aHauptstadt.setText(name.getCapital());
		aEinwohner.setText("" + name.getPeople());
		aFlaeche.setText("" + name.getArea());
		aDichte.setText(Long.toString(name.getDichte()));
	}

	public static void main(String[] args)
	{
		launch(args);
	}

	public void saveEdit(Country old, Country n)
	{
		int i = countries.indexOf(old);
		countries.remove(i);
		countries.add(i,n);
	}
}
