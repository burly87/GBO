package gui.mvp.quiz.model;

import java.util.ArrayList;

public class Model
{
    private ArrayList<Question> container;

    private int currentIndex;

    private int lastSelectedIndex;

    public Model()
    {
        container = new ArrayList<>();
        currentIndex = 0;
        lastSelectedIndex = -1;
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

    public boolean hasNext() // prüfen ob es noch eine question gibt
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

    /* Statistik */
    // public int getCorrect()
    // {
    // return question.getCorrect();
    // }
    //
    // public void incCorrect()
    // {
    // question.incCorrect();
    // }
    //
    // public int getAmount()
    // {
    // return question.getAmount();
    // }
    //
    // public void incAmount()
    // {
    // question.incAmount();
    // }

}
