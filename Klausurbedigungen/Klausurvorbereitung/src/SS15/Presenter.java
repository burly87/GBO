package SS15;
public class Presenter
{
    private View view;
    private Model model;
    
    public Presenter()
    {
        
    }
    
    public void setView(View v)
    {
        this.view = v;
    }
    
    public View getView()
    {
        return view;
    }
    
    public void setModel(Model m)
    {
        this.model = m;
    }

    public void listeSetzen()
    {
        view.listeSetzen();
    }
    
    public TrainingUnit getUnit(String kennung)
    {
        TrainingUnit t = model.getTrainingUnit(kennung);
        return t;
    }
    
    public String[] getKennungen()
    {
        return model.getKennungen();
    }
    
    public void delete(String kennung)
    {
        model.deleteUnit(kennung);
    }
    
    public void unitHinzu(TrainingUnit t)
    {
        model.trainingUnithinzu(t);
    }
}
