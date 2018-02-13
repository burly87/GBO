package TabelleMVP;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
	private ObservableList<Animal> animal;
	
	public Model()
	{
		animal = FXCollections.observableArrayList();
		
		animal.add(new Animal("Dackel", "Hund", "Deutschland", 500000));
		animal.add(new Animal("Pudel", "Hund", "Deutschland", 14142));
		
	}

	public ObservableList<Animal> getData()
	{
		return animal;
	}
	
	public Animal getAnimal()
	{
		
		for(int i = 0; i<= animal.size(); i++)
		{
			System.out.println(animal.get(i));
			return animal.get(i);
			
		}
		return null;
	}
			
	
	
}
