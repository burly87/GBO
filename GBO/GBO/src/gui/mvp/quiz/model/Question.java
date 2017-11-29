package gui.mvp.quiz.model;

public class Question
{
	private String question;
	private String[] possibleAnswers;
	private int indexOfCorrectAnswer;
	
	// weitere Attribute nach Bedarf
	
	public Question(String question, String[] possibleAnswers,
	int indexOfCorrectAnswer)
	{
		// ...
	}
	public String getQuestion()
	{
		return question;
	}
	public String[] getPossibleAnswers()
	{
		return possibleAnswers;
	}
	public int getIndexOfCorrectAnswer()
	{
		return indexOfCorrectAnswer;
	}
	
	// weitere Methoden nach Bedarf
}
