package LoginBeispiel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private View view;
	private Model model;
	private Presenter presenter;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		presenter = new Presenter();		
		view = new View(presenter);
		
		model = new Model();
		presenter.setModel(model);
		presenter.setView(view);		
		
		Scene scene = new Scene(view.initView());
		stage.setScene(scene);
		stage.show();
	}

}
