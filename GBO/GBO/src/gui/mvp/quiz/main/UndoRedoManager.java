package gui.mvp.quiz.main;

import java.util.ArrayList;

import gui.mvp.quiz.editor.EditorPresenter;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;

public class UndoRedoManager
{
    private Model model;

    private EditorPresenter presenter;

    private MainPresenter mainPresenter;

    private ArrayList<Question> undoRedoSaver;

    private ArrayList<Integer> saveIndexOfQuestion;

    private ArrayList<Integer> action;

    private int currentPosition = -1;

    public void setModel(Model mo)
    {
        model = mo;
    }

    public void setMainPresenter(MainPresenter mp)
    {
        this.mainPresenter = mp;
    }

    public void setPresenter(EditorPresenter presenter)
    {
        this.presenter = presenter;
    }

    public UndoRedoManager()
    {
        undoRedoSaver = new ArrayList<Question>();
        saveIndexOfQuestion = new ArrayList<Integer>();
        action = new ArrayList<Integer>();

    }

    public void saveQuestion()
    {
        // System.out.println("saveQuestion ausgefuehrt. currentPos:" +
        // currentPosition + " " + action);
        undoRedoSaver.add(presenter.getQuestion());
        saveIndexOfQuestion.add(presenter.getSelectedIndex());
        action.add(1); // delete
        currentPosition++;
        // System.out.println("saveQuestion ausgefuehrt. currentPos:" +
        // currentPosition + " " + action);
    }

    public boolean canUndo()
    {
        if (currentPosition >= 0)
        {
            // System.out.println("canUndo() -> mainPresenter.setUndoBtn()");
            mainPresenter.setRedoBtn();
            return true;
        }

        return false;
    }

    public boolean canRedo()
    {
        if (currentPosition < action.size())
        {
            // System.out.println("canRedo()");
            mainPresenter.setUndoBtn();
            return true;
        }

        return false;
    }

    public void undo()
    {

        if (canUndo())
        {

            if (action.get(currentPosition) == 1)
            {
                // System.out.println("action.get(currentPosition): " +
                // action.get(currentPosition));
                model.addQuestion(undoRedoSaver.get(currentPosition), saveIndexOfQuestion.get(currentPosition));
            }

            // hinzufuegenUndo
            else
            {
                saveQuestion();
                model.deleteLast();
            }
            --currentPosition;

        }
    }

    public void redo()
    {
        // System.out.println("redo " + action + " " + currentPosition);
        if (canRedo())
        {
            ++currentPosition;
            if (action.get(currentPosition) == 1)
            {
                model.delete(undoRedoSaver.get(currentPosition));
            }

            // hinzugfuegen
            else
            {
                model.addQuestion(undoRedoSaver.get(currentPosition));
                // System.out.println("action " + action + "test " +
                // currentPosition);
            }
        }

    }

}