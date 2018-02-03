package Klausurvorbereitung.loginBsp;

public class Presenter
{
    private Model m;

    private View v;

    public Presenter()
    {
    }

    public void setView(View view)
    {
        this.v = view;
    }

    public void setModel(Model model)
    {
        this.m = model;
    }

    public void login(String name, String password)
    {
        if (name.isEmpty())
        {
            v.showEmptyError();
        }
        else if (m.isOk(name, password))
        {
            v.reset();
            v.showOkMsg();
        }
        else
        {
            v.showErrorLogin();
        }
    }

}
