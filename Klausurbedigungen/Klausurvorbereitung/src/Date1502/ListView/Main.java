package Date1502.ListView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
	
	private Model model;
	private Presenter presenter;
	private View view;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		
		model = new Model();
		presenter = new Presenter();
		view = new View(presenter);
		
		presenter.setModel(model);
		presenter.setView(view);
		
		Scene scene = new Scene(view.iniView(),620,500);
		stage.setScene(scene);
		stage.setTitle("TestView");
		stage.show();
	}

}
