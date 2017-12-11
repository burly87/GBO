package gui.jan.quizManuel.editor;

import java.util.ArrayList;

import gui.jan.quizManuel.model.Question;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditView extends Stage
{

    private TextArea questField;

    private Button addAnswerBtn;

    private VBox answerPane, root;

    private ToggleGroup tg;

    private EditorPresenter ep;

    private boolean edit;

    private Question old;

    public EditView(boolean edit, EditorPresenter ep)
    {
        this.ep = ep;
        this.edit = edit;
        Label l = new Label("Frage:");
        Button changeBtn = new Button();
        if (edit)
        {
            changeBtn.setText("Ändern");
        }
        else
        {
            changeBtn.setText("Hinzufügen");
        }
        Button cancelBtn = new Button("Abbrechen");
        questField = new TextArea();
        addAnswerBtn = new Button("Antwort hinzufügen");
        answerPane = new VBox();
        root = new VBox();
        tg = new ToggleGroup();

        addAnswerBtn.setOnAction(e -> handleAddAnswer());
        changeBtn.setOnAction(e -> handleChange());
        cancelBtn.setOnAction(e -> handleCancel());
        questField.setId("dialogQuestion");

        root.getChildren().add(l);
        root.getChildren().add(questField);
        root.getChildren().add(addAnswerBtn);
        root.getChildren().add(answerPane);
        root.getChildren().add(changeBtn);
        root.getChildren().add(cancelBtn);

        this.setScene(new Scene(root));

    }

    public void init(Question q)
    {
        old = q;
        questField.setText(q.getQuestion());
        for (String s : q.getPossibleAnswers())
        {
            addAnswer(s);
        }
        HBox b = (HBox) (answerPane.getChildren().get(q.getIndexOfCorrectAnswer()));
        RadioButton rb = (RadioButton) b.getChildren().get(0);
        rb.setSelected(true);
    }

    private void handleChange()
    {

        if (edit)
        {
            ep.changeQuestion(old, genQuest());
        }
        else
        {
            ep.addQuestion(genQuest());
        }
        this.close();

    }

    private void handleCancel()
    {
        this.close();
    }

    private Question genQuest()
    {

        String s = questField.getText();
        ArrayList<String> sl = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < answerPane.getChildren().size(); i++)
        {
            HBox cont = (HBox) answerPane.getChildren().get(i);
            RadioButton rb = (RadioButton) cont.getChildren().get(0);
            TextField tf = (TextField) cont.getChildren().get(1);

            if (!tf.getText().isEmpty())
            {
                sl.add(tf.getText());
                if (rb.isSelected())
                {
                    index = sl.size() - 1;
                }
            }
        }

        Question q = new Question(s, sl.toArray(new String[sl.size()]), index);
        return q;

    }

    private void handleAddAnswer()
    {
        addAnswer();
    }

    private void addAnswer()
    {
        HBox container = new HBox();
        RadioButton rb = new RadioButton();
        TextField tf = new TextField();
        Button b = new Button();

        b.setOnAction(e -> handleDelete(e));
        rb.setToggleGroup(tg);
        rb.setSelected(true);

        container.getChildren().add(rb);
        container.getChildren().add(tf);
        container.getChildren().add(b);
        answerPane.getChildren().add(container);
    }

    private void addAnswer(String s)
    {
        HBox container = new HBox();
        RadioButton rb = new RadioButton();
        TextField tf = new TextField();
        Button b = new Button();

        b.setOnAction(e -> handleDelete(e));
        rb.setToggleGroup(tg);
        rb.setSelected(true);
        tf.setText(s);

        container.getChildren().add(rb);
        container.getChildren().add(tf);
        container.getChildren().add(b);
        answerPane.getChildren().add(container);
    }

    private void handleDelete(ActionEvent e)
    {
        Button b = (Button) e.getSource();

        for (int i = 0; i < answerPane.getChildren().size(); i++)
        {
            HBox cont = (HBox) answerPane.getChildren().get(i);
            if (cont.getChildren().get(2) == b)
            {
                answerPane.getChildren().remove(i);
                break;
            }
        }
    }
}
