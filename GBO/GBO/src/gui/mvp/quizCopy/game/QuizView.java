package gui.mvp.quizCopy.game;

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

    private Button answerBtn;

    private Pane pane; // Ueberliegende Pane

    private Pane aPane; // Frage, antworten, answerBtn

    private ToggleGroup group;

    public QuizView(QuizPresenter quizPresenter)
    {
        presenter = quizPresenter;

        pane = new VBox(10);
        aPane = new VBox(5);
        question = new Label("Frage");
        answerBtn = new Button("=>");

        question.setId("question");

        answerBtn.setOnAction(e -> handleAnswer());

        pane.getChildren().addAll(question, aPane, answerBtn);

    }

    public Pane getQuizView()
    {
        return pane;
    }

    public void initView()
    {
        presenter.continueQuiz();
    }

    private void handleAnswer()
    {
        presenter.next();
    }

    public void end()
    {
        aPane.getChildren().clear();
        question.setText("Endes des Quiz");
        answerBtn.setDisable(true);
    }

    public void setPresenter(QuizPresenter presenter)
    {
        this.presenter = presenter;
    }

    public void setQuestion(String text)
    {
        question.setText(text);
    }

    public void setAnswers(String[] strings)
    {
        aPane.getChildren().clear();

        for (String s : strings)
        {
            RadioButton rBtn = new RadioButton(s);
            rBtn.setToggleGroup(group);
            aPane.getChildren().add(rBtn);
        }
    }

    public int getSelectedIndex()
    {
        for (int i = 0; i < aPane.getChildren().size(); i++)
        {
            RadioButton rBtn = (RadioButton) aPane.getChildren().get(i);

            if (rBtn.isSelected())
            {
                return i;
            }
        }
        return -1;
    }

    public void setSelected(int lastSelectedIndex)
    {
        if (lastSelectedIndex >= 0)
        {
            RadioButton rBtn = (RadioButton) aPane.getChildren().get(lastSelectedIndex);
            rBtn.setSelected(true);
        }
    }

    public void setBottonDisable(boolean b)
    {
        answerBtn.setDisable(b);
    }

}
