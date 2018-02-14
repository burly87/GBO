package gui.KlausurVersuchZwei;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddDialog extends Dialog<Match>
{
	private GridPane root;
	private HBox teamBox, ergBox, btnBox;
	private Label teamsL, ergL, minusL, dotsL;
	private Button add, abord;
	private Label status;
	private TextField team1, team2, erg1, erg2;
	private Match m;

	public AddDialog()
	{
		initDialog();
	}

	public void initDialog()
	{
		// Initialize Components
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

		// Buttons
		getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		add = (Button) getDialogPane().lookupButton(ButtonType.OK);
		add.setText("Hinzufuegen");
		abord = (Button) getDialogPane().lookupButton(ButtonType.CANCEL);
		abord.setText("Abbrechen");

		checkIfPossible();

		setResultConverter(b -> generateMatch(b));

		// add Components
		teamBox.getChildren().addAll(teamsL, team1, minusL, team2);
		ergBox.getChildren().addAll(ergL, erg1, dotsL, erg2);
		btnBox.getChildren().addAll(add, abord);

		root.add(teamBox, 0, 0);
		root.add(ergBox, 0, 1);
		root.add(btnBox, 0, 2, 4, 1);
		root.add(status, 0, 3, 4, 1);

		getDialogPane().setContent(root);
	}

	private void checkIfPossible()
	{
		add.addEventFilter(ActionEvent.ACTION, event -> {
			try
			{
				m = new Match(team1.getText(), team2.getText(), Integer.parseInt(erg1.getText()),
						Integer.parseInt(erg2.getText()));
			} catch (Exception e)
			{
				status.setText("Ungueltige Eingabe");
				event.consume();
			}
		});
	}

	private Match generateMatch(ButtonType b)
	{
		if (b == ButtonType.OK)
		{
			return m;
		}
		return m;
	}

}
