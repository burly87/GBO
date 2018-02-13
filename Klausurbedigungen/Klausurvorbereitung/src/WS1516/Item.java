package WS1516;

public class Item
{
    private String name;

    private double weight;

    private boolean selected;

    public Item(String name, double weight)
    {
        this.name = name;
        this.weight = weight;
        this.selected = true;
    }

    public String getName()
    {
        return this.name;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public boolean isSelected()
    {
        return this.selected;
    }

    public void setEnabled(boolean b)
    {
        this.selected = b;
    }
}
