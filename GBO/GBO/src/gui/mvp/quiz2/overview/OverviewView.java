package gui.mvp.quiz2.overview;

import gui.mvp.quiz2.model.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class OverviewView extends VBox
{

    private OverviewPresenter overPresenter;

    private TableView<Question> tabView;

    public OverviewView()
    {

        Label l = new Label("Übersicht");
        tabView = new TableView();
        Button btn = new Button("Ergebnisse löschen");
        btn.setId("deleteHistory");
        btn.setOnAction(e -> handle());
        tabView.setId("overviewTable");

        TableColumn<Question, String> questCol = new TableColumn<>("Frage");
        TableColumn<Question, Number> countCol = new TableColumn<>("Antworten");
        TableColumn<Question, Number> correctCol = new TableColumn<>("Richtig");

        questCol.setCellValueFactory(item -> item.getValue().questionProperty());
        countCol.setCellValueFactory(item -> item.getValue().countProperty());
        correctCol.setCellValueFactory(item -> item.getValue().correctCountProperty());

        questCol.setId("questionCol");
        countCol.setId("totalAnswerCol");
        correctCol.setId("correctAnswerCol");

        tabView.getColumns().add(questCol);
        tabView.getColumns().add(countCol);
        tabView.getColumns().add(correctCol);

        this.getChildren().add(l);
        this.getChildren().add(tabView);
        this.getChildren().add(btn);
    }

    public void setPresenter(OverviewPresenter op)
    {
        overPresenter = op;
    }

    public void initList()
    {
        tabView.getItems().clear();
        tabView.getItems().addAll(overPresenter.getLogs());
    }

    private void handle()
    {
        overPresenter.delete();
    }

}
