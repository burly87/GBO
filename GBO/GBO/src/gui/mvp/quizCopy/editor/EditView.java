package gui.mvp.quizCopy.editor;

import java.util.ArrayList;

import gui.mvp.quiz.model.Question;
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

    private TextArea questionField;

    private Button addAnswerBtn;

    private VBox answerPane, root;

    private ToggleGroup group;

    private EditorPresenter editorPresenter;

    private boolean edit;

    private Question old;

    public EditView(boolean edit, EditorPresenter ep)
    {
        this.editorPresenter = ep;
        this.edit = edit;

        Label l = new Label("Frage:");
        Button changeBtn = new Button();

        if (edit)
        {
            changeBtn.setText("\u00c4ndern");
        }
        else
        {
            changeBtn.setText("Hinzuf\u00fcgen");
        }

        Button cancelBtn = new Button("Abbrechen");
        questionField = new TextArea();
        addAnswerBtn = new Button("Antwort hinzuf\u00fcgen");
        answerPane = new VBox();
        root = new VBox();
        group = new ToggleGroup();

        addAnswerBtn.setOnAction(e -> handleAddAnswer());
        changeBtn.setOnAction(e -> handleChange());
        cancelBtn.setOnAction(e -> handleCancel());
        questionField.setId("dialogQuestion");

        root.getChildren().addAll(l, questionField, addAnswerBtn, answerPane, changeBtn, cancelBtn);

        this.setScene(new Scene(root));

    }

    public void init(Question q)
    {
        old = q;
        questionField.setText(q.getQuestion()); // speicheradresse?^^

        for (String s : q.getPossibleAnswers())
        {
            addAnswer(s);
        }
        HBox box = (HBox) (answerPane.getChildren().get(q.getIndexOfCorrectAnswer()));
        RadioButton rBtn = (RadioButton) box.getChildren().get(0);
        rBtn.setSelected(true);
    }

    private void handleChange()
    {

        if (edit)
        {
            editorPresenter.changeQuestion(old, genQuest());
        }
        else
        {
            editorPresenter.addQuestion(genQuest());
        }
        this.close();

    }

    private void handleCancel()
    {
        this.close();
    }

    private Question genQuest()
    {

        String s = questionField.getText();
        ArrayList<String> sl = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < answerPane.getChildren().size(); i++)
        {
            HBox cont = (HBox) answerPane.getChildren().get(i);
            RadioButton rBtn = (RadioButton) cont.getChildren().get(0);
            TextField txtField = (TextField) cont.getChildren().get(1);

            if (!txtField.getText().isEmpty())
            {
                sl.add(txtField.getText());
                if (rBtn.isSelected())
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
        RadioButton rBtn = new RadioButton();
        TextField txtField = new TextField();
        Button btn = new Button("L\u00f6schen");

        btn.setOnAction(e -> handleDelete(e));
        rBtn.setToggleGroup(group);
        rBtn.setSelected(true);

        container.getChildren().addAll(rBtn, txtField, btn);
        answerPane.getChildren().add(container);
    }

    private void addAnswer(String s)
    {
        HBox container = new HBox();
        RadioButton rBtn = new RadioButton();
        TextField txtField = new TextField();
        Button btn = new Button("L\u00f6schen");

        btn.setOnAction(e -> handleDelete(e));
        rBtn.setToggleGroup(group);
        rBtn.setSelected(true);
        txtField.setText(s);

        container.getChildren().addAll(rBtn, txtField, btn);
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
