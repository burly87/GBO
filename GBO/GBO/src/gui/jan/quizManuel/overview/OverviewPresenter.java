package gui.jan.quizManuel.overview;

import gui.jan.quizManuel.model.Model;
import gui.jan.quizManuel.model.Question;

public class OverviewPresenter
{

    private OverviewView view;

    private Model m;

    public OverviewPresenter()
    {

    }

    public void delete()
    {
        for (Question q : m.getQuestList())
        {
            q.reset();
        }
        view.initList();
    }

    public Question[] getLogs()
    {
        return m.getQuestList().toArray(new Question[m.getQuestList().size()]);
    }

    public void setView(OverviewView view)
    {
        this.view = view;
    }

    public void setModel(Model mo)
    {
        this.m = mo;
    }

    public OverviewView getView()
    {
        view.initList();
        return view;
    }
}
