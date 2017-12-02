package gui.jan.quiz.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Question
{
    private SimpleStringProperty frage;

    private List<SimpleStringProperty> answer = new ArrayList<SimpleStringProperty>();

    private SimpleStringProperty antwort1;

    private SimpleStringProperty antwort2;

    private SimpleStringProperty antwort3;

    private SimpleStringProperty antwort4;

    private SimpleStringProperty loesung;

    private SimpleIntegerProperty amount;

    private SimpleIntegerProperty correct;
    Question(String frage, List<String> answer, String loesung)
    {
        this.frage = new SimpleStringProperty(frage);
        this.loesung = new SimpleStringProperty(loesung);
        for(String i: answer)
        {
            this.answer.add(new SimpleStringProperty(i));
        }
        this.amount = new SimpleIntegerProperty(0);
        this.correct = new SimpleIntegerProperty(0);
    }
    public Question(String frage, String eins, String zwei, String drei, String vier, String loesung)
    {
        this.frage = new SimpleStringProperty(frage);
        this.antwort1 = new SimpleStringProperty(eins);
        answer.add(antwort1);
        this.antwort2 = new SimpleStringProperty(zwei);
        answer.add(antwort2);
        this.antwort3 = new SimpleStringProperty(drei);
        answer.add(antwort3);
        this.antwort4 = new SimpleStringProperty(vier);
        answer.add(antwort4);
        this.loesung = new SimpleStringProperty(loesung);
        this.amount = new SimpleIntegerProperty(0);
        this.correct = new SimpleIntegerProperty(0);
    }
    public String toString()
    {
        return frage.get();
    }
    public void addAnswer(String a)
    {
        answer.add(new SimpleStringProperty(a));
    }

//    @Override
//    public String toString()
//    {
//        return frage + " Antworten: " + amount + " davon richtig: " + correct;
//    }

    public ObservableList<String> getQA()
    {
        ObservableList<String> t = FXCollections.observableArrayList(frage.get());
        for (SimpleStringProperty i : answer)
        {
            t.add(i.get());
        }
        return t;
    }
    public String getFrage()
    {
        return frage.get();
    }
    public int getAmount()
    {
        return amount.get();
    }

    public void setAmount(int amount)
    {
        this.amount = new SimpleIntegerProperty(amount);
    }

    public int getCorrect()
    {
        return correct.get();
    }

    public void setCorrect(int correct)
    {
        this.correct = new SimpleIntegerProperty(correct);
    }

    public void setAnswer(List<SimpleStringProperty> answer)
    {
        this.answer = answer;
    }

    public String getAnswer()
    {
        return loesung.get();
    }

    public void setcorrect()
    {
        this.correct.set(correct.get()+1);
    }

    public void increaseamount()
    {
        this.amount.set(amount.get()+1);
    }

    public void clear()
    {
        this.amount = new SimpleIntegerProperty(0);
        this.correct = new SimpleIntegerProperty(0);
    }
}
