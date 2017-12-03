package gui.mvp.quiz.main;

import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.model.Question;
import gui.mvp.quiz.overview.OverviewPresenter;

public class MainPresenter
{
    private MainView view;

    private OverviewPresenter overviewPresenter;

    private QuizPresenter quizPresenter;

    public MainPresenter()
    {
    }

    public void setView(MainView view)
    {
        this.view = view;
    }

    public MainView getView()
    {
        return view;
    }

    public void setOverviewPresenter(OverviewPresenter overviewPresenter)
    {
        this.overviewPresenter = overviewPresenter;
    }

    public void setQuizPresenter(QuizPresenter quizPresenter)
    {
        this.quizPresenter = quizPresenter;
    }

    public void showOverviewView()
    {
        overviewPresenter.result();
        view.setContent(overviewPresenter.initView());
    }

    public void showQuizView(Question question)
    {
        quizPresenter.showQuestion(question);
        view.setContent(quizPresenter.initView());
    }

    public void start()
    {
        view.setContent(quizPresenter.initView());
    }

}
