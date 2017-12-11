package gui.mvp.quiz2.main;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MainView
{
    private BorderPane mainPane;

    private MainPresenter mainPresenter;

    private Button continueBtn;

    public MainView()
    {

        mainPane = new BorderPane();
        Button startBtn = new Button("Quiz starten!");
        continueBtn = new Button("Quiz fortsetzen!");
        Button overviewBtn = new Button("Überblick!");
        Button editBtn = new Button("Quiz editieren!");

        startBtn.setOnAction(e -> handleStart());
        continueBtn.setOnAction(e -> handleContinue());
        overviewBtn.setOnAction(e -> handleOverview());
        overviewBtn.setId("overview");
        editBtn.setOnAction(e -> handleEdit());

        HBox btnPane = new HBox();
        btnPane.getChildren().add(startBtn);
        btnPane.getChildren().add(continueBtn);
        btnPane.getChildren().add(overviewBtn);
        btnPane.getChildren().add(editBtn);
        mainPane.setTop(btnPane);

    }

    public void handleStart()
    {
        continueBtn.setDisable(false);
        mainPresenter.showQuiz(true);
    }

    public void handleContinue()
    {
        mainPresenter.showQuiz(false);
    }

    public void handleOverview()
    {
        mainPresenter.showOverview();
    }

    public void handleEdit()
    {
        continueBtn.setDisable(true);
        mainPresenter.showEditor();
    }

    public void setPresenter(MainPresenter mp)
    {
        mainPresenter = mp;
    }

    public void setContent(Pane p)
    {
        mainPane.setCenter(p);
    }

    public Pane getView()
    {
        return mainPane;
    }
}
