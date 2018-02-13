package TabelleMVP;

public class Animal
{
	private String name, gattung, country;
	private int population;
	public Animal(String name, String gattung, String country, int population)
	{
		super();
		this.name = name;
		this.gattung = gattung;
		this.country = country;
		this.population = population;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getGattung()
	{
		return gattung;
	}
	public void setGattung(String gattung)
	{
		this.gattung = gattung;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public int getPopulation()
	{
		return population;
	}
	public void setPopulation(int population)
	{
		this.population = population;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
}
