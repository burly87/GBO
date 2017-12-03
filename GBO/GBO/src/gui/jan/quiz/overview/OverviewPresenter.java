package gui.jan.quiz.overview;

import gui.jan.quiz.model.Model;
import javafx.scene.layout.GridPane;

public class OverviewPresenter
{
    private OverviewView view;

    private Model model;

    public OverviewPresenter()
    {

    }

    public void setModel(Model mnew)
    {
        this.model = mnew;
    }

    public void setSecondView(OverviewView vnew)
    {
        this.view = vnew;
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
