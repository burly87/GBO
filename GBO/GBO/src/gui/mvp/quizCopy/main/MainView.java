package gui.mvp.quizCopy.main;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MainView extends BorderPane
{
    private BorderPane bPane;

    private MainPresenter mainPresenter;

    public MainView()
    {
        initView();
    }

    private void initView()
    {
        bPane = new BorderPane();
        HBox topArea = new HBox(5);

        Button start = new Button("Quiz starten!");
        Button weiter = new Button("Quiz fortsetzen!");
        Button overview = new Button("\u00dcberblick!");
        Button edit = new Button("Quiz editieren!");

        // zwischen Views hinundherschalten
        start.setOnAction(e -> start());
        weiter.setOnAction(e -> nextQ());
        overview.setOnAction(e -> overview());
        edit.setOnAction(e -> editorList());

        overview.setId("overview");

        topArea.getChildren().addAll(start, weiter, overview, edit);
        bPane.setTop(topArea);
    }

    private void overview()
    {
        mainPresenter.showOverviewView();
    }

    public void start()
    {
        mainPresenter.showQuiz(true);
    }

    public void nextQ()
    {
        mainPresenter.showQuiz(false);
    }

    public void editorList()
    {
        mainPresenter.showEditorView();
    }

    public void setPresenter(MainPresenter mainP)
    {
        mainPresenter = mainP;
    }

    public void setContent(Pane pane)
    {
        bPane.setCenter(pane);
    }

    public Pane getView()
    {
        return bPane;
    }
}
