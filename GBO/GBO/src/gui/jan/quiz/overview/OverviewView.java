package gui.jan.quiz.overview;

import gui.jan.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class OverviewView
{
    private GridPane gp;

    private Button delete;

    private OverviewPresenter sp;

    public OverviewView(OverviewPresenter sp)
    {
        this.sp = sp;
    }

    public GridPane initView(ObservableList<Question> observableList)
    {
        TableView<Question> t = new TableView<Question>(observableList);
        TableColumn<Question, String> a = new TableColumn<Question, String>("Frage");
        a.setCellValueFactory(new PropertyValueFactory<Question, String>("frage"));
        TableColumn<Question, Integer> c = new TableColumn<Question, Integer>("Korrekte Antworten");
        c.setCellValueFactory(new PropertyValueFactory<Question, Integer>("correct"));
        TableColumn<Question, Integer> b = new TableColumn<Question, Integer>("Anzahl der Antworten");
        b.setCellValueFactory(new PropertyValueFactory<Question, Integer>("amount"));
        t.getColumns().add(a);
        t.getColumns().add(b);
        t.getColumns().add(c);
        t.setMinSize(400, 150);
        gp = new GridPane();
        gp.add(t, 0, 1);
        GridPane.setColumnSpan(t, 5);
        GridPane.setRowSpan(t, 5);
        delete = new Button();
        delete.setText("Ergebnisse löschen");
        delete.setOnAction(e -> delete());
        gp.add(delete, 0, 6);
        return gp;
    }

    public void delete()
    {
        sp.delete();
    }

}
