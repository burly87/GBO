package gui.country.combo;

public class Country
{
    private String name;

    private String capital;

    private long people;

    private long area;

    public Country(String name, String capital, long people, long area)
    {
        super();
        this.name = name;
        this.capital = capital;
        this.people = people;
        this.area = area;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public String getName()
    {
        return name;
    }

    public String getCapital()
    {
        return capital;
    }

    public long getPeople()
    {
        return people;
    }

    public long getArea()
    {
        return area;
    }

    public long getDensity()
    {

        long temp1 = getPeople() / getArea();
        double temp = (double) getPeople() / (double) getArea();

        if (temp % (long) temp >= 0.5)
        {

            temp1 += 1;
        }
        return temp1;
        // OR BETER
        // return (double) Math.round((double) getPeople() / getArea());

    }

}
