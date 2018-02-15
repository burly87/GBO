package Date1502.ListView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class View
{
	private Presenter presenter;
	private GridPane root;
	private ListView<Country> countryList;
	private Label cName, cPop, cSize;
	private VBox labelBox;
	private HBox btnBox;
	private Button add, delete, undo, redo, edit;

	public View(Presenter presenter)
	{
		this.presenter = presenter;
	}

	public Pane iniView()
	{
		root = new GridPane();
		labelBox = new VBox(5);
		btnBox = new HBox(5);

		cName = new Label();
		cPop = new Label();
		cSize = new Label();

		add = new Button("Hinzufügen");
		delete = new Button("Löschen");
		undo = new Button("Rückgängig");
		redo = new Button("Wiederholen");
		edit = new Button("Editieren");

		add.setOnAction(e -> openDialog());
		delete.setOnAction(e -> deleteCountry());
		edit.setOnAction(e-> editCountry());
		undo.setOnAction(e-> undo());
		redo.setOnAction(e-> redo());
		
		countryList = new ListView<Country>(presenter.getData());
		countryList.setOnMouseClicked(e -> setLabelText());

		labelBox.getChildren().addAll(cName, cPop, cSize);
		btnBox.getChildren().addAll(add, delete, edit, undo, redo);
		root.add(btnBox, 0, 2);
		root.add(countryList, 0, 0);
		root.add(labelBox, 1, 0);

		return root;
	}

	private void redo()
	{
		presenter.redo();
	}

	private void undo()
	{
		presenter.undo();
	}

	private void editCountry()
	{
		presenter.openEditDialog();
	}

	private void deleteCountry()
	{
		presenter.deleteCountry(getItem());
	}

	private void openDialog()
	{
		presenter.openDialog();
	}

	public void setLabelText()
	{
		if (countryList.getSelectionModel().getSelectedItem() != null)
		{
			Country selected = countryList.getSelectionModel().getSelectedItem();

			cName.setText("Name des Landes: " + selected.getName());
			cPop.setText("Population: " + Integer.toString(selected.getPopulation()));
			cSize.setText("Größe: " + Integer.toString(selected.getSize()));
		}

	}

	public Country getItem()
	{
		return countryList.getSelectionModel().getSelectedItem();
	}

}
