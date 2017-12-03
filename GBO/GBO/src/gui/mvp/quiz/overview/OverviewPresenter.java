package gui.mvp.quiz.overview;

import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.model.Model;
import javafx.scene.layout.GridPane;

public class OverviewPresenter
{

    private MainPresenter mainPresenter;

    private OverviewView view;

    private Model model;

    public OverviewPresenter()
    {

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

    public void setModel(Model model)
    {
        this.model = model;
    }

    public void result()
    {
        System.out.println("in textfeld schreiben");

    }

    public void delete()
    {
        model.clear();
        view.initView(model.getResult());
    }

    public GridPane initView()
    {
        return view.initView(model.getResult());
    }

}
