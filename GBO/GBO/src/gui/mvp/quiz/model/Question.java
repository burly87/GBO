package gui.mvp.quiz.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Question
{
    private String question;

    private String[] possibleAnswers;

    private int indexOfCorrectAnswer;

    private int correctCounter;

    private int amount;

    // Für TableView
    private SimpleStringProperty questionT;

    private SimpleIntegerProperty possibleAnswersT;

    private SimpleIntegerProperty indexOfCorrectAnswerT;

    Question(String questionT, int possibleAnswersT, int indexOfCorrectAnswerT)
    {
        this.questionT = new SimpleStringProperty(questionT);
        this.possibleAnswersT = new SimpleIntegerProperty(possibleAnswersT);
        this.indexOfCorrectAnswerT = new SimpleIntegerProperty(indexOfCorrectAnswerT);
    }

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

    // Getter TableView
    public String getQuestionT()
    {
        return questionT.get();
    }

    public int getPossibleAnswersT()
    {
        return possibleAnswersT.get();
    }

    public int getIndexofCorrectAnswerT()
    {
        return indexOfCorrectAnswerT.get();
    }

    // Setter TableView
    public void setQuestionT(String questionT)
    {
        this.questionT = new SimpleStringProperty(questionT);
    }

    public void setPossibleAnswersT(int possibleAnswersT)
    {
        this.possibleAnswersT = new SimpleIntegerProperty(possibleAnswersT);
    }

    public void setIndexOfCorrectAnswerT(int indexOfCorrectAnswerT)
    {
        this.indexOfCorrectAnswerT = new SimpleIntegerProperty(indexOfCorrectAnswerT);
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
