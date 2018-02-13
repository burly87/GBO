package TabelleMVP;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
	
	private Presenter presenter;
	private Model model;
	private View view;
	
	

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		presenter = new Presenter();
		view = new View(presenter);
		model = new Model();
		
		presenter.setModel(model);
		presenter.setView(view);
		
		Scene scene = new Scene(view.initView(),500,500);
		stage.setScene(scene);
		stage.show();
	}
	
	

}
