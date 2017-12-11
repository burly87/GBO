package gui.jan.quizManuel.game;

import gui.jan.quizManuel.model.Model;
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

    public void setModel(Model m)
    {
        model = m;
    }

    public Pane getView()
    {
        return view.getQuizView();
    }

    public void restart()
    {
        model.restart();
        continueQuiz();
    }

    public void continueQuiz()
    {
        if (!model.getQuestList().isEmpty())
        {
            view.setAnswers(model.getAnswers());
            view.setQuestionText(model.getQuestion());
            view.setSelected(model.getLastSelectedAnswerIndex());
            view.setBtnDisable(false);
        }
        else
        {
            view.end();
        }
    }

    public void next()
    {
        model.evaluate(view.getSelectedAnswerIndex());
        if (model.hasNext())
        {
            model.next();
            view.setAnswers(model.getAnswers());
            view.setQuestionText(model.getQuestion());
        }
        else
        {
            view.end();
        }

    }

}
