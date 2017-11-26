package gui.jan.vocabtrainer;

public class Presenter
{
    private ViewController view;

    private Model model;

    public Presenter()
    {
    }

    public void setView(ViewController view)
    {
        this.view = view;
    }

    public void setModel(Model model)
    {
        this.model = model;
    }
    
    public void abfragen(String vocab, String translation)
    {
        if(translation.isEmpty())
        {
            view.showInputError();    
        }
        else
        {
            if(model.ueberpruefen(vocab, translation))
            {
                view.showOkayMessage();
            }
            else
            {
                view.showLoginError();
            }
        }
    }
    
    public String nextVocab()
    {
        return model.nextHashElement();
    }
}
