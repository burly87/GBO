package gui.jan.quizManuel.overview;

import gui.jan.quizManuel.model.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class OverviewView extends VBox
{

    private OverviewPresenter overPresenter;

    private ListView<Question> listView;

    public OverviewView()
    {

        Label l = new Label("Übersicht");
        listView = new ListView<>();
        Button btn = new Button("Ergebnisse löschen");
        btn.setId("deleteHistory");
        btn.setOnAction(e -> handle());
        listView.setId("overviewList");
        this.getChildren().add(l);
        this.getChildren().add(listView);
        this.getChildren().add(btn);
    }

    public void setPresenter(OverviewPresenter op)
    {
        overPresenter = op;
    }

    public void initList()
    {
        listView.getItems().clear();
        listView.getItems().addAll(overPresenter.getLogs());
    }

    private void handle()
    {
        overPresenter.delete();
    }

}
