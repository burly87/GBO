package gui.mvp.quizCopy.overview;

import gui.mvp.quiz.model.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    public OverviewView()
    {

        text = new Label("\u00dcbersicht");

        overview = new TableView();
        questionCol = new TableColumn("Frage");
        totalAnswerCol = new TableColumn("Antworten");
        correctAnswerCol = new TableColumn("Richtig");

        questionCol.setCellValueFactory(item -> item.getValue().questionProp());
        totalAnswerCol.setCellValueFactory(item -> item.getValue().amountProp());
        correctAnswerCol.setCellValueFactory(item -> item.getValue().correctCountProp());

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

    }

    public void setPresenter(OverviewPresenter overviewPresenter)
    {
        this.presenter = overviewPresenter;
    }

    public void initList()
    {
        overview.getItems().clear();
        overview.getItems().addAll(presenter.getContent());
    }

}
