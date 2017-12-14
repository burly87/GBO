package gui.mvp.quiz.model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
    private ArrayList<Question> container;

    private int currentIndex;

    private int lastSelectedIndex;

    private ObservableList<Question> list = FXCollections.observableArrayList();

    public ObservableList<Question> getResult()
    {
        list.clear();

        for (Question i : container)
        {
            List<String> t = new ArrayList<String>();
            t.add(i.toString());
            t.add(String.valueOf(i.getAmount()));
            list.add(i);
        }
        return list;
    }

    public Model()
    {
        container = new ArrayList<>();
        currentIndex = 0;
        lastSelectedIndex = -1;
    }

    public void deleteQuestion(Question q)
    {
        container.remove(q);
    }

    public void replaceQuestion(Question old, Question n)
    {
        int i = container.indexOf(old);
        container.remove(old);
        container.add(i, n);
    }

    public void addQuestion(Question q)
    {
        container.add(q);
    }

    public void reset()
    {
        lastSelectedIndex = -1;
        currentIndex = 0;
    }

    public void next()
    {
        currentIndex++;
    }

    public String[] getAnswer()
    {
        return container.get(currentIndex).getPossibleAnswers();
    }

    public String getQuestion()
    {
        return container.get(currentIndex).getQuestion();
    }

    public void choose(int selected)// antwort mit correct prüfen
    {
        if (currentIndex >= 0 && selected >= 0)
        {
            lastSelectedIndex = selected;
            container.get(currentIndex).incAmount(selected == container.get(currentIndex).getIndexOfCorrectAnswer());
        }
    }

    public boolean hasNext()
    {
        return (currentIndex + 1) < container.size();
    }

    public ArrayList<Question> getQuestionList()
    {
        return container;
    }

    public int getLastSelectedIndex()
    {
        return lastSelectedIndex;
    }

    public void delete(Question question)
    {
        container.remove(question);
    }

}
