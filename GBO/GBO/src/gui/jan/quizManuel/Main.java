package gui.jan.quizManuel;

import gui.jan.quizManuel.editor.EditorPresenter;
import gui.jan.quizManuel.editor.EditorView;
import gui.jan.quizManuel.game.QuizPresenter;
import gui.jan.quizManuel.game.QuizView;
import gui.jan.quizManuel.main.MainPresenter;
import gui.jan.quizManuel.main.MainView;
import gui.jan.quizManuel.model.Model;
import gui.jan.quizManuel.overview.OverviewPresenter;
import gui.jan.quizManuel.overview.OverviewView;
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
    public void start(Stage primaryStage) throws Exception
    {

        Model m = ModelInitializer.initModel(this.getParameters().getUnnamed().get(0));
        MainPresenter mp = initMainPresenter(m);

        mp.showQuiz(false);
        Scene s = new Scene(mp.getView());

        primaryStage.setScene(s);
        primaryStage.setTitle("Quiz");
        primaryStage.show();
    }

    private MainPresenter initMainPresenter(Model m)
    {
        MainPresenter mp = new MainPresenter();
        QuizPresenter qp = new QuizPresenter();
        OverviewPresenter op = new OverviewPresenter();
        EditorPresenter ep = new EditorPresenter();

        MainView mv = new MainView();
        QuizView qv = new QuizView(qp);
        OverviewView ov = new OverviewView();
        EditorView ev = new EditorView();

        qp.setView(qv);
        qp.setModel(m);
        qv.init();

        op.setModel(m);
        op.setView(ov);
        ov.setPresenter(op);
        ov.initList();

        ep.setModel(m);
        ep.setView(ev);
        ev.setPresenter(ep);

        mv.setPresenter(mp);

        mp.init(qp, op, ep, mv);

        return mp;
    }

}
