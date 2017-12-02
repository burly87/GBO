package gui.jan.quiz.overview;

import gui.jan.quiz.model.Model;
import javafx.scene.layout.GridPane;

public class OverviewPresenter
{
    private OverviewView v;

    private Model m;

    public OverviewPresenter()
    {

    }

    public void setModel(Model mnew)
    {
        this.m = mnew;
    }

    public void setSecondView(OverviewView vnew)
    {
        this.v = vnew;
    }

    public void delete()
    {
        m.clear();
        v.initView(m.getResult());
    }

    public GridPane initView()
    {
        return v.initView(m.getResult());
    }
}
