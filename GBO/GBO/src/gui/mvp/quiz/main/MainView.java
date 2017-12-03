package gui.mvp.quiz.main;

import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.overview.OverviewPresenter;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MainView extends BorderPane
{
	private OverviewPresenter overviewPresenter;
	private QuizPresenter quizPresenter;
	private MainPresenter mainPresenter;
	

	public MainView()
	{
		initView();
	}

	private void initView()
	{
		HBox topArea = new HBox(5);
	
		Button start = new Button("Quiz starten!");
		Button weiter = new Button("Quiz fortsetzen!");
		Button overview  = new Button("Überblick!");
		
		//zwischen Views hinundherschalten
		start.setOnAction(e -> start());
		weiter.setOnAction(e-> quizPresenter.getView());
		overview.setOnAction(e -> overview());
		
		overview.setId("overview");
		
		topArea.getChildren().addAll(start, weiter, overview);
		setTop(topArea);
	}
	
    private void overview() 
    {
    	overviewPresenter.initView();
	}

	public void start()
    {
        mainPresenter.start();
    }
	
	public void setContent(GridPane content)
	{
		setCenter(content);
		setMargin(content, new Insets(20,20,20,20));
	}
	
}
