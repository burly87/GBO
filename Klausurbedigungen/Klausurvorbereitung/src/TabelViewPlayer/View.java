package TabelViewPlayer;

import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class View
{
	private Presenter presenter;

	private Pane root;
	
	private TableView<Player> tableView;

	public View(Presenter presenter)
	{
		this.presenter = presenter;
	}

	public Pane initView()
	{
		root = new Pane();
		
		tableView = new TableView<Player>();
		
		TableColumn<Player, String> vorNameCol = new TableColumn<>("Vorname");
		TableColumn<Player, String> nachNameCol = new TableColumn<>("Nachname");
		TableColumn<Player, String> posCol = new TableColumn<>("Position");
		TableColumn<Player, Integer> gameCol = new TableColumn<>("Spiele gesammt");
		
		vorNameCol.setCellValueFactory(new PropertyValueFactory<>("vorName"));
		nachNameCol.setCellValueFactory(new PropertyValueFactory<>("nachName"));
		posCol.setCellValueFactory(new PropertyValueFactory<>("position"));
		gameCol.setCellValueFactory(new PropertyValueFactory<>("games"));
		
		tableView.getColumns().addAll(vorNameCol,nachNameCol,posCol,gameCol);
		initList();
		root.getChildren().add(tableView);
		
		return root;
	}

	public void initList()
	{
		tableView.getItems().addAll(presenter.getPlayerList());
	}
	
}
