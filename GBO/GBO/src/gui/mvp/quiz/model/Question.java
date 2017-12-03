package gui.mvp.quiz.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Question
{
    private String question;

    private String[] possibleAnswers;

    private int indexOfCorrectAnswer;

    private List<SimpleStringProperty> answer = new ArrayList<SimpleStringProperty>();

    private SimpleStringProperty frage;

    private SimpleIntegerProperty amount;

    private SimpleIntegerProperty correct;

    private SimpleStringProperty loesung;

    // weitere Attribute nach Bedarf
    public Question(String question, String[] possibleAnswers, int indexOfCorrectAnswer)
    {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
    }

    public Question(String frage, String ansOne, String ansTwo, String ansThree, String ansFour)
    {
        this.frage = new SimpleStringProperty(frage);
        ansOne = this.possibleAnswers[0];
        ansTwo = this.possibleAnswers[1];
        ansThree = this.possibleAnswers[2];
        ansFour = this.possibleAnswers[3];

        loesung = new SimpleStringProperty();

    }

    public ObservableList<String> getQuestion() // frage
    {
        ObservableList<String> q = FXCollections.observableArrayList(frage.get());
        for (SimpleStringProperty i : answer) // geht glaube ich nicht
        {
            q.add(i.get());
        }
        return q;
    }

    public String[] getPossibleAnswers() // antwortm�glichkeit 1-4
    {
        return possibleAnswers;
    }

    public int getIndexOfCorrectAnswer() // l�sung
    {
        return indexOfCorrectAnswer;
    }

    public String toString()
    {
        return question + " (Antworten: " + amount + ", davon richtig: " + correct + ")";
    }

    // weitere Methoden nach Bedarf
    public String getAnswer()
    {
        return loesung.get();
    }

    public int getAmount()
    {
        return amount.get();
    }

    public void incAmount() // increase
    {
        this.amount.set(amount.get() + 1);
    }

    public int getCorrect()
    {
        return correct.get();
    }

    public void incCorrect() // increase
    {
        this.correct.set(correct.get() + 1);
    }

    public void clear()
    {
        this.amount = new SimpleIntegerProperty(0);
        this.correct = new SimpleIntegerProperty(0);
    }
}
