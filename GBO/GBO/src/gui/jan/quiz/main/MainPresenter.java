package gui.jan.quiz.main;

import gui.jan.quiz.overview.DetailPresenter;
import gui.jan.quiz.overview.EditPresenter;
import gui.jan.quiz.overview.OverviewPresenter;

public class MainPresenter
{
    private MainView view;

    private OverviewPresenter overviewPresenter;

    private DetailPresenter quizPresenter;

    private EditPresenter editPresenter;

    public MainPresenter()
    {
    }

    public void setView(MainView vnew)
    {
        this.view = vnew;
    }

    public void setSecondPresenter(OverviewPresenter spnew)
    {
        this.overviewPresenter = spnew;
    }

    public void setFirstPresenter(DetailPresenter fpnew)
    {
        this.quizPresenter = fpnew;
    }
    
    public void setEditPresenter(EditPresenter e)
    {
        this.editPresenter = e;
    }
    

    public void edit()
    {
        view.setPane(editPresenter.initView());
    }

    public void start()
    {
        view.setPane(quizPresenter.initView());
    }

    public void overview()
    {
        view.setPane(overviewPresenter.initView());
    }

    public void fortsetzen()
    {
        view.setPane(quizPresenter.getPane());
    }

   
}
