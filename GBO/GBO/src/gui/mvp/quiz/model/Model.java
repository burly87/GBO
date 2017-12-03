package gui.mvp.quiz.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
    private LinkedList<Question> container;

    private ObservableList<Question> list = FXCollections.observableArrayList();

    private Question question;

    public Model()
    {
        container = new LinkedList<Question>();
        // container.add(new Question("1+1", "1", "2", "3", "4", "2"));
         container.add(new Question("Was ist das?", "blaues lich", "rotes
         licht", "gr�nes licht", "gelbes licht", "blaues licht"));
         container.add(new Question("..Und was macht das?", "es leuchtet
         blau", "es leuchtet rot", "es leuchtet gr�n", "es leuchtet gelb", "es
         leuchtet blau"));
    }

    public void addQuestion(Question q)
    {

    }

    public ObservableList<Question> getResult()
    {
        list.clear();
        for (Question i : container)
        {
            List<String> temp = new ArrayList<String>();
            temp.add(i.toString());
            temp.add(String.valueOf(i.getAmount()));
            list.add(i);
        }
        return list;
    }

    public void clear()
    {
        for (Question i : container)
        {
            i.clear();
        }

    }

    public ObservableList<String> getFirst()
    {
        question = container.getFirst();
        return question.getQuestion();
    }

    public String getAnswer()
    {
        return question.getAnswer();
    }

    /* Statistik */
    public int getCorrect()
    {
        return question.getCorrect();
    }

    public void incCorrect()
    {
        question.incCorrect();
    }

    public int getAmount()
    {
        return question.getAmount();
    }

    public void incAmount()
    {
        question.incAmount();
    }

}
