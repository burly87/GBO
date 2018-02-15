package Date1502.ListView;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CountryEditDialog extends Dialog<Country>
{
	private Presenter presenter;
	private GridPane root;
	private VBox fieldBox;
	private TextField name, pop, size;
	private Button ok, cancle;
	private Country countryNew, old;
	private Label status;

	public void setPresenter(Presenter presenter)
	{
		this.presenter = presenter;
	}

	public CountryEditDialog(Country c, boolean b)
	{
		root = new GridPane();
		fieldBox = new VBox();
		name = new TextField();
		pop = new TextField();
		size = new TextField();

		old = c;
		status = new Label();
		
		getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
		ok = (Button) getDialogPane().lookupButton(ButtonType.OK);
		cancle = (Button) getDialogPane().lookupButton(ButtonType.CANCEL);

		if (b)
		{
			name.setText(c.getName());
			pop.setText(Integer.toString(c.getPopulation()));
			size.setText(Integer.toString(c.getSize()));
			ok.setText("Editieren");
			cancle.setText("Änderung verwerfen");
		} else
		{
			name.setPromptText("Name");
			pop.setPromptText("Population");
			size.setPromptText("Größe");
			ok.setText("Hinzufügen");
			cancle.setText("Abbrechen");
		}

		checkIfPossible();
		setResultConverter(e -> generateNewCountry());

		fieldBox.getChildren().addAll(name, pop, size);
		root.add(fieldBox, 0, 0);
		root.add(status, 0, 1);

		getDialogPane().setContent(root);

	}

	private void checkIfPossible()
	{
		ok.addEventFilter(ActionEvent.ACTION, event -> {
			try
			{
				if (!"".equals(name.getText()))
				{
					countryNew = new Country(name.getText(), Integer.parseInt(pop.getText()),
							Integer.parseInt(size.getText()));
				} else
				{
					status.setText("Fehlerhafte Eingabe");
					event.consume();
				}
			} catch (NumberFormatException ex)
			{
				status.setText("Fehlerhafte Eingabe");
				event.consume();
			}
		});
	}

	private Country generateNewCountry()
	{
		return countryNew;
	}

}
