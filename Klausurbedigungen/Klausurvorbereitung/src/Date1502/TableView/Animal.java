package Date1502.TableView;

public class Animal
{
	private String name, country;
	private double size, population;
	
	
	public Animal(String name, String country, double size, double population)
	{
		super();
		this.name = name;
		this.country = country;
		this.size = size;
		this.population = population;
	}


	public String getName()
	{
		return name;
	}

	public String getCountry()
	{
		return country;
	}

	public double getSize()
	{
		return size;
	}

	public double getPopulation()
	{
		return population;
	}

}
