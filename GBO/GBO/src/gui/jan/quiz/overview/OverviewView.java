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
    private GridPane gridPane;

    private Button delete;

    private OverviewPresenter overviewPresenter;

    public OverviewView(OverviewPresenter sp)
    {
        this.overviewPresenter = sp;
    }

    public GridPane initView(ObservableList<Question> observableList)
    {
        TableView<Question> overview = new TableView<Question>(observableList);
        TableColumn<Question, String> questionCol = new TableColumn<Question, String>("Frage");
        questionCol.setCellValueFactory(new PropertyValueFactory<Question, String>("frage"));
        TableColumn<Question, Integer> correctAnswerCol = new TableColumn<Question, Integer>("Korrekte Antworten");
        correctAnswerCol.setCellValueFactory(new PropertyValueFactory<Question, Integer>("correct"));
        TableColumn<Question, Integer> totalAnswerCol = new TableColumn<Question, Integer>("Anzahl der Antworten");
        totalAnswerCol.setCellValueFactory(new PropertyValueFactory<Question, Integer>("amount"));

        overview.getColumns().add(questionCol);
        overview.getColumns().add(totalAnswerCol);
        overview.getColumns().add(correctAnswerCol);
        overview.setMinSize(400, 150);

        gridPane = new GridPane();
        gridPane.add(overview, 0, 1);
        GridPane.setColumnSpan(overview, 5);
        GridPane.setRowSpan(overview, 5);
        delete = new Button();
        delete.setText("Ergebnisse löschen");
        delete.setOnAction(e -> delete());
        gridPane.add(delete, 0, 6);
        return gridPane;
    }

    public void delete()
    {
        overviewPresenter.delete();
    }

}
