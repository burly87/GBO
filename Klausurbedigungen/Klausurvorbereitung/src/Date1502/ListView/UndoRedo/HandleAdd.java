package Date1502.ListView.UndoRedo;

import Date1502.ListView.Country;
import Date1502.ListView.Model;

public class HandleAdd implements Interface
{
	private Model model;
	private Country country;
	
	public HandleAdd(Model model, Country country)
	{
		super();
		this.model = model;
		this.country = country;
	}

	@Override
	public void undo()
	{
		model.deleteCountry(country);
	}

	@Override
	public void redo()
	{
		model.addCountry(country);
	}
	
}
