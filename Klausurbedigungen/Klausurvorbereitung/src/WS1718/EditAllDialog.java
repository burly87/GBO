package WS1718;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EditAllDialog extends Dialog<Double>
{
	private double proz;
	private GridPane root;
	private Button add, abord;
	private HBox btnBox, box1;

	private Label gehalt, status;
	private TextField txtGehalt;

	public EditAllDialog()
	{

		root = new GridPane();

		btnBox = new HBox();
		txtGehalt = new TextField();
		box1 = new HBox();

		gehalt = new Label("Prezent: ");
		status = new Label();

		getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		add = (Button) getDialogPane().lookupButton(ButtonType.OK);
		add.setText("Aufaddieren");
		abord = (Button) getDialogPane().lookupButton(ButtonType.CANCEL);
		abord.setText("Abbrechen");

		checkIfPossible();
		setResultConverter(a -> generateStringDoubleProp());

		btnBox.getChildren().addAll(add, abord);
		box1.getChildren().addAll(gehalt, txtGehalt);

		root.add(box1, 0, 0);
		root.add(btnBox, 0, 2);
		root.add(status, 0, 3, 4, 1);

		getDialogPane().setContent(root);
	}

	private void checkIfPossible()
	{
		add.addEventFilter(ActionEvent.ACTION, event -> {
			try
			{
				if (!"".equals(txtGehalt.getText()))
				{
					proz = Double.parseDouble(txtGehalt.getText());
				} else
				{
					status.setText("Fehlerhafte Eingabe");
					event.consume();
				}

			} catch (Exception e)
			{
				status.setText("Fehlerhafte Eingabe");
				event.consume();
			}
		});
	}

	private double generateStringDoubleProp()
	{
		return proz;
	}

}
