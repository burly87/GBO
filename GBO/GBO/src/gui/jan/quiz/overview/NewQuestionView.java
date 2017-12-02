package gui.jan.quiz.overview;

import gui.jan.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class NewQuestionView
{

    private Label label;

    private TextArea ta[];

    private RadioButton rb[];

    private EditPresenter ep;

    private TextArea texta;

    private GridPane pane;

    public NewQuestionView(EditPresenter ep)
    {
        this.ep = ep;
    }

    public Scene init(Question q)
    {
        pane = new GridPane();
        ObservableList<String> qa = q.getQA();
        label = new Label("Frage:");
        texta = new TextArea();
        texta.setText(qa.remove(0));
        Button change = new Button();
        change.setText("Ändern");
        change.setOnAction(e -> change());
        Button close = new Button();
        close.setText("Abbrechen");
        close.setOnAction(e -> close());
        pane.add(label, 0, 0);
        pane.add(texta, 0, 1);
        GridPane.setRowSpan(texta, 6);
        GridPane.setColumnSpan(texta, 10);
        ta = new TextArea[4];
        rb = new RadioButton[4];
        for (int i = 0; i < 4; i++)
        {
            RadioButton a = new RadioButton();
            rb[i] = a;
            TextArea t = new TextArea();
            ta[i] = t;
            a.setMaxSize(25, 25);
            t.setText(qa.remove(0));
            t.setMaxSize(100, 25);
            if (t.getText().equals(q.getAnswer()))
            {
                a.setSelected(true);
            }
            pane.add(a, 0, 7 + i);
            pane.add(t, 1, 7 + i);
        }
        pane.add(close, 1, 11);
        pane.add(change, 0, 11);
        return new Scene(pane);
    }

    public Scene init()
    {
        pane = new GridPane();
        label = new Label("Frage:");
        texta = new TextArea();
        Button addanswer = new Button();
        addanswer.setText("Antwort hinzufügen");
        // addanswer.setOnAction(e -> answer());

        Button change = new Button();
        change.setText("Hinzufügen");
        change.setOnAction(e -> change());
        Button close = new Button();
        close.setText("Abbrechen");
        close.setOnAction(e -> close());
        pane.add(label, 0, 0);
        pane.add(texta, 0, 1);
        GridPane.setRowSpan(texta, 5);
        GridPane.setColumnSpan(texta, 10);
        pane.add(addanswer, 0, 6);
        answer();
        pane.add(close, 1, 12);
        pane.add(change, 0, 12);
        return new Scene(pane);

    }

    public void close()
    {
        ep.close();
    }

    public void change()
    {
        String answer = null;
        for (int i = 0; i < 4; i++)
        {
            if (rb[i].isSelected())
            {
                answer = ta[i].getText();
                break;
            }
        }
        Question q = new Question(texta.getText(), ta[0].getText(), ta[1].getText(), ta[2].getText(), ta[3].getText(), answer);
        ep.aendern(q);
    }

    public void answer()
    {
        // anzahl++;
        ta = new TextArea[4];
        rb = new RadioButton[4];
        for (int i = 1; i <= 4; i++)
        {
            RadioButton a = new RadioButton();
            rb[i - 1] = a;
            Button b = new Button();
            b.setText("löschen");
            // b.setOnAction(new EventHandler<ActionEvent>()
            // {
            //
            // @Override
            // public void handle(ActionEvent arg0)
            // {
            //
            // }
            // });
            TextArea t = new TextArea();
            t.setMaxSize(100, 25);
            ta[i - 1] = t;
            a.setMaxSize(25, 25);
            a.setText(" ");
            pane.add(a, 0, 6 + i);
            pane.add(b, 2, 6 + i);
            pane.add(t, 1, 6 + i);
        }
    }
}
