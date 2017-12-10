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

    private TableColumn<Question, Integer> totalAnswerCol;

    private TableColumn<Question, Integer> correctAnswerCol;

    private Button delete;

    private Pane pane;

    // ObservableList<Question> data;

    public OverviewView(OverviewPresenter overviewPresenter)
    {
        this.presenter = overviewPresenter;
    }

    public Pane OverviewViewInit(ObservableList<Question> observableList)
    {
        // data = FXCollections.observableArrayList(new Question(question,
        // possibleAnswers, indexOfCorrectAnswer));

        text = new Label("Übersicht");

        overview = new TableView<Question>(observableList);// data
        questionCol = new TableColumn<Question, String>("Frage");
        totalAnswerCol = new TableColumn<Question, Integer>("Antworten");
        correctAnswerCol = new TableColumn<Question, Integer>("Korrekt");

        // Column text
        questionCol.setCellValueFactory(new PropertyValueFactory<Question, String>("Frage"));
        totalAnswerCol.setCellValueFactory(new PropertyValueFactory<Question, Integer>("Antworten"));
        correctAnswerCol.setCellValueFactory(new PropertyValueFactory<Question, Integer>("Korrekt"));

        // overview.setItems(data);

        delete = new Button("Ergebnisse löschen");
        delete.setOnAction(e -> presenter.delete());

        // Ids
        overview.setId("overviewTable");
        delete.setId("deleteHistory");
        questionCol.setId("questionCol");
        totalAnswerCol.setId("totalAnswerCol");

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

    public void initTextField()
    {
        overview.getItems().clear();
        overview.getItems().addAll(presenter.getContent());
    }

}
