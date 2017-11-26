package gui.jan.vocabtrainer;

import java.util.HashMap;
import java.util.Random;

public class Model
{
    private HashMap<String, String> vocabList;
    
    public Model()
    {
        vocabList = new HashMap<>();
        vocabList.put("Katze", "cat");
        vocabList.put("Tisch", "table");
        vocabList.put("Hund", "dog");
    }
    
    public boolean ueberpruefen(String vocab, String translation)
    {
        return translation.equals(vocabList.get(vocab));
    }
    
    public String nextHashElement()
    {
        Random generator = new Random();
        Object[] randKey = vocabList.keySet().toArray();
        String randomKey = (String) randKey[generator.nextInt(randKey.length)];
        return randomKey;
    }
}
