package gui.mvp.quiz.editor;

import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.main.UndoRedoManager;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;

public class EditorPresenter
{

    private Model model;

    private EditorView editorview;

    private UndoRedoManager manager;

    private MainPresenter mp;

    public EditorPresenter()
    {
        this.manager = new UndoRedoManager();
    }

    public EditorView getView()
    {
        editorview.initList();
        return editorview;
    }

    public void setManager(UndoRedoManager m)
    {
        this.manager = m;
    }

    public void setModel(Model mo)
    {
        model = mo;
    }

    public void setView(EditorView ev)
    {
        editorview = ev;
    }

    // ------------- UndoRedo

    public void canRedo()
    {
        manager.redo();
    }

    public void undo()
    {
        System.out.println("undo ausgefuehrt");
        manager.undo();
        // mainPresenter.setRedoBtn();
        editorview.initList();
    }

    public void redo()
    {
        System.out.println("redo ausgefuehrt");
        manager.redo();
        // mainPresenter.setUndoBtn();
        editorview.initList();
    }

    // ------------- Question add, change, show, delete

    public void addQuestion(Question q)
    {
        model.addQuestion(q);
    }

    public void changeQuestion(Question old, Question n)
    {
        model.replaceQuestion(old, n);
    }

    public void deleteQuestion(Question q)
    {
        mp.setUndoBtn();
        if (q == null)
        {
            editorview.showSelectedDialog();
        }
        else
        {

            editorview.showDeleteDialog();
        }
    }

    // delete Question
    public void deleteQuestion(Question q, boolean delete)
    {
        if (delete)
        {
            manager.saveQuestion();
            model.deleteQuestion(q);
            editorview.initList();
        }

    }

    public void showEdit(Question q)
    {
        if (q != null)
        {
            EditView ev = new EditView(true, this);
            ev.init(q);
            ev.showAndWait();
            editorview.initList();
        }
        else
        {
            editorview.showSelectedDialog();
        }
    }

    public void showNew()
    {
        EditView ev = new EditView(false, this);
        ev.showAndWait();
        editorview.initList();
    }

    public Question getQuestion()
    {
        return editorview.getQuestion();

    }

    public Question[] getQuestions()
    {
        return model.getQuestionList().toArray(new Question[model.getQuestionList().size()]);

    }

    public int getSelectedIndex()
    {
        return editorview.getSelectedIndex();
    }

    public void setMainPresenter(MainPresenter mainPresenter)
    {
        this.mp = mainPresenter;
    }

}
