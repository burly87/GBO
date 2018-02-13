package TabelleMVP;

import javafx.collections.ObservableList;

public class Presenter
{
	private Model model;
	private View view;

	public void setModel(Model model)
	{
		this.model = model;
	}

	public void setView(View view)
	{
		this.view = view;
	}

	public Presenter()
	{
	}

	public ObservableList<Animal> getData()
	{
		return model.getData();
	}

	public Animal getAnimal()
	{
		return model.getAnimal();
	}

}
