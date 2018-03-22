package gui.stayFit;

public class StayFitObject
{

    private String name;

    private double number0, number1;

    public StayFitObject(String name, double number0, double number1)
    {
        super();
        this.name = name;
        this.number0 = number0;
        this.number1 = number1;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getDate()
    {
        return number0;
    }

    public void setDate(double date)
    {
        this.number0 = date;
    }

    public double getNumber()
    {
        return number1;
    }

    public void setNumber(double number)
    {
        this.number1 = number;
    }

}
