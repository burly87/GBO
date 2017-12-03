package gui.jan.quiz.overview;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

public class DetailView
{
    private GridPane gridPane;

    private DetailPresenter presenter;

    private Label label;

    private Button next;

    private RadioButton radioButton[];

    public DetailView(DetailPresenter p)
    {
        this.presenter = p;
    }

    public GridPane initView(ObservableList<String> list)
    {

        gridPane = new GridPane();
        next = new Button();
        next.setOnAction(e -> next());
        next.setText("==>");
            
        label = new Label();
        
        gridPane.add(label, 0, 0);
        gridPane.add(next, 0, 5);
        
        radioButton = new RadioButton[list.size() - 1];
        
        for (int i = 0; i < 4; i++)
        {
            radioButton[i] = new RadioButton();
            gridPane.add(radioButton[i], 0, i + 1);
        }
        setQuestion(list);
        return gridPane;
    }

    public void setQuestion(ObservableList<String> list)
    {
        label.setText(list.get(0));
        for (int i = 0; i < radioButton.length; i++)
        {
            radioButton[i].setText(list.get(i + 1));
        }
    }

    public GridPane getPane()
    {
        return gridPane;
    }

    public void next()
    {
        presenter.next();
    }

    public void setend()
    {
        for (int i = 0; i < radioButton.length; i++)
        {
            gridPane.getChildren().remove(radioButton[i]);
        }
        label.setText("Quiz beendet!");
        next.setDisable(true);
    }

    public String getmarked()
    {
        String answer = null;
        for (int i = 0; i < radioButton.length; i++)
        {
            if (radioButton[i].isSelected() && answer == null)
            {
                answer = radioButton[i].getText();
            }
            radioButton[i].setSelected(false);
        }
        return answer;
    }
}
