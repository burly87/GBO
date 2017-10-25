package gui.Uebung2;

public class ListenerA implements ChangeListener
{
    public void update(int state)
    {
        System.out.println(state);
    }

    public static void main(String[] args)
    {
        ListenerA listener = new ListenerA();
        VerySimpleIntegerProperty intProp = new VerySimpleIntegerProperty();
        intProp.addListener(listener);
        intProp.set(55);
    }
}