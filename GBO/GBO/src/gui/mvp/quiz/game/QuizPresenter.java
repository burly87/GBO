package gui.mvp.quiz.game;

import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;

public class QuizPresenter
{
	private QuizView view;
	private MainPresenter mainPresenter;
	private Model model;
	
	public QuizPresenter()
	{		
	}
	
	public QuizView getView() 
	{
		return view;
	}
	
	public void setView(QuizView view) 
	{
		this.view = view;		
	}

	public void setMainPresenter(MainPresenter mainPresenter) 
	{
		this.mainPresenter = mainPresenter;
	}

	public void setModel(Model model) 
	{
		this.model = model;
	}
	
	public void setQuestion(Question question)
	{
		view.showQuestion(question);
	}
	
	public void delete()
	{
		// Ergebnisse l�schen 
	}
	
	public void save()
	{
		//Antworten z�hlen
	}

	public Object answer() {
		// TODO HIER EVENT F�R ANSWER EINF�GEN
		return null;
	}

	
}
