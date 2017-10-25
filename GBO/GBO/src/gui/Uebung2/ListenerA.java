package gui.Uebung2;

public class ListenerA implements ChangeListener
{
    public void update(int state)
    {
        System.out.println("AENDERUNG ZU: " + state);
    }

    public static void main(String[] args)
    {
        ListenerA listener = new ListenerA();
        VerySimpleIntegerProperty intProp = new VerySimpleIntegerProperty();
        intProp.addListener(listener);
        intProp.addListener(v -> System.out.println(v));
        intProp.set(6);
    }
}