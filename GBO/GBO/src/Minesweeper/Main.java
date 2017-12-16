package Minesweeper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Model model = new Model();
        Presenter presenter = new Presenter();
        MainView view = new MainView(presenter);

        presenter.setView(view);
        presenter.setModel(model);
        view.initView();

        Scene scene = new Scene(view.getUi(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("Mines Sweeper");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
