package Minesweeper;

public class Presenter
{
    private MainView view;

    private Model model;

    public Presenter()
    {

    }

    public void setView(MainView view)
    {
        this.view = view;

    }

    public void setModel(Model model)
    {
        this.model = model;
    }

}
