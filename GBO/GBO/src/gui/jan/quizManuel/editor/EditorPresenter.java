package gui.jan.quizManuel.editor;

import gui.jan.quizManuel.model.Model;
import gui.jan.quizManuel.model.Question;

public class EditorPresenter
{

    private Model m;

    private EditorView view;

    public EditorPresenter()
    {
    }

    public void deleteQuestion(Question q)
    {
        if (q == null)
        {
            view.showSelectedDialog();
        }
        else
        {
            view.showDeleteDialog();
        }
    }

    public void deleteQuestion(Question q, boolean delete)
    {
        if (delete)
        {
            m.deleteQuestion(q);
            view.initList();
        }

    }

    public void addQuestion(Question q)
    {
        m.addQuestion(q);
    }

    public void changeQuestion(Question old, Question n)
    {
        m.replaceQuestion(old, n);
    }

    public EditorView getView()
    {
        view.initList();
        return view;
    }

    public void showEdit(Question q)
    {
        if (q != null)
        {
            EditView ev = new EditView(true, this);
            ev.init(q);
            ev.showAndWait();
            view.initList();
        }
        else
        {
            view.showSelectedDialog();
        }
    }

    public void showNew()
    {
        EditView ev = new EditView(false, this);
        ev.showAndWait();
        view.initList();
    }

    public void setModel(Model mo)
    {
        m = mo;
    }

    public void setView(EditorView ev)
    {
        view = ev;
    }

    public Question getQuestion()
    {
        return view.getQuestion();
    }

    public Question[] getQuestions()
    {
        return m.getQuestList().toArray(new Question[m.getQuestList().size()]);

    }
}
