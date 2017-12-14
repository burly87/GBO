package gui.graphics.sinus;

public class SinusPresenter
{
    private SinusView view;

    private SinusModel model;

    public SinusPresenter()
    {

    }

    public SinusView getView()
    {
        return view;
    }

    public void setView(SinusView view)
    {
        this.view = view;
    }

    public SinusModel getModel()
    {
        return model;
    }

    public void setModel(SinusModel model)
    {
        this.model = model;
    }

}
