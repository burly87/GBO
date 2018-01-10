package gui.mvp.quizCopy.editor;

import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;

public class EditorPresenter
{

    private Model model;

    private EditorView view;

    public EditorPresenter()
    {
    }

    public EditorView getView()
    {
        view.initList();
        return view;
    }

    public void setModel(Model mo)
    {
        model = mo;
    }

    public void setView(EditorView ev)
    {
        view = ev;
    }

    // -------------

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
            model.deleteQuestion(q);
            view.initList();
        }

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

    public Question[] getQuestions()
    {
        return model.getQuestionList().toArray(new Question[model.getQuestionList().size()]);

    }
}
