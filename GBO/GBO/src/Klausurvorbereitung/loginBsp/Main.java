package Klausurvorbereitung.loginBsp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Presenter presenter = new Presenter();
        View view = new View(presenter);
        view.initView();

        Model model = new Model();
        presenter.setView(view);
        presenter.setModel(model);

        Scene scene = new Scene(view.getView(), 350, 200);
        stage.setScene(scene);
        stage.setTitle("Login Beispiel");
        stage.show();

    }

}
