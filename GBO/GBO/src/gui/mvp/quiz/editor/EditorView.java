package gui.mvp.quiz.editor;

import java.util.Optional;

import gui.mvp.quiz.model.Question;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditorView extends VBox
{
    private EditorPresenter presenter;

    private ListView<Question> editorList;

    private Button addQuestion;

    private Button editQuestion;

    private Button deleteQuestion;

    public EditorView()
    {
        Label label = new Label("Editor");
        editorList = new ListView<>();
        addQuestion = new Button("Frage hinzuf\u00fcgen");
        editQuestion = new Button("Frage editieren");
        deleteQuestion = new Button("Frage l\u00f6schen");
        HBox questionButtons = new HBox();

        addQuestion.setOnAction(e -> add());
        editQuestion.setOnAction(e -> edit());
        deleteQuestion.setOnAction(e -> delete());

        editorList.setId("editorList");
        addQuestion.setId("addQuestion");
        editQuestion.setId("editQuestion");
        deleteQuestion.setId("deleteQuestion");

        questionButtons.getChildren().add(addQuestion);
        questionButtons.getChildren().add(editQuestion);
        questionButtons.getChildren().add(deleteQuestion);

        this.getChildren().addAll(label, editorList, questionButtons);

    }

    public void showSelectedDialog()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setContentText("Keine Frage ausgew\u00e4hlt");
        alert.showAndWait();
    }

    public void showDeleteDialog()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("");
        alert.setContentText("Soll die Frage gel\u00f6scht werden?");
        Optional<ButtonType> res = alert.showAndWait();
        if (res.get() == ButtonType.OK)
        {
            presenter.deleteQuestion(editorList.getSelectionModel().getSelectedItem(), true);
        }
    }

    public void initList()
    {
        editorList.getItems().clear();
        editorList.getItems().addAll(presenter.getQuestions());
    }

    public void delete()
    {
        presenter.deleteQuestion(editorList.getSelectionModel().getSelectedItem());
    }

    public void add()
    {
        presenter.showNew();
    }

    public void edit()
    {
        presenter.showEdit(editorList.getSelectionModel().getSelectedItem());
    }

    public void setPresenter(EditorPresenter editorPresenter)
    {
        this.presenter = editorPresenter;
    }

}
