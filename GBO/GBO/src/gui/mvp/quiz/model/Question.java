package gui.mvp.quiz.model;

public class Question
{
    private String question;

    private String[] possibleAnswers;

    private int indexOfCorrectAnswer;

    private int correctCounter;

    private int amount;

    // weitere Attribute nach Bedarf
    public Question(String question, String[] possibleAnswers, int indexOfCorrectAnswer)
    {
        if (indexOfCorrectAnswer < 0 || indexOfCorrectAnswer >= possibleAnswers.length)
        {
            throw new IllegalArgumentException("out of index");
        }

        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;

    }

    public int getAmount()
    {
        return amount;
    }

    // Old
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
    public void incAmount(boolean correct) // increase
    {
        amount++;
        if (correct)
        {
            correctCounter++;
        }
    }

    public void reset()
    {
        amount = 0;
        correctCounter = 0;
    }

    // @Override
    // public String toString()
    // {
    // return question + " (Antworten: " + amount + ", davon richtig: " +
    // correctCounter + ")";
    // }
}
