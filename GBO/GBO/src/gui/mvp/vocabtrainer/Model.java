package gui.mvp.vocabtrainer;

import java.util.HashMap;
import java.util.Random;

public class Model
{
	private HashMap<String, String> vocables;

	
	public Model()
	{
		vocables = new HashMap<>();
		vocables.put("Katze", "cat");
		vocables.put("Hund","dog");
		vocables.put("Naddy", "sweet");		
	}
	
	public boolean isCorrect(String gerWord, String engWord) 
	{
		return engWord.equals(vocables.get(gerWord));
	}

    public String nextHashElement()
    {
        Random generator = new Random();
        Object[] randKey = vocables.keySet().toArray();
        String randomKey = (String) randKey[generator.nextInt(randKey.length)];
        return randomKey;
    }
}
