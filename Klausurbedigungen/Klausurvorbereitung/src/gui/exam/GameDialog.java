package gui.exam;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GameDialog extends Dialog<ButtonType>
{
	private Presenter presenter;

	private GridPane root;
	private HBox teamBox, ergBox, btnBox;
	
	private Label teams, ergebnis, minus, doppelpunkt;

	private TextField team1, team2, erg1, erg2;
	private Button add, abord;
	private Label status;
	
	private Match newMatch;

	public void setPresenter(Presenter presenter)
	{
		this.presenter = presenter;
	}

	public GameDialog()
	{
		
		root = new GridPane();
		teamBox = new HBox();
		ergBox = new HBox();
		btnBox = new HBox();

		team1 = new TextField();
		team2 = new TextField();
		erg1 = new TextField();
		erg2 = new TextField();
		status = new Label();

		add = new Button("Hinzufuegen");
		add.setOnAction(e-> addMatch());
		abord = new Button("Abbrechen");
		abord.setOnAction(e -> this.setResult(ButtonType.CANCEL));

		teams = new Label("Teams: ");
		ergebnis = new Label("Ergebnis: ");
		minus = new Label(" - ");
		doppelpunkt = new Label(" : ");

		teamBox.getChildren().addAll(teams, team1, minus, team2);
		ergBox.getChildren().addAll(ergebnis, erg1, doppelpunkt, erg2);
		btnBox.getChildren().addAll(add, abord);
		root.add(teamBox, 0, 0);
		root.add(ergBox, 0, 1);
		root.add(btnBox, 0, 2, 4, 1);
		root.add(status, 0, 4, 4, 1);
		
		getDialogPane().setContent(root);
	}

	public void addMatch()
	{
		generateMatch();
		presenter.addMatch(newMatch);
		this.setResult(ButtonType.OK);
	}

	private void generateMatch()
	{
		try
		{
			String strTeam1 = team1.getText();
			String strTeam2 = team2.getText();
			int strErg1 = Integer.parseInt(erg1.getText());
			int strErg2 = Integer.parseInt(erg2.getText());
			newMatch = new Match(strTeam1, strTeam2, strErg1, strErg2);
		}
		catch(NumberFormatException e)
		{
			status.setText("Fehlerhafte Eingabe");
		}
		
	}



}
