package SS15NEU;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
	private Presenter presenter;
	private View view;
	private Model model;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		model = new Model();
//		model.trainingUnithinzu(new TrainingUnit("Test", 0, 23));
		presenter = new Presenter();
		presenter.setModel(model);
		view = new View(presenter);
		
		presenter.setView(view);
		
		
		Scene scene = new Scene(view.initView(), 600, 600);
		stage.setScene(scene);
		stage.show();
		
	}

}
