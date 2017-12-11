package gui.mvp.quiz2.main;

import gui.mvp.quiz2.editor.EditorPresenter;
import gui.mvp.quiz2.game.QuizPresenter;
import gui.mvp.quiz2.overview.OverviewPresenter;
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
