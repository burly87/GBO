package gui.graphics.sinus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        SinusModel sinusModel = new SinusModel();
        SinusPresenter sinusPresenter = new SinusPresenter();
        SinusView sinusView = new SinusView(sinusPresenter);

        sinusPresenter.setView(sinusView);
        sinusPresenter.setModel(sinusModel);
        sinusView.initView();

        Scene scene = new Scene(sinusView.getUI(), 800, 550);
        stage.setScene(scene);
        stage.setTitle("Sinus");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
