package Date1502.TableView.ExtraDialogs;

import Date1502.TableView.Animal;
import Date1502.TableView.Model;
import Date1502.TableView.View;

public class AnimalAddHandle implements AnimalInterface
{
	private Model model;
	private Animal animal;
	private View view;

	
	
	public AnimalAddHandle(Model model, Animal animal, View view)
	{
		super();
		this.model = model;
		this.animal = animal;
		this.view = view;
	}

	@Override
	public void undo()
	{
		view.deleteAnimal(animal);
		model.delete(animal);
	}

	@Override
	public void redo()
	{
		view.addAnimal(animal);
		model.addAnimal(animal);
		
	}

}
