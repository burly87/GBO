package gui.jan.quiz.overview;

import gui.jan.quiz.model.Model;
import gui.jan.quiz.model.Question;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditPresenter
{
    private Model m;

    private EditView ev;

    private Stage stage;

    private WaitView wv;

    private Stage newstage;

    private NewQuestionView nqv = new NewQuestionView(this);

    public void setWaitView(WaitView newwv)
    {
        this.wv = newwv;
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public void setEditView(EditView v)
    {
        this.ev = v;
    }

    public void setModel(Model newm)
    {
        this.m = newm;
    }

    public GridPane initView()
    {
        return ev.initView(m.getResult());
    }

    public void delete()
    {

        Question q = ev.getmarked();
        Scene scene;
        if (q == null)
        {
            scene = wv.information();
        }
        else
        {
            scene = wv.frage();
        }
        buildStage(scene);
    }

    public void deleteq()
    {
        Question q = ev.getmarked();
        if (q == null)
        {
            close();
            buildStage(wv.information());
        }
        else
        {
            m.delete(q);
            close();
        }
    }

    public void add()
    {
        buildStage(nqv.init());
    }

    public void buildStage(Scene scene)
    {
        newstage = new Stage();
        newstage.setScene(scene);
        newstage.initModality(Modality.WINDOW_MODAL);
        newstage.initOwner(stage);
        newstage.showAndWait();
    }

    public void edit()
    {
        Question q = ev.getmarked();

        Scene scene;
        if (q == null)
        {
            scene = wv.information();
        }
        else
        {
            scene = nqv.init(q);
        }
        buildStage(scene);
    }

    public void close()
    {
        newstage.close();
    }

    public void aendern(Question q)
    {
        m.addQuestion(q);
        newstage.close();
    }
}
