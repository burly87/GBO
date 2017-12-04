package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;

public class OverviewPresenter
{

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
        view.initTextField();
        return view;
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
        for (Question q : model.getQuestionList())
        {
            q.reset();
        }
        view.initTextField();
    }

    public Question[] getContent()
    {
        return model.getQuestionList().toArray(new Question[model.getQuestionList().size()]);
    }

}
