package gui.exam;

public class Presenter
{

	private View view;
	private Model model;
	private GameDialog gameDialog;
	
	public void initDialog()
	{
		GameDialog d = new GameDialog();
		d.setPresenter(this);
		d.showAndWait();
	}
	
	public Presenter()
	{
		
	}

	public void setView(View view)
	{
		this.view = view;
	}

	public void setModel(Model model)
	{
		this.model = model;
	}


	public void setGameDialog(GameDialog gameDialog)
	{
		this.gameDialog = gameDialog;
	}

	public void addMatch(Match m)
	{
		model.addMatch(m);
	}

	public Match[] setGames()
	{
		return model.getAllMatches();
	}

	public void deleteMatch(Match selectedItem)
	{
		model.deleteMatch(selectedItem);
	}

	public ScoreEntry[] setScore()
	{
		return model.getAllScores();
	}

	
	
}
