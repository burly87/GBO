package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class OverviewView_old extends VBox
{
    private OverviewPresenter presenter;

    private Label text;

    private ListView<Question> overview;

    private Button delete;

    public OverviewView_old()
    {
        text = new Label("Übersicht");
        overview = new ListView<>();

        delete = new Button("Ergebnisse löschen");
        delete.setOnAction(e -> presenter.delete());

        // Ids
        overview.setId("overviewList");
        delete.setId("deleteHistory");

        this.getChildren().addAll(text, overview, delete);

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
