package gui.KORREKT2;

public class DeleteHandle implements Interface
{
	private Match match;
	private Model model;
	
	public DeleteHandle(Match match, Model model)
	{
		this.match = match;
		this.model = model;
	}

	@Override
	public void undo()
	{
		model.addMatch(match);
	}

	@Override
	public void redo()
	{
		model.deleteMatch(match);
	}
}
