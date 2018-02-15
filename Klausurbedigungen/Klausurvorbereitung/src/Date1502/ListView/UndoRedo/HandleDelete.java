package Date1502.ListView.UndoRedo;

import Date1502.ListView.Country;
import Date1502.ListView.Model;

public class HandleDelete implements Interface
{
	private Model model;
	private Country country;
	
	public HandleDelete(Model model, Country country)
	{
		super();
		this.model = model;
		this.country = country;
	}

	@Override
	public void undo()
	{
		model.addCountry(country);
	}

	@Override
	public void redo()
	{
		model.deleteCountry(country);
	}

}
