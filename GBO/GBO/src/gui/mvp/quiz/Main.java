package gui.mvp.quiz;

import gui.mvp.quiz.main.MainView;
import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.game.QuizView;
import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.overview.OverviewPresenter;
import gui.mvp.quiz.overview.OverviewView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application

{

	@Override
	public void start(Stage stage) throws Exception 
	{
		MainPresenter mainPresenter = initApplication();
		mainPresenter.showOverviewView();
		Scene scene = new Scene(mainPresenter.getView(), 900, 400);
		stage.setScene(scene);
		stage.setTitle("Quiz");
		stage.show();
	}

	private MainPresenter initApplication() 
	{
		MainPresenter mainPresenter = new MainPresenter();
		MainView mainView = new MainView();
		QuizPresenter  quizPresenter = new QuizPresenter();
		QuizView quizView = new QuizView();
		OverviewPresenter overviewPresenter = new OverviewPresenter();
		OverviewView overviewView = new OverviewView();
		
		mainPresenter.setView(mainView);
		quizPresenter.setView(quizView);
		
		
		
		return mainPresenter;
	}

	
	public static void main(String[] args)
	{
		launch(args);
	}
	
}
