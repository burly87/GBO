package gui.Uebung2;

import java.util.ArrayList;

public class VerySimpleIntegerProperty
{
    private ArrayList<ChangeListener> listenerList = new ArrayList<>();

    private int value;

    public void set(int wert)
    {
        this.value = wert;
        notify(wert);
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

    private void notify(int wert)
    {
        for (ChangeListener listener : listenerList)
        {
            listener.update(wert);
        }
    }
}