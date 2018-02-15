package SS15NEU;

import java.util.ArrayList;

public class Model
{
    private ArrayList<TrainingUnit> data;
    
    public Model()
    {
        data = new ArrayList<TrainingUnit>();
        data.add(new TrainingUnit("test", 0, 2));
        System.out.println(data);
    }
    
    public void trainingUnithinzu(TrainingUnit tu)
    {
        data.add(tu);
    }
    
    public TrainingUnit getTrainingUnit(String kennung)
    {
        int len = data.size();
        TrainingUnit t = new TrainingUnit(null, 0, 0);
        for(int i = 0; i < len; i++)
        {
            String s = data.get(i).getKennung();
            if(s.equals(kennung))
            {
                t = data.get(i);
                break;
            }
        }
        return t;        
    }
    
    public String[] getKennungen()
    {
        int len = data.size();
        String[] kennungen = new String[len];
        for(int i = 0; i < len; i++)
        {
            kennungen[i] = data.get(i).getKennung();
        }
        return kennungen;
    }
    
    public void deleteUnit(String kennung)
    {
        int len = data.size();
        for(int i = 0; i < len; i++)
        {
            String s = data.get(i).getKennung();
            if(s.equals(kennung))
            {
                data.remove(i);
                break;
            }
        }
    }

}
