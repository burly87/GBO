package gui.jan.quiz;

import gui.jan.quiz.main.MainPresenter;
import gui.jan.quiz.main.MainView;
import gui.jan.quiz.model.Model;
import gui.jan.quiz.overview.DetailPresenter;
import gui.jan.quiz.overview.DetailView;
import gui.jan.quiz.overview.EditPresenter;
import gui.jan.quiz.overview.EditView;
import gui.jan.quiz.overview.OverviewPresenter;
import gui.jan.quiz.overview.OverviewView;
import gui.jan.quiz.overview.WaitView;
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
    public void start(Stage mainStage) throws Exception
    {
        Model model = new Model();
        MainView view;

        MainPresenter mainPresenter = new MainPresenter();
        DetailPresenter detailPresenter = new DetailPresenter();
        OverviewPresenter overviewPresenter = new OverviewPresenter();
        EditPresenter editPresenter = new EditPresenter();
        detailPresenter.setModel(model);
        overviewPresenter.setModel(model);
        editPresenter.setModel(model);
        editPresenter.setStage(mainStage);

        DetailView detailView = new DetailView(detailPresenter);
        OverviewView overviewView = new OverviewView(overviewPresenter);
        EditView editView = new EditView(editPresenter);
        WaitView waitView = new WaitView(editPresenter);

        detailPresenter.setFirstView(detailView);
        overviewPresenter.setSecondView(overviewView);
        editPresenter.setEditView(editView);
        editPresenter.setWaitView(waitView);

        view = new MainView(mainPresenter);
        mainPresenter.setFirstPresenter(detailPresenter);
        mainPresenter.setSecondPresenter(overviewPresenter);
        mainPresenter.setView(view);
        mainPresenter.setEditPresenter(editPresenter);

        Scene scene = new Scene(view.ui(), 400, 200);

        mainStage.setScene(scene);
        mainStage.show();
    }
}
