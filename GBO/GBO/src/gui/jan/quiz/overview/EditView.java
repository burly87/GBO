package gui.jan.quiz.overview;

import gui.jan.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class EditView
{
    private GridPane pane;

    private EditPresenter ep;

    private ListView<Question> t;

    private Button add;

    private Button edit;

    private Button delete;

    public EditView(EditPresenter e)
    {
        this.ep = e;
    }

    public GridPane initView(ObservableList<Question> observableList)
    {
        pane = new GridPane();
        t = new ListView<Question>(observableList);
        // t.setItems(list);
        t.setEditable(true);
        pane.add(t, 0, 1);
        t.setMinSize(400, 150);
        add = new Button();
        add.setText("Frage hinzufügen");
        add.setOnAction(e -> add());
        edit = new Button();
        edit.setText("Frage editieren");
        edit.setOnAction(e -> edit());
        delete = new Button();
        delete.setText("Frage löschen");
        delete.setOnAction(e -> delete());
        pane.add(add, 0, 6);
        pane.add(edit, 1, 6);
        pane.add(delete, 2, 6);
        GridPane.setColumnSpan(t, 5);
        GridPane.setRowSpan(t, 5);
        return pane;
        // TODO Auto-generated method stub
    }

    public Question getmarked()
    {
        int i = t.getFocusModel().getFocusedIndex();
        if (i < 0)
        {
            return null;
        }
        else
        {
            return t.getItems().get(i);
        }
    }

    public void add()
    {
        ep.add();
    }

    public void edit()
    {
        ep.edit();
    }

    public void delete()
    {
        ep.delete();
    }
}
