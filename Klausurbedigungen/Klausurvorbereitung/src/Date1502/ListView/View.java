package Date1502.ListView;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class View
{
	private Presenter presenter;
	private GridPane root;
	private ListView<Country> countryList;
	private Label cName, cPop, cSize;
	private VBox labelBox;

	public View(Presenter presenter)
	{
		this.presenter = presenter;
	}

	public Pane iniView()
	{
		root = new GridPane();
		labelBox = new VBox(5);
		cName = new Label("test");
		cPop = new Label();
		cSize = new Label();
		
		countryList = new ListView<Country>(presenter.getData());
		countryList.setOnMouseClicked(e -> setLabelText());
		
		labelBox.getChildren().addAll(cName, cPop, cSize);
		root.add(countryList, 0, 0);
		root.add(labelBox, 1, 0);
			
		return root;
	}
	
	public void setLabelText()
	{
		if(countryList.getSelectionModel().getSelectedItem() != null)
		{
			Country selected = countryList.getSelectionModel().getSelectedItem();
			
			cName.setText("Name des Landes: " + selected.getName());
			cPop.setText("Population: "+ Integer.toString(selected.getPopulation()));
			cSize.setText("Größe: "+ Integer.toString(selected.getSize()));
		}
		
	}
	
	
	

}
