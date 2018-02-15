package Date1502.ListView;

public class Country
{
	private String name;
	private int population, size;
	public Country countryNew;
	public Country(String name, int population, int size)
	{
		super();
		this.name = name;
		this.population = population;
		this.size = size;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getPopulation()
	{
		return population;
	}
	public void setPopulation(int population)
	{
		this.population = population;
	}
	public int getSize()
	{
		return size;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
