package gui.jan.quiz.main;

import gui.jan.quiz.main.MainPresenter;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MainView
{
    private GridPane gridPane;

    private Button startButton;

    private Button continueQuiz;

    private Button overview;
    private Button edit;
    private MainPresenter mainPresenter;
    private GridPane innerpane;
    public MainView(MainPresenter mainPresenter)
    {
        this.mainPresenter = mainPresenter;
        init();
    }
    private void init()
    {
        gridPane = new GridPane();
        startButton = new Button();
        startButton.setText("Quiz starten!");
        startButton.setOnAction(e->start());
        
        continueQuiz = new Button();
        continueQuiz.setText("Quiz fortsetzen!");
        continueQuiz.setOnAction(e->weiter());
        
        overview = new Button();
        overview.setText("Überblick!");
        overview.setOnAction(e->overview());
        
        edit = new Button();
        edit.setText("Quiz editieren");
        edit.setOnAction(e->edit());
        
        gridPane.add(startButton, 0, 0);
        gridPane.add(continueQuiz, 1, 0);
        gridPane.add(overview, 2, 0);
        gridPane.add(edit, 3, 0);
        
        innerpane = new GridPane();
        
        gridPane.add(innerpane, 0, 1);
    }
    public void edit()
    {
        mainPresenter.edit();
    }
    public Pane ui()
    {
        return gridPane;
    }
    public void start()
    {
        mainPresenter.start();
    }
    public void weiter()
    {
        mainPresenter.fortsetzen();
    }
    public void overview()
    {
        mainPresenter.overview();
    }
    public void setPane(GridPane pane)
    {
        gridPane.getChildren().remove(innerpane);
        innerpane = pane;
        gridPane.add(innerpane, 0, 1);
        GridPane.setColumnSpan(innerpane, 4);
        gridPane.autosize();

    }
}
