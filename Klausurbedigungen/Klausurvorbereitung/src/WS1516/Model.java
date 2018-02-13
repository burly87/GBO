package WS1516;

import java.util.ArrayList;

public class Model
{
    private ArrayList<String> itemNames;

    private ArrayList<Double> itemWeights;

    private ArrayList<Item> items;

    private double maxWeight;

    public Model(String[] itemNames, double[] itemWeights, double maxWeight)
    {
        this.itemNames = new ArrayList<>();
        this.itemWeights = new ArrayList<>();
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
        
        for (int i = 0; i < itemNames.length; i++)
        {
            this.itemNames.add(itemNames[i]);
            this.itemWeights.add(itemWeights[i]);
            this.items.add(new Item(itemNames[i], itemWeights[i]));
        }
    }

    public double getMaxWeight()
    {
        return this.maxWeight;
    }

    public ArrayList<String> getItemNames()
    {
        return this.itemNames;
    }

    public ArrayList<Double> getItemWeights()
    {
        return this.itemWeights;
    }

    public ArrayList<String> getEnabledItems()
    {
        ArrayList<String> enabled = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).isSelected())
            {
                enabled.add(items.get(i).getName());
            }
        }
        return enabled;
    }

    public void setSelected(String s, boolean b)
    {
        for (Item item : items)
        {
            if (item.getName().equals(s))
            {
                item.setEnabled(b);
            }
        }
    }

}
