package SS15NEU;

public class Presenter
{
	private Model model;
	private View view;
	
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

	public String[] getData()
	{
		return model.getKennungen();
	}
	
	
	
	

}
