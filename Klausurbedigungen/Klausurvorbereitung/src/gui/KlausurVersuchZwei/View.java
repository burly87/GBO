package gui.KlausurVersuchZwei;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
		
		undo =  new Button("UNDO");
		undo.setOnAction(e->undo());
		redo = new Button("REDO");
		redo.setOnAction(e->redo());
		
		games = new ListView<Match>();
		score = new ListView<ScoreEntry>();
		
		add = new Button("Neues Spielergebnis");
		add.setOnAction(e -> addMatch());
		delete = new Button("Spielergebnis löschen");
		delete.setOnAction(e-> deleteMatch());
		
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
		presenter.deleteMatch(games.getSelectionModel().getSelectedItem());
		updateScores();
	}

	private void addMatch()
	{
		presenter.getAddDialog();
		updateScores();
	}

	
}
