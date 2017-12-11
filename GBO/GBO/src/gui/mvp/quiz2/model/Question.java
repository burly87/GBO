package gui.mvp.quiz2.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Question
{
    private SimpleStringProperty question;

    private String[] possibleAnswers;

    private int indexOfCorrectAnswer;

    private SimpleIntegerProperty count;

    private SimpleIntegerProperty correctCount;

    public Question(String question, String[] possibleAnswers, int indexOfCorrectAnswer)
    {
        if (indexOfCorrectAnswer < 0 || indexOfCorrectAnswer >= possibleAnswers.length)
        {
            throw new IllegalArgumentException("Ungültiger Index");
        }

        this.question = new SimpleStringProperty();
        count = new SimpleIntegerProperty();
        correctCount = new SimpleIntegerProperty();

        this.question.set(question);
        this.possibleAnswers = possibleAnswers;
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
    }

    public String getQuestion()
    {
        return question.get();
    }

    public SimpleStringProperty questionProperty()
    {
        return question;
    }

    public int getCount()
    {
        return count.get();
    }

    public int getCorrectCount()
    {
        return correctCount.get();
    }

    public SimpleIntegerProperty countProperty()
    {
        return count;
    }

    public SimpleIntegerProperty correctCountProperty()
    {
        return correctCount;
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
        count.set(count.get() + 1);
        if (correct)
        {
            correctCount.set(correctCount.get() + 1);
        }
    }

    public void reset()
    {
        count.set(0);
        correctCount.set(0);
    }

    @Override
    public String toString()
    {
        return question.get();
    }
}
