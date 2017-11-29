package gui.mvp.vocabtrainer;

// "Controllzentrum" 
public class Presenter
{
    private View view;

    private Model model;

    public Presenter()
    {
    }

    public void setView(View view)
    {
        this.view = view;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }

    // deligiert view what to do next
    public void translate(String gerWord, String engWord)
    {
        if (engWord.isEmpty())
        {
            view.showInputWrong();
        }
        else if (model.isCorrect(gerWord, engWord))
        {
            view.showInputRight();
        }
        else
        {
            view.showInputWrong();
        }
    }

    public String nextVocab()
    {
        return model.nextHashElement();
    }
}
