package Date1502.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
	
	private ObservableList<Animal> list;
	
	public Model()
	{
		list = FXCollections.observableArrayList();
		list.add(new Animal("Hund", "Deutschland", 2.0, 12312));
	}
	
	
	public ObservableList<Animal> getData()
	{
		return list;
	}


	public void addAnimal(Animal animal)
	{
		list.add(animal);
	}

	public void delete(Animal selectedItem)
	{
		list.remove(selectedItem);
	}

}
