package WS1718;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EditDialog extends Dialog<StringDoubleProp>
{

	private StringDoubleProp std;
	private GridPane root;
	private Button add,  abord;
	private HBox btnBox, box1, box2;
	
	private Label name, gehalt;
	
	private TextField txtName, txtGehalt;

	public EditDialog(StringDoubleProp sdp)
	{

		root = new GridPane();

		btnBox = new HBox();
		txtName = new TextField(sdp.getS());
		txtGehalt = new  TextField(Double.toString(sdp.getD()));
		box1 = new HBox();
		box2 = new HBox();
		
		
		name = new Label("Name: ");
		gehalt = new Label("Gehalt: ");

		getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		add = (Button) getDialogPane().lookupButton(ButtonType.OK);
		add.setText("Editieren");
		abord = (Button) getDialogPane().lookupButton(ButtonType.CANCEL);
		abord.setText("Abbrechen");

		checkIfPossible();
		setResultConverter(a -> generateStringDoubleProp());

		btnBox.getChildren().addAll(add,abord);
		box1.getChildren().addAll(name,txtName);
		box2.getChildren().addAll(gehalt, txtGehalt);
		
		root.add(box1, 0, 0);
		root.add(box2, 0, 1);
		root.add(btnBox, 0, 2);
		
		getDialogPane().setContent(root);
	}

	private void checkIfPossible()
	{
		add.addEventFilter(ActionEvent.ACTION, event -> {
			try
			{
				std = new StringDoubleProp(txtName.getText(), Double.parseDouble(txtGehalt.getText()));

			} catch (Exception e)
			{
				event.consume();
			}
		});
	}

	private StringDoubleProp generateStringDoubleProp()
	{
		return std;
	}

	
}
