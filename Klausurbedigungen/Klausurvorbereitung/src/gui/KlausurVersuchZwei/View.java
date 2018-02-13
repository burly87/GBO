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
	private Button add, delete;
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
		listBox =new HBox(5);
		
		games = new ListView<Match>();
		score = new ListView<ScoreEntry>();
		
		add = new Button("Neues Spielergebnis");
		add.setOnAction(e -> addMatch());
		delete = new Button("Spielergebnis löschen");
		delete.setOnAction(e->deleteMatch());
		
		btnBox.getChildren().addAll(add,delete);
		listBox.getChildren().addAll(games,score);
		root.add(listBox, 0, 0);
		root.add(btnBox, 0, 1,2,1);

		return root;
	}
	
	private void resetView() {
		games.getItems().clear();
		games.getItems().addAll(presenter.getGames());
	}
	
	private void updateScores()
	{
		score.getItems().clear();
		score.getItems().addAll(presenter.getScore());
	}
	private void deleteMatch()
	{
		presenter.deleteMatch(games.getSelectionModel().getSelectedItem());
		resetView();
		updateScores();
	}

	private void addMatch()
	{
		presenter.getAddDialog();
		resetView();
		updateScores();
	}

	
}
