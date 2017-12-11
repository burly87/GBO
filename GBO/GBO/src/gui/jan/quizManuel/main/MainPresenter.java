package gui.jan.quizManuel.main;

import gui.jan.quizManuel.editor.EditorPresenter;
import gui.jan.quizManuel.game.QuizPresenter;
import gui.jan.quizManuel.overview.OverviewPresenter;
import javafx.scene.layout.Pane;

public class MainPresenter
{

    private MainView mainView;

    private QuizPresenter quizPresenter;

    private OverviewPresenter overPresenter;

    private EditorPresenter editPresenter;

    public MainPresenter()
    {

    }

    public void init(QuizPresenter qp, OverviewPresenter op, EditorPresenter ep, MainView v)
    {
        quizPresenter = qp;
        overPresenter = op;
        editPresenter = ep;
        mainView = v;
    }

    public void showQuiz(boolean restart)
    {
        if (restart)
        {
            quizPresenter.restart();
        }
        mainView.setContent(quizPresenter.getView());
    }

    public void showOverview()
    {
        mainView.setContent(overPresenter.getView());
    }

    public void showEditor()
    {
        mainView.setContent(editPresenter.getView());
    }

    public Pane getView()
    {
        return mainView.getView();
    }

}
