package Date1502.TableView.ExtraDialogs;

import Date1502.TableView.Animal;
import Date1502.TableView.Presenter;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddDialog extends Dialog<Animal>
{
	private Presenter presenter;
	private Animal animal;
	
	private GridPane root;
	private VBox txtBox;
	private HBox btnBox;
	
	private TextField tfName,tfCountry,tfSize,tfPop;
	private Button add, cancel;
	private Label status;
	

	public void setPresenter(Presenter presenter)
	{
		this.presenter = presenter;
	}

	public AddDialog()
	{
		root = new GridPane();
		setTitle("Hinzufügen von Animal");
		txtBox = new VBox();
		btnBox = new HBox();
		
		status = new Label();
		
		tfName = new TextField();
		tfName.setPromptText("Name");
		tfCountry = new TextField();
		tfCountry.setPromptText("Land");
		tfSize = new TextField();
		tfSize.setPromptText("Größe");
		tfPop = new TextField();
		tfPop.setPromptText("Population");
		
		///////////////////////////
		getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
		///////////////////////////
		add = (Button)getDialogPane().lookupButton(ButtonType.OK);
		add.setText("Hinzufügen");
		cancel = (Button)getDialogPane().lookupButton(ButtonType.CANCEL);
		cancel.setText("Abbrechen");
		///////////////////////////
		checkIfPossible();
		///////////////////////////
		setResultConverter(a -> generateAnimal(a));
		///////////////////////////
		
		btnBox.getChildren().addAll(add,cancel);
		txtBox.getChildren().addAll(tfName,tfCountry,tfSize,tfPop);
		root.add(txtBox, 0, 0);
		root.add(btnBox, 1, 0);
		root.add(status, 0, 2,4,1);
		
		///////////////////////////
		getDialogPane().setContent(root);
		///////////////////////////
	}
	

	private void checkIfPossible()
	{
		add.addEventFilter(ActionEvent.ACTION, event-> {
			try {
				animal = new Animal(tfName.getText(), tfCountry.getText(), Double.parseDouble(tfSize.getText()), Double.parseDouble(tfPop.getText()));
				
			}
			catch(Exception e)
			{
				status.setText("Ungültige Eingabe");
				event.consume();
			}
		});
	}

	private Animal generateAnimal(ButtonType a)
	{
		return animal;
	}
}
