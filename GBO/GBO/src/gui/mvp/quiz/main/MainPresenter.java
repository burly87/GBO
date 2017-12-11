package gui.mvp.quiz.main;

import gui.mvp.quiz.editor.EditorPresenter;
import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.model.Question;
import gui.mvp.quiz.overview.OverviewPresenter;
import javafx.scene.layout.Pane;

public class MainPresenter
{
    private MainView view;

    private OverviewPresenter overviewPresenter;

    private QuizPresenter quizPresenter;

    private EditorPresenter editorPresenter;

    public MainPresenter()
    {
    }

    // init
    public void setOverviewPresenter(OverviewPresenter overviewPresenter)
    {
        this.overviewPresenter = overviewPresenter;
    }

    public void setQuizPresenter(QuizPresenter quizPresenter)
    {
        this.quizPresenter = quizPresenter;
    }

    public void setView(MainView view)
    {
        this.view = view;
    }
    // END: init

    public void showQuiz(boolean reset)
    {
        if (reset)
        {
            quizPresenter.reset();
        }
        view.setContent(quizPresenter.getView());
    }

    public Pane getView()
    {
        return view.getView();
    }

    public void showOverviewView()
    {
        view.setContent(overviewPresenter.getView()); // Zusammenhang mit
                                                      // OverviewView..
    }

    public void showQuizView(Question question)
    {
        quizPresenter.showQuestion(question);
        view.setContent(quizPresenter.getView());
    }

    public void showEditorView()
    {
        view.setContent(editorPresenter.getView()); // Nullpointer HERE
    }

    public void start()
    {
        view.setContent(quizPresenter.getView());
    }

}
