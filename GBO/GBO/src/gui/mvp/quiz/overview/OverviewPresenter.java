package gui.mvp.quiz.overview;

import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.model.Model;

public class OverviewPresenter
{
	private OverviewView view;
	private MainPresenter mainPresenter;
	private Model model;

	public OverviewPresenter()
	{
		
	}
	public void setModel(Model model)
	{
		this.model = model;
	}
	
	public void setView(OverviewView view)
	{
		this.view = view;
	}
	
	public OverviewView getView()
	{
		return view;
	}
	
	public void setMainPresenter(MainPresenter mainPresenter)
	{
		this.mainPresenter = mainPresenter;
	}
	
	public void delete()
	{
		model.clear();
		view.initView(model.getResult());
	}

	public void correctAnswered()
	{
	
	}

}
