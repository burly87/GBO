package gui.jan.quiz.overview;

import gui.jan.quiz.model.Model;
import javafx.scene.layout.GridPane;

public class DetailPresenter
{
    private DetailView v;

    private Model m;

    public void setFirstView(DetailView vnew)
    {
        this.v = vnew;
    }

    public void setModel(Model mnew)
    {
        this.m = mnew;
    }

    public void next()
    {
        m.increaseamount();
        String answer = v.getmarked();
        if (!(answer == null))
        {
            if (m.getAnswer() == answer)
            {
                m.increasecorrect();
            }
        }
        try
        {
            v.setQuestion(m.getnextQuestion());
        }
        catch (IndexOutOfBoundsException e)
        {
            v.setend();
        }

    }

    public GridPane getPane()
    {
        return v.getPane();
    }

    public GridPane initView()
    {
        return v.initView(m.getFirst());
    }
}
