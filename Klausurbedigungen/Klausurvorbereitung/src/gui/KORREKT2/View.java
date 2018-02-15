package gui.KORREKT2;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class View
{
	private Presenter presenter;

	private GridPane root;
	private Button add, delete, undo, redo;
	private HBox btnBox;
	private HBox listBox;

	private ListView<Match> games;
	private ListView<ScoreEntry> score;

	private ObservableList<Match> gameList;
	private ObservableList<ScoreEntry> scoreList;

	public View(Presenter presenter)
	{
		this.presenter = presenter;
	}

	public Pane initView()
	{
		root = new GridPane();
		btnBox = new HBox(5);
		listBox = new HBox(5);

		add = new Button("Neues Spielergebnis");
		delete = new Button("Spielergebnis löschen");
		undo = new Button("UNDO");
		redo = new Button("REDO");

		scoreList = FXCollections.observableArrayList();
		gameList = FXCollections.observableArrayList();
		games = new ListView<Match>(gameList);
		score = new ListView<ScoreEntry>(scoreList);
		
		add.setOnAction(e -> openDialog());
		delete.setOnAction(e -> presenter.deleteMatch(games.getSelectionModel().getSelectedItem()));

		btnBox.getChildren().addAll(add, delete, undo, redo);
		listBox.getChildren().addAll(games, score);
		root.add(listBox, 0, 0);
		root.add(btnBox, 0, 1, 2, 1);

		return root;
	}

	private void openDialog()
	{
		AddDialog a = new AddDialog();
		Optional<Match> result = a.showAndWait();
		result.ifPresent(match -> presenter.addMatch(match));
	}

	public void updateScores(ScoreEntry[] s)
	{
		scoreList.clear();
		scoreList.addAll(s);
	}

	public void deleteMatch(Match match)
	{
		gameList.remove(match);
	}

	public void addMatch(Match match)
	{
		gameList.add(match);
	}

	public void showWarning()
	{
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText("");
		a.setContentText("LÖÖÖSCHEN?");
		a.showAndWait();
	}
}