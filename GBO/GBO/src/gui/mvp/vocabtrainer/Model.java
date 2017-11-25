package gui.mvp.vocabtrainer;

import java.util.HashMap;

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

}
