package Date1502.ListView;

import javafx.collections.ObservableList;

public class Presenter
{
	private View view;
	private Model model;
	
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

	public ObservableList<Country> getData()
	{
		return model.getData();
	}


	
	

}
