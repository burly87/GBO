package Country;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CountryEditView extends Stage
{
	private CountryInfo countryInfo;
	private TextField txtLand, txtStadt, txtPeople, txtFlaeche;
	private VBox pane;
	private Button edit;
	private Country old;
	
	public void setCountryInfo(CountryInfo countryInfo)
	{
		this.countryInfo = countryInfo;
	}
	
	public CountryEditView(Country c)
	{
		old = c;
		pane = new VBox();
		edit = new Button("Speichern");
		txtLand = new TextField();
		txtStadt = new TextField();
		txtPeople = new TextField();
		txtFlaeche = new TextField();
		
		txtLand.setText(c.getName());
		txtStadt.setText(c.getCapital());
		txtPeople.setText(Long.toString(c.getPeople()));
		txtFlaeche.setText(Long.toString(c.getArea()));
		
		edit.setOnAction(e -> editC());
		
		pane.getChildren().addAll(txtLand,txtStadt,txtPeople,txtFlaeche,edit);
		
		this.setScene(new Scene(pane,300,400));
	}

	private void editC()
	{
		Country n = new Country(txtLand.getText(),txtStadt.getText() , Long.parseLong(txtPeople.getText()), Long.parseLong(txtFlaeche.getText()));
		countryInfo.saveEdit(old,n);
		this.close();
	}
	
	
}
