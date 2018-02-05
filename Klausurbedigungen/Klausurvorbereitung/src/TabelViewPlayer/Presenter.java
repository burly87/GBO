package TabelViewPlayer;

import javafx.collections.ObservableList;

public class Presenter
{

	private Model model;
	private View view;

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

	public ObservableList<Player> getPlayerList()
	{
		return model.getPlayerList();
	}
	

	

}
