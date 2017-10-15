package gui.counter;

public class Incrementer
{

    private int counter;

    public Incrementer(int value)
    {
        this.counter = value;
    }

    public void increment()
    {
        this.counter++;
    }

    public int getValue()
    {
        return this.counter;
    }

}
