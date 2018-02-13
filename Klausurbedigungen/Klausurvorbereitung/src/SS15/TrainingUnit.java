package SS15;
public class TrainingUnit
{
    private String kennung;
    private double entfernung;
    private double zeit;
    private double durchschnitt;
    
    public TrainingUnit(String kennung, double entfernung, double zeit)
    {
        this.kennung = kennung;
        this.entfernung = entfernung;
        this.zeit = zeit;
        this.durchschnitt = entfernung / zeit * 60;
    }
    
    public String getKennung()
    {
        return kennung;
    }
    
    public double getEntfernung()
    {
        return entfernung;
    }
    
    public double getZeit()
    {
        return zeit;
    }
    
    public double getDurchschnitt()
    {
        return durchschnitt;
    }

}
