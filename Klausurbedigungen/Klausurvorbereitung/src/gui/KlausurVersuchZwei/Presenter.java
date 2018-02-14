package gui.KlausurVersuchZwei;

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
		AddHandle ah = new AddHandle(match, model);
		urm.addAction(ah);
		model.addMatch(match);
		view.updateScores();
	}

	public void deleteMatch(Match selectedItem)
	{
		DeleteHandle dh = new DeleteHandle(selectedItem, model);
		urm.addAction(dh);
		model.deleteMatch(selectedItem);
		view.updateScores();
	}

	public void undo()
	{
		urm.undo();
		view.updateScores();
	}

	public void redo()
	{
		urm.redo();
		view.updateScores();
	}

}
