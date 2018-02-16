package Date1502.TableView;

import javax.xml.soap.Detail;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class View
{
	private Presenter presenter;
	
	private GridPane root;
	private VBox labelBox;
	private HBox btnBox;
	private ObservableList<Animal> obsAnimal;
	
	private TableView<Animal> animal;	
	private TableColumn<Animal, String> nameCol, countryCol;
	private TableColumn<Animal, Double> sizeCol, popCol;
	
	private Label nameL, country, size, population ;
	private Button add, delete, undo,redo;
	

	public View(Presenter presenter)
	{
		this.presenter = presenter;
	}

	public Pane initView()
	{
		root = new GridPane();
		labelBox = new VBox();
		nameL = new Label();
		population = new Label();
		country = new Label();
		size= new Label();
		btnBox =new HBox();
			
		obsAnimal = FXCollections.observableArrayList();
		animal = new TableView<Animal>(obsAnimal);
		
		nameCol = new TableColumn<Animal, String>("Name: ");
		countryCol = new TableColumn<Animal, String>("Country: ");
		sizeCol = new TableColumn<Animal, Double>("Größe: ");
		popCol = new TableColumn<Animal, Double>("Population:" );
		
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
		sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
		popCol.setCellValueFactory(new PropertyValueFactory<>("population"));
		
		animal.getColumns().setAll(nameCol,countryCol,sizeCol,popCol);
		initList();
				
		add = new Button("Hinzufuegen");
		delete = new Button("Löschen");
		undo = new Button("Rükgängig");
		redo = new Button("Wiederholen");
		
		add.setOnAction(e-> showAddDialog());
		delete.setOnAction(e -> presenter.delete(animal.getSelectionModel().getSelectedItem()));
		undo.setOnAction(e-> undo());
		redo.setOnAction(e-> redo());
		
		
		labelBox.getChildren().addAll(nameL,country,size, population);
		btnBox.getChildren().addAll(add,delete,undo,redo);
		
		root.add(animal, 0, 0);
		root.add(labelBox, 0, 1);
		root.add(btnBox, 0, 2,2,1);
		
		return root;
	}
	
	private void setLabelText()
	{
		Animal a = animal.getSelectionModel().getSelectedItem();
		if(a != null) 
		{
			String strName = a.getName();
			String strCountry = a.getCountry();
			double dSize = a.getSize();
			double dPop = a.getPopulation();
			
			nameL.setText(strName);
			country.setText(strCountry);
			size.setText(Double.toString(dSize));
			population.setText(Double.toString(dPop));
		}
	}
	

	private void redo()
	{
		presenter.redo();
	}

	private void undo()
	{
		presenter.undo();
	}

	private void showAddDialog()
	{
		presenter.showDialog();
	}

	private void initList()
	{
		animal.getItems().addAll(presenter.getData());
	}

	public void addAnimal(Animal animal)
	{
		obsAnimal.addAll(animal);
	}

	public void deleteAnimal(Animal selectedItem)
	{
		obsAnimal.remove(selectedItem);
	}
	
	public void upDateList(ObservableList<Animal> data)
	{
		animal.getItems().clear();
		animal.getItems().addAll(data);
	}


	
	
}
