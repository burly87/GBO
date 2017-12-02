package gui.jan.quiz.main;

import gui.jan.quiz.main.MainPresenter;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MainView
{
    private GridPane gp;

    private Button startbutton;

    private Button continuequiz;

    private Button overview;
    private Button edit;
    private MainPresenter mp;
    private GridPane innerpane;
    public MainView(MainPresenter mp)
    {
        this.mp = mp;
        init();
    }
    private void init()
    {
        gp = new GridPane();
        startbutton = new Button();
        startbutton.setText("Quiz starten!");
        startbutton.setOnAction(e->start());
        continuequiz = new Button();
        continuequiz.setText("Quiz fortsetzen!");
        continuequiz.setOnAction(e->weiter());
        overview = new Button();
        overview.setText("Überblick!");
        overview.setOnAction(e->overview());
        edit = new Button();
        edit.setText("Quiz editieren");
        edit.setOnAction(e->edit());
        gp.add(startbutton, 0, 0);
        gp.add(continuequiz, 1, 0);
        gp.add(overview, 2, 0);
        gp.add(edit, 3, 0);
        innerpane = new GridPane();
        gp.add(innerpane, 0, 1);
    }
    public void edit()
    {
        mp.edit();
    }
    public Pane ui()
    {
        return gp;
    }
    public void start()
    {
        mp.start();
    }
    public void weiter()
    {
        mp.fortsetzen();
    }
    public void overview()
    {
        mp.overview();
    }
    public void setPane(GridPane p)
    {
        gp.getChildren().remove(innerpane);
        innerpane = p;
        gp.add(innerpane, 0, 1);
        GridPane.setColumnSpan(innerpane, 4);
        gp.autosize();

    }
}
