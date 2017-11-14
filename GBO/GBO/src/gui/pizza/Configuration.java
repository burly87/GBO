package gui.pizza;

public class Configuration
{
    private String[] sizeNames;

    private int[] sizePrices;

    private String[] toppingNames;

    private int[] toppingPrices;

    private int numberOfDefaultToppings;

    public Configuration(String[] sizeNames, int[] sizePrices, String[] toppingNames, int[] toppingPrices, int numberOfDefaultToppings)
    {
        super();

        if (sizePrices.length == sizeNames.length)
        {
            this.sizeNames = sizeNames;
            this.sizePrices = sizePrices;
        }
        else
        {
            throw new IllegalArgumentException("size Stimmt nicht");
        }

        if (toppingPrices.length == toppingNames.length)
        {
            this.toppingNames = toppingNames;
            this.toppingPrices = toppingPrices;
        }
        else
        {
            throw new IllegalArgumentException("toppingName Stimmt nicht");
        }

        if (numberOfDefaultToppings >= toppingNames.length)
        {
            throw new IllegalArgumentException("geht nid");
        }
        else
        {
            this.numberOfDefaultToppings = numberOfDefaultToppings;
        }

    }

    public String[] getSizeNames()
    {
        return sizeNames;
    }

    public int[] getSizePrices()
    {

        return sizePrices;
    }

    public String[] getToppingNames()
    {
        return toppingNames;
    }

    public int[] getToppingPrices()
    {
        return toppingPrices;
    }

    public int getNumberOfDefaultToppings()
    {
        return numberOfDefaultToppings;
    }

}
