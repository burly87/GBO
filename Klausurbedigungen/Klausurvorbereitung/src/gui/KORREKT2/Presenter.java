package gui.KORREKT2;

import java.util.Optional;


public class Presenter
{
	private Model model;
	private View view;
	private AddDialog addDialog;
	private Match m;
	private UndoRedoManager urm;
	
	public Presenter()
	{
		this.urm = new UndoRedoManager();
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
		addDialog = new AddDialog();
		Optional<Match> result = addDialog.showAndWait();
		result.ifPresent(match -> addMatch(match));
	}

	public void addMatch(Match match)
	{
		view.addMatch(match);
		model.addMatch(match);
		view.updateScores(model.getAllScores());
	}

	public void deleteMatch(Match selectedItem)
	{
		view.deleteMatch(selectedItem);
		model.deleteMatch(selectedItem);
		view.updateScores(model.getAllScores());
	}

	public void undo()
	{
		urm.undo();
	}

	public void redo()
	{
		urm.redo();
	}

	

}
