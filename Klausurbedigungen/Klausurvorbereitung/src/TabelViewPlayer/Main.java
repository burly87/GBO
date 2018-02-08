package TabelViewPlayer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

	private Presenter presenter;
	private Model model;
	private View view;

	@Override
	public void start(Stage stage) throws Exception
	{
		Presenter presenter = initApplication();

		Scene scene = new Scene(view.initView(), 700, 500);
		stage.setScene(scene);
		stage.setTitle("TableView");
		stage.show();

	}

	private Presenter initApplication()
	{
		presenter = new Presenter();
		view = new View(presenter);
		model = new Model();

		presenter.setModel(model);
		presenter.setView(view);

		presenter.getPlayerList();
		return presenter;
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
