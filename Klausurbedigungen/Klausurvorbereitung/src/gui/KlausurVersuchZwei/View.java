package gui.KlausurVersuchZwei;

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
		undo =  new Button("UNDO");
		redo = new Button("REDO");
		
		games = new ListView<Match>();
		score = new ListView<ScoreEntry>();
		
		add.setOnAction(e -> addMatch());
		delete.setOnAction(e-> deleteMatch());
		undo.setOnAction(e-> undo());
		redo.setOnAction(e-> redo());
		
		btnBox.getChildren().addAll(add,delete, undo, redo);
		listBox.getChildren().addAll(games,score);
		root.add(listBox, 0, 0);
		root.add(btnBox, 0, 1,2,1);

		return root;
	}
	
	private void undo()
	{
		presenter.undo();
	}

	private void redo()
	{
		presenter.redo();
	}

	private void resetView() {
		games.getItems().clear();
		games.getItems().addAll(presenter.getGames());
	}
	
	public void updateScores()
	{
		score.getItems().clear();
		score.getItems().addAll(presenter.getScore());
		resetView();
	}
	private void deleteMatch()
	{
		showWarning();
		
		presenter.deleteMatch(games.getSelectionModel().getSelectedItem());
		updateScores();
	}

	public void showWarning()
	{
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText("");
		a.setContentText("LÖÖÖSCHEN?");
		a.showAndWait();
	}

	private void addMatch()
	{
		presenter.getAddDialog();
		updateScores();
	}

	
}
