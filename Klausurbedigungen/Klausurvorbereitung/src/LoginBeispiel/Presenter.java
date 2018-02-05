package LoginBeispiel;

public class Presenter {
	
	private Model model;
	private View view;
	
	public Presenter()
	{
		
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void setView(View view) {
		this.view = view;
	}
	
	public void login(String name, String pw) 
	{
		if (name.isEmpty())
		{
			view.showErrorEmpty();
		}
		else if(model.isOK(name, pw))
		{
			view.reset();
			view.showLoginCorrect();
		}
		else 
			view.showWrongPW();
	}


}
