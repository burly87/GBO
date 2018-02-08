package TabelViewPlayer;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class View
{
	private Presenter presenter;

	private GridPane root;

	private TableView<Player> tableView;
	private Button delete, add, testView;
	private HBox btnBox;

	public View(Presenter presenter)
	{
		this.presenter = presenter;
	}

	public Pane initView()
	{
		root = new GridPane();
		btnBox = new HBox();

		delete = new Button("Loeschen");
		delete.setOnAction(e -> showDeleteDialog());
		add = new Button("Hinzufuegen");
		add.setOnAction(e -> addPlayer());
		testView = new Button("Editieren");
		testView.setOnAction(e -> editorView());

		tableView = new TableView<Player>();

		TableColumn<Player, String> vorNameCol = new TableColumn<>("Vorname");
		TableColumn<Player, String> nachNameCol = new TableColumn<>("Nachname");
		TableColumn<Player, String> posCol = new TableColumn<>("Position");
		TableColumn<Player, Integer> gameCol = new TableColumn<>("Spiele gesammt");

		vorNameCol.setCellValueFactory(new PropertyValueFactory<>("vorName"));
		nachNameCol.setCellValueFactory(new PropertyValueFactory<>("nachName"));
		posCol.setCellValueFactory(new PropertyValueFactory<>("position"));
		gameCol.setCellValueFactory(new PropertyValueFactory<>("games"));

		tableView.getColumns().addAll(vorNameCol, nachNameCol, posCol, gameCol);
		initList();

		btnBox.getChildren().addAll(delete, add, testView);
		root.add(tableView, 0, 0);
		root.add(btnBox, 0, 1);

		return root;
	}

	private void editorView()
	{
		presenter.showEditorDialog();
		resetView();
	}

	private void addPlayer()
	{
		presenter.showEditDialog();
		resetView();
	}

	public void showDeleteDialog()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("");
		alert.setContentText("Soll die Frage geloescht werden?");
		Optional<ButtonType> choose = alert.showAndWait();
		if(choose.get()==ButtonType.OK)
		{
			delete();
		}
	}
	
	
	private void delete()
	{
		presenter.delete(tableView.getSelectionModel().getSelectedItem());
	}

	public void initList()
	{
		tableView.getItems().addAll(presenter.getPlayerList());
	}

	public void resetView()
	{
		tableView.getItems().clear();
		tableView.getItems().addAll(presenter.getPlayerList());
	}

	public Player getItem()
	{		
		return tableView.getSelectionModel().getSelectedItem();
	}

}
