package gui.KlausurVersuchZwei;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddDialog extends Dialog<ButtonType>
{

	private Presenter presenter;
	
	private GridPane root;
	private HBox teamBox, ergBox, btnBox;
	private Label teamsL, ergL, minusL, dotsL;
	private Button add, abord;
	private Label status;
	
	private TextField team1, team2, erg1, erg2;
	
	private Match m;
	
	public void setPresenter(Presenter presenter)
	{
		this.presenter = presenter;
	}
	
	public AddDialog()
	{
		initDialog();
	}
	
	public void initDialog()
	{
		root = new GridPane();
		teamBox = new HBox(5);
		ergBox = new HBox(5);
		btnBox = new HBox(5);
		
		teamsL = new Label("Teams: ");
		ergL = new Label("Ergebnis: ");
		minusL = new Label(" - ");
		dotsL = new Label(" : ");
		status = new Label();
		
		team1 = new TextField();
		team2 = new TextField();
		erg1 = new TextField();
		erg2 = new TextField();
		
		add = new Button("Hinzufuegen");
		add.setOnAction(e -> addMatch());
		abord= new Button("Abbrechen");
		abord.setOnAction(e-> this.setResult(ButtonType.CANCEL));
		
		
		teamBox.getChildren().addAll(teamsL,team1, minusL, team2 );
		ergBox.getChildren().addAll(ergL, erg1, dotsL, erg2);
		btnBox.getChildren().addAll(add, abord);
		root.add(teamBox, 0, 0);
		root.add(ergBox, 0, 1);
		root.add(btnBox, 0, 2,4,1);
		root.add(status, 0, 3,4,1);
		
		getDialogPane().setContent(root);
	}

	public void addMatch()
	{
		generateMatch();
		presenter.addMatch(m);
		this.setResult(ButtonType.OK);
	}
	
	private void generateMatch()
	{
		try
		{
			if(Integer.parseInt(erg1.getText()) >=0 && Integer.parseInt(erg2.getText())>=0 && erg1.getText() != "" && erg2.getText()!="" )
			{
				m = new Match(team1.getText(), team2.getText(), Integer.parseInt(erg1.getText()), Integer.parseInt(erg2.getText()));
			}
			
		}
		catch(NumberFormatException e)
		{
			status.setText("Ergebnis: Ungültige Eingabe");
		}
	}

}
