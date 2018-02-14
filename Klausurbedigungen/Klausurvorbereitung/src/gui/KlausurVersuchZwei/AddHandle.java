package gui.KlausurVersuchZwei;


public class AddHandle implements Interface
{
	private Match match;
	private Model model;
	
	public AddHandle(Match match, Model model)
	{
		this.match = match;
		this.model = model;
	}

	@Override
	public void undo()
	{
		model.deleteMatch(match);
	}

	@Override
	public void redo()
	{
		model.addMatch(match);
	}

}
