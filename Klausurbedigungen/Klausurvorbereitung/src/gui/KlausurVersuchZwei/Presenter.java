package gui.KlausurVersuchZwei;

public class Presenter
{
	private Model model;
	private View view;
	private AddDialog addDialog;
	
	
	public Presenter()
	{
		
	}

	public Model getModel()
	{
		return model;
	}

	public void setModel(Model model)
	{
		this.model = model;
	}

	public View getView()
	{
		return view;
	}

	public void setView(View view)
	{
		this.view = view;
	}

	public Match[] getGames()
	{
		return model.getAllMatches();
	}
	
	public ScoreEntry[] getScore()
	{
		return model.getAllScores();
	}

	public void getAddDialog()
	{
		AddDialog ad = new AddDialog();
		ad.setPresenter(this);
		ad.showAndWait();
	}

	public void addMatch(Match m)
	{
		model.addMatch(m);
	}

	public void deleteMatch(Match selectedItem)
	{
		model.deleteMatch(selectedItem);
		
	}

}
