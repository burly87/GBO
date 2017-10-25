package gui.Uebung2;

import java.util.ArrayList;

public class VerySimpleIntegerProperty
{
    private ArrayList<ChangeListener> listenerList = new ArrayList<>();

    private int value;

    public void set(int v)
    {
        this.value = v;
        notify(v);
    }

    public int get()
    {
        return this.value;
    }

    public void addListener(ChangeListener l)
    {
        listenerList.add(l);
    }

    public void removeListener(ChangeListener l)
    {
        listenerList.remove(l);
    }

    private void notify(int v)
    {
        for (ChangeListener listener : listenerList)
        {
            listener.update(v);
        }
    }
}