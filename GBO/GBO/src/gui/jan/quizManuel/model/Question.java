package gui.jan.quizManuel.model;

public class Question
{
    private String question;

    private String[] possibleAnswers;

    private int indexOfCorrectAnswer;

    private int count;

    private int correctCount;

    public Question(String question, String[] possibleAnswers, int indexOfCorrectAnswer)
    {
        if (indexOfCorrectAnswer < 0 || indexOfCorrectAnswer >= possibleAnswers.length)
        {
            throw new IllegalArgumentException("Ungültiger Index");
        }

        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
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

    public void incCount(boolean correct)
    {
        count++;
        if (correct)
        {
            correctCount++;
        }
    }

    public void reset()
    {
        count = 0;
        correctCount = 0;
    }

    @Override
    public String toString()
    {
        return question + " " + " (Antworten: " + count + ", davon richtig: " + correctCount + ")";
    }
}
