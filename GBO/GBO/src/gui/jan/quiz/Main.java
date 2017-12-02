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
        Model m = new Model();
        MainView v;

        MainPresenter p = new MainPresenter();
        DetailPresenter fp = new DetailPresenter();
        OverviewPresenter sp = new OverviewPresenter();
        EditPresenter ep = new EditPresenter();
        fp.setModel(m);
        sp.setModel(m);
        ep.setModel(m);
        ep.setStage(mainStage);

        DetailView fv = new DetailView(fp);
        OverviewView sv = new OverviewView(sp);
        EditView ev = new EditView(ep);
        WaitView wv = new WaitView(ep);

        fp.setFirstView(fv);
        sp.setSecondView(sv);
        ep.setEditView(ev);
        ep.setWaitView(wv);

        v = new MainView(p);
        p.setFirstPresenter(fp);
        p.setSecondPresenter(sp);
        p.setView(v);
        p.setEditPresenter(ep);

        Scene scene = new Scene(v.ui(), 400, 200);

        mainStage.setScene(scene);
        mainStage.show();
    }
}
