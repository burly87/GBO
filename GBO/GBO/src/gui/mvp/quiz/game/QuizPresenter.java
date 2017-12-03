package gui.mvp.quiz.game;

import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;
import javafx.scene.layout.GridPane;

public class QuizPresenter
{
	private QuizView view;
	private Model model;
	private MainPresenter mainPresenter;
	
	public QuizPresenter()
	{
	}
	
	public void setView(QuizView view)
	{
		this.view = view;
	}
	
		
	public QuizView getView()
	{
		return view;
	}

	public void setMainPresenter(MainPresenter mainPresenter)
	{
		this.mainPresenter = mainPresenter;
	}
	
	public void setModel(Model model)
	{
		this.model = model;
	}
	
	public void showQuestion(Question question) 
	{
	
		
	}
	
    public GridPane initView()
    {
        return view.initView(model.getFirst());
    }
	
}
