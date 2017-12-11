package gui.jan.quizManuel.game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class QuizView
{

    private QuizPresenter presenter;

    private Label question;

    private Button next;

    private Pane viewPane;

    private Pane answerPane;

    public QuizView(QuizPresenter p)
    {
        presenter = p;

        viewPane = new VBox();
        answerPane = new VBox();
        question = new Label("Frage");

        question.setId("question");
        next = new Button("=>");
        next.setOnAction(e -> handle());

        viewPane.getChildren().add(question);
        viewPane.getChildren().add(answerPane);
        viewPane.getChildren().add(next);

    }

    public Pane getQuizView()
    {
        return viewPane;
    }

    public void init()
    {
        presenter.continueQuiz();
    }

    public void end()
    {
        answerPane.getChildren().clear();
        question.setText("Ende des Quiz");
        next.setDisable(true);
    }

    public void setBtnDisable(boolean b)
    {
        next.setDisable(b);
    }

    public void setQuestionText(String s)
    {
        question.setText(s);
    }

    public void setAnswers(String[] answers)
    {
        answerPane.getChildren().clear();
        ToggleGroup tg = new ToggleGroup();
        for (String s : answers)
        {
            RadioButton rb = new RadioButton(s);
            rb.setToggleGroup(tg);
            answerPane.getChildren().add(rb);
        }
    }

    public void setSelected(int i)
    {
        if (i >= 0)
        {
            RadioButton rb = (RadioButton) answerPane.getChildren().get(i);
            rb.setSelected(true);
        }
    }

    public int getSelectedAnswerIndex()
    {
        for (int j = 0; j < answerPane.getChildren().size(); j++)
        {
            RadioButton rb = (RadioButton) answerPane.getChildren().get(j);
            if (rb.isSelected())
            {
                return j;
            }
        }
        return -1;
    }

    private void handle()
    {
        presenter.next();
    }

}
