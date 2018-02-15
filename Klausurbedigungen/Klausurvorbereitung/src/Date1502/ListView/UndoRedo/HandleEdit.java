package Date1502.ListView.UndoRedo;

import Date1502.ListView.Country;
import Date1502.ListView.Model;

public class HandleEdit implements Interface
{
	private Model model;
	private Country country, old;
	
	public HandleEdit(Model model, Country country, Country old)
	{
		super();
		this.model = model;
		this.country = country;
		this.old = old;
	}

	@Override
	public void undo()
	{
		model.editCountry(country, old);
	}

	@Override
	public void redo()
	{
		model.editCountry(old, country);
	}
}
