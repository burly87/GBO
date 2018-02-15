package SS15NEU;

public class TrainingUnit
{
	private String kennung;
	private double entfernung, time, durchschnitt;
	
	public TrainingUnit(String kennung, double entfernung, double time)
	{
		super();
		this.kennung = kennung;
		this.entfernung = entfernung;
		this.time = time;
	}
	public String getKennung()
	{
		return kennung;
	}
	public double getEntfernung()
	{
		return entfernung;
	}
	public double getTime()
	{
		return time;
	}
	public double getDurchschnitt()
	{
		return entfernung/time;
	}
	
	

}
