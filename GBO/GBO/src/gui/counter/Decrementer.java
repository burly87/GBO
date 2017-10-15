package gui.counter;

public class Decrementer
{

    private int counter;

    public Decrementer(int value)
    {
        this.counter = value;
    }

    public void decrement()
    {
        this.counter--;
    }

    public int getValue()
    {
        return this.counter;
    }

}
