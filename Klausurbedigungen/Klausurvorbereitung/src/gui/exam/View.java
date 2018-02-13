package gui.exam;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class View
{

	private Presenter presenter;
	private GameDialog gameDialog;

	private ListView<Match> games;
	private ListView<ScoreEntry> score;
	private Button addGame, deleteGame;

	private GridPane root;
	private HBox btnBox;

	public View(Presenter presenter)
	{
		this.presenter = presenter;

	}

	public Pane initView()
	{
		games = new ListView<Match>();
		score = new ListView<ScoreEntry>();

		root = new GridPane();
		btnBox = new HBox();

		addGame = new Button("Neues Spielergebnis");
		deleteGame = new Button("Spielergebnis loeschen");
		
		addGame.setOnAction(e -> addMatch());
		deleteGame.setOnAction(e -> deleteMatch());

		btnBox.getChildren().addAll(addGame, deleteGame);
		root.add(games, 0, 0);
		root.add(score, 1, 0);
		root.add(btnBox, 0, 1, 2, 1);

		return root;
	}

	public void addMatch()
	{
		presenter.initDialog();
		updateScores();
		resetView();
	}

	private void resetView()
	{
		games.getItems().clear();
		games.getItems().addAll(presenter.setGames());
	}

	public void deleteMatch()
	{
		presenter.deleteMatch(games.getSelectionModel().getSelectedItem());
		resetView();
		updateScores();
	}

	public void updateScores()
	{
		score.getItems().clear();
		score.getItems().addAll(presenter.setScore());
		
	}
	
}
