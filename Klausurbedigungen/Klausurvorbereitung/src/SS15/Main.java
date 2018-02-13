package SS15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        Presenter presenter = initApplication();
        
        Scene scene = new Scene(presenter.getView(), 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Trainingseinheiten");
        primaryStage.show();
    }
    
    public Presenter initApplication()
    {
        Presenter presenter = new Presenter();
        View view = new View();
        Model model = new Model();
        
        presenter.setView(view);
        presenter.setModel(model);
        view.setPresenter(presenter);
        
        model.trainingUnithinzu(new TrainingUnit("Montag", 13.0, 13.0));
        model.trainingUnithinzu(new TrainingUnit("Donnerstag", 12.0, 12.0));
        
        presenter.listeSetzen();
        
        return presenter;
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }

}
