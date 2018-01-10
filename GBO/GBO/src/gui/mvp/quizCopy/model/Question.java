package gui.mvp.quizCopy.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Question
{
    private SimpleStringProperty question;

    private String[] possibleAnswers;

    private int indexOfCorrectAnswer;

    private SimpleIntegerProperty correctCounter;

    private SimpleIntegerProperty amount;

    // weitere Attribute nach Bedarf
    public Question(String question, String[] possibleAnswers, int indexOfCorrectAnswer)
    {
        if (indexOfCorrectAnswer < 0 || indexOfCorrectAnswer >= possibleAnswers.length)
        {
            throw new IllegalArgumentException("out of index");
        }

        correctCounter = new SimpleIntegerProperty();
        amount = new SimpleIntegerProperty();

        this.question = new SimpleStringProperty(question);
        this.possibleAnswers = possibleAnswers;
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;

    }

    public String getQuestion()
    {
        return question.get();
    }

    public SimpleStringProperty questionProp()
    {
        return question;
    }

    public int getAmount()
    {
        return amount.get();
    }

    public SimpleIntegerProperty amountProp()
    {
        return amount;
    }

    public int getCorrectCounter()
    {
        return correctCounter.get();
    }

    public SimpleIntegerProperty correctCountProp()
    {
        return correctCounter;
    }

    public String[] getPossibleAnswers()
    {
        return possibleAnswers;
    }

    public int getIndexOfCorrectAnswer()
    {
        return indexOfCorrectAnswer;
    }

    public void incAmount(boolean correct) // increase
    {
        amount.set(amount.get() + 1);
        ;
        if (correct)
        {
            correctCounter.set(correctCounter.get() + 1);
            ;
        }
    }

    public void reset()
    {
        amount.set(0);
        correctCounter.set(0);
    }

    @Override
    public String toString()
    {
        return question.get();
    }
}
