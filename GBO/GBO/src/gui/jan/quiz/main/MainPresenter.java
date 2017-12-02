package gui.jan.quiz.main;

import gui.jan.quiz.overview.DetailPresenter;
import gui.jan.quiz.overview.EditPresenter;
import gui.jan.quiz.overview.OverviewPresenter;

public class MainPresenter
{
    private MainView v;

    private OverviewPresenter sp;

    private DetailPresenter fp;

    private EditPresenter ep;

    public MainPresenter()
    {
    }

    public void setView(MainView vnew)
    {
        this.v = vnew;
    }

    public void setSecondPresenter(OverviewPresenter spnew)
    {
        this.sp = spnew;
    }

    public void setFirstPresenter(DetailPresenter fpnew)
    {
        this.fp = fpnew;
    }

    public void edit()
    {
        v.setPane(ep.initView());
    }

    public void start()
    {
        v.setPane(fp.initView());
    }

    public void overview()
    {
        v.setPane(sp.initView());
    }

    public void fortsetzen()
    {
        v.setPane(fp.getPane());
    }

    public void setEditPresenter(EditPresenter e)
    {
        this.ep = e;
    }
}
