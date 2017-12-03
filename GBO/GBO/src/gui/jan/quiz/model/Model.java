package gui.jan.quiz.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
    private LinkedList<Question> container;

    private Question actuellquestion;

    private ObservableList<Question> liste = FXCollections.observableArrayList();

    public Model()
    {
        container = new LinkedList<Question>();
        container.add(new Question("Was ist 1+1?", "2", "4", "6", "8", "2"));
        container.add(new Question("Was ist das?", "blaues licht", "rotes licht", "gruenes licht", "gelbes licht", "blaues licht"));
        container.add(new Question("..Und was macht das?", "es leuchtet blau", "es leuchtet rot", "es leuchtet gruen", "es leuchtet gelb", "es leuchtet blau"));
   
    }

    public void newQuestion(String question, List<String> answer, String loesung)
    {
        container.add(new Question(question, answer, loesung));
    }

    public void addQuestion(Question q)
    {
        String frage = q.getFrage();
        for (Question i : container)
        {
            if (i.getFrage().equals(frage))
            {
                container.remove(i);
                break;
            }
        }
        container.add(q);

    }

    public ObservableList<Question> getResult()
    {
        liste.clear();
        for (Question i : container)
        {
            List<String> t = new ArrayList<String>();
            t.add(i.toString());
            t.add(String.valueOf(i.getAmount()));
            liste.add(i);
        }
        return liste;
    }

    public void delete(Question q)
    {
        container.remove(q);
    }

    public ObservableList<String> getFirst()
    {
        actuellquestion = container.getFirst();
        return actuellquestion.getQA();
    }

    public ObservableList<String> getQuestion()
    {
        return actuellquestion.getQA();
    }

    public ObservableList<String> getnextQuestion()
    {
        if (actuellquestion == null)
        {
            actuellquestion = container.getFirst();
        }
        else
        {
            actuellquestion = container.get(container.indexOf(actuellquestion) + 1);
        }
        return actuellquestion.getQA();
    }

    public String getAnswer()
    {
        return actuellquestion.getAnswer();
    }

    public int getcorrect()
    {
        return actuellquestion.getCorrect();
    }

    public void increasecorrect()
    {
        actuellquestion.setcorrect();
    }

    public void clear()
    {
        for (Question i : container)
        {
            i.clear();
        }
    }

    public int getamount()
    {
        return actuellquestion.getAmount();
    }

    public void increaseamount()
    {
        actuellquestion.increaseamount();
    }
}
