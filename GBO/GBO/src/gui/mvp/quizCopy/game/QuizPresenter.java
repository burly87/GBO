package gui.mvp.quizCopy.game;

import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;
import javafx.scene.layout.Pane;

public class QuizPresenter
{
    private QuizView view;

    private Model model;

    public QuizPresenter()
    {
    }

    public void setView(QuizView view)
    {
        this.view = view;
    }

    public Pane getView()
    {
        return view.getQuizView();
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void showQuestion(Question question)
    {

    }

    public void reset()
    {
        model.reset();
        continueQuiz();
    }

    public void continueQuiz()
    {
        if (!model.getQuestionList().isEmpty()) // geht immer direkt in else
        {
            view.setAnswers(model.getAnswer());
            view.setQuestion(model.getQuestion());
            view.setSelected(model.getLastSelectedIndex());
            view.setBottonDisable(false);
        }
        else
        {
            view.end();
        }
    }

    public void next()
    {
        model.choose(view.getSelectedIndex());

        if (model.hasNext())
        {
            model.next();
            view.setAnswers(model.getAnswer());
            view.setQuestion(model.getQuestion());
        }
        else
        {
            view.end();
        }
    }

}
