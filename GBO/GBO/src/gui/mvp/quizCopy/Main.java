package gui.mvp.quizCopy;

import gui.mvp.quiz.editor.EditorPresenter;
import gui.mvp.quiz.editor.EditorView;
import gui.mvp.quiz.game.QuizPresenter;
import gui.mvp.quiz.game.QuizView;
import gui.mvp.quiz.main.MainPresenter;
import gui.mvp.quiz.main.MainView;
import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.overview.OverviewPresenter;
import gui.mvp.quiz.overview.OverviewView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application

{

    @Override
    public void start(Stage stage) throws Exception
    {
        Model m = ModelInitializer.initModel(this.getParameters().getUnnamed().get(0));
        MainPresenter mainPresenter = initApplication(m);

        mainPresenter.showQuiz(false);
        Scene scene = new Scene(mainPresenter.getView(), 600, 300);

        stage.setScene(scene);
        stage.setTitle("Quiz");
        stage.show();
    }

    private MainPresenter initApplication(Model model)
    { // Objekte erzeugen
        MainPresenter mainPresenter = new MainPresenter();
        MainView mainView = new MainView();

        QuizPresenter quizPresenter = new QuizPresenter();
        QuizView quizView = new QuizView(quizPresenter);

        OverviewPresenter overviewPresenter = new OverviewPresenter();
        OverviewView overviewView = new OverviewView();

        EditorPresenter editorPresenter = new EditorPresenter();
        EditorView editorView = new EditorView();

        // Klassen verbinden und setzen
        overviewPresenter.setView(overviewView);
        overviewPresenter.setModel(model);
        overviewView.setPresenter(overviewPresenter);
        overviewView.initList();

        quizPresenter.setView(quizView);
        quizPresenter.setModel(model);
        quizView.initView();

        mainView.setPresenter(mainPresenter);

        editorPresenter.setView(editorView);
        editorPresenter.setModel(model);
        editorView.setPresenter(editorPresenter);

        mainPresenter.setView(mainView);
        mainPresenter.setOverviewPresenter(overviewPresenter);
        mainPresenter.setQuizPresenter(quizPresenter);
        mainPresenter.start();
        mainPresenter.init(quizPresenter, overviewPresenter, editorPresenter, mainView);

        return mainPresenter;
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
