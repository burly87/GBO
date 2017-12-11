package gui.jan.quizManuel.editor;

import java.util.Optional;

import gui.jan.quizManuel.model.Question;
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

    private ListView<Question> questList;

    private Button newBtn, editBtn, delBtn;

    private EditorPresenter ep;

    public EditorView()
    {
        Label l = new Label("Editor");
        questList = new ListView<>();
        newBtn = new Button("Frage Hinzufügen");
        editBtn = new Button("Frage editieren");
        delBtn = new Button("Frage löschen");
        HBox btns = new HBox();

        delBtn.setOnAction(e -> handleDelete());
        editBtn.setOnAction(e -> handleEdit());
        newBtn.setOnAction(e -> handleNew());

        delBtn.setId("deleteQuestion");
        editBtn.setId("editQuestion");
        newBtn.setId("addQuestion");

        btns.getChildren().add(newBtn);
        btns.getChildren().add(editBtn);
        btns.getChildren().add(delBtn);
        this.getChildren().add(l);
        this.getChildren().add(questList);
        this.getChildren().add(btns);
    }

    public void showSelectedDialog()
    {
        Alert a = new Alert(AlertType.INFORMATION);
        a.setHeaderText("Keine Frage ausgewählt");
        a.showAndWait();
    }

    public void showDeleteDialog()
    {
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setHeaderText("");
        a.setContentText("Soll die Frage gelöscht werden?");
        Optional<ButtonType> res = a.showAndWait();
        if (res.get() == ButtonType.OK)
        {
            ep.deleteQuestion(questList.getSelectionModel().getSelectedItem(), true);
        }
    }

    public void initList()
    {
        questList.getItems().clear();
        questList.getItems().addAll(ep.getQuestions());
    }

    public void handleDelete()
    {
        ep.deleteQuestion(questList.getSelectionModel().getSelectedItem());
    }

    public void handleNew()
    {
        ep.showNew();
    }

    public void handleEdit()
    {
        ep.showEdit(questList.getSelectionModel().getSelectedItem());
    }

    public void setPresenter(EditorPresenter p)
    {
        ep = p;
    }

}
