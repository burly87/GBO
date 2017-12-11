package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class OverviewView extends VBox
{
    private OverviewPresenter presenter;

    private Label text;

    private TableView<Question> overview;

    private TableColumn<Question, String> questionCol;

    private TableColumn<Question, Number> totalAnswerCol;

    private TableColumn<Question, Number> correctAnswerCol;

    private Button delete;

    private Pane pane;

    public OverviewView(OverviewPresenter overviewPresenter)
    {
        this.presenter = overviewPresenter;
    }

    public Pane overviewViewInit(ObservableList<Question> observableList)
    {

        text = new Label("\u00dcbersicht");

        overview = new TableView<Question>(observableList);
        questionCol = new TableColumn("Frage");
        totalAnswerCol = new TableColumn("Antworten");
        correctAnswerCol = new TableColumn("Korrekt");

        questionCol.setCellValueFactory(new PropertyValueFactory<Question, String>("question"));
        totalAnswerCol.setCellValueFactory(new PropertyValueFactory<Question, Number>("amount"));
        correctAnswerCol.setCellValueFactory(new PropertyValueFactory<Question, Number>("correctCounter"));

        delete = new Button("Ergebnisse l\u00f6schen");
        delete.setOnAction(e -> presenter.delete());

        // Ids
        overview.setId("overviewTable");
        delete.setId("deleteHistory");
        questionCol.setId("questionCol");
        totalAnswerCol.setId("totalAnswerCol");

        // TableColumns
        overview.getColumns().add(questionCol);
        overview.getColumns().add(totalAnswerCol);
        overview.getColumns().add(correctAnswerCol);

        this.getChildren().addAll(text, overview, delete);

        return pane;

    }

    public void setPresenter(OverviewPresenter overviewPresenter)
    {
        this.presenter = overviewPresenter;
    }

}
