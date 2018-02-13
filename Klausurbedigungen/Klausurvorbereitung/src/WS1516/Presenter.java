package WS1516;

import java.util.ArrayList;

public class Presenter
{
    private View v;

    private Model m;

    public Presenter()
    {
    }

    public void setView(View v)
    {
        this.v = v;
    }

    public void setModel(Model m)
    {
        this.m = m;
    }

    public void startView()
    {
        v.init(m.getItemNames(), m.getItemWeights(), m.getMaxWeight());
    }

    public void setSelected(String s, boolean b)
    {
        m.setSelected(s, b);
    }

    public ArrayList<Double> getWeights()
    {
        return m.getItemWeights();
    }

    public ArrayList<String> getEnabled()
    {
        return m.getEnabledItems();
    }

}
