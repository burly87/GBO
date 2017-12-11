package gui.mvp.quiz2.model;

import java.util.ArrayList;

public class Model
{

    private ArrayList<Question> questList;

    private int currentQuestIndex;

    private int lastSelectedAnswerIndex;

    public Model()
    {
        questList = new ArrayList<>();
        currentQuestIndex = 0;
        lastSelectedAnswerIndex = -1;
    }

    public void deleteQuestion(Question q)
    {
        questList.remove(q);
    }

    public void deleteQuestion(int i)
    {
        questList.remove(i);
    }

    public void restart()
    {
        lastSelectedAnswerIndex = -1;
        currentQuestIndex = 0;
    }

    public void addQuestion(Question q)
    {
        questList.add(q);
    }

    public void replaceQuestion(Question old, Question n)
    {
        int i = questList.indexOf(old);
        questList.remove(old);
        questList.add(i, n);
    }

    public void next()
    {
        currentQuestIndex++;
    }

    public String[] getAnswers()
    {
        return questList.get(currentQuestIndex).getPossibleAnswers();
    }

    public String getQuestion()
    {
        return questList.get(currentQuestIndex).getQuestion();
    }

    public void evaluate(int selected)
    {
        if (currentQuestIndex >= 0 && selected >= 0)
        {
            lastSelectedAnswerIndex = selected;
            questList.get(currentQuestIndex).incCount(selected == questList.get(currentQuestIndex).getIndexOfCorrectAnswer());
        }

    }

    public boolean hasNext()
    {
        return (currentQuestIndex + 1) < questList.size();
    }

    public ArrayList<Question> getQuestList()
    {
        return questList;
    }

    public int getLastSelectedAnswerIndex()
    {
        return lastSelectedAnswerIndex;
    }
}
