package gui.jan.sinus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        SinusModel m = new SinusModel();
        SinusPresenter p = new SinusPresenter();
        p.setModel(m);
        SinusView v = new SinusView(p);
        p.setView(v);

        v.initView();

        Scene scene = new Scene(v.getUI());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sinus");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
