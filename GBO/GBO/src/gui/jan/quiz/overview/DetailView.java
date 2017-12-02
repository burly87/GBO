package gui.jan.quiz.overview;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

public class DetailView
{
    private GridPane gp;

    private DetailPresenter p;

    private Label label;

    private Button next;

    private RadioButton rp[];

    public DetailView(DetailPresenter p)
    {
        this.p = p;
    }

    public GridPane initView(ObservableList<String> list)
    {

        gp = new GridPane();
        next = new Button();
        next.setOnAction(e -> next());
        next.setText("==>");
        gp.add(next, 0, 5);
        label = new Label();
        gp.add(label, 0, 0);
        rp = new RadioButton[list.size() - 1];
        for (int i = 0; i < 4; i++)
        {
            rp[i] = new RadioButton();
            gp.add(rp[i], 0, i + 1);
        }
        setQuestion(list);
        return gp;
    }

    public void setQuestion(ObservableList<String> list)
    {
        label.setText(list.get(0));
        for (int i = 0; i < rp.length; i++)
        {
            rp[i].setText(list.get(i + 1));
        }
    }

    public GridPane getPane()
    {
        return gp;
    }

    public void next()
    {
        p.next();
    }

    public void setend()
    {
        for (int i = 0; i < rp.length; i++)
        {
            gp.getChildren().remove(rp[i]);
        }
        label.setText("Quiz beendet!");
        next.setDisable(true);
    }

    public String getmarked()
    {
        String answer = null;
        for (int i = 0; i < rp.length; i++)
        {
            if (rp[i].isSelected() && answer == null)
            {
                answer = rp[i].getText();
            }
            rp[i].setSelected(false);
        }
        return answer;
    }
}
