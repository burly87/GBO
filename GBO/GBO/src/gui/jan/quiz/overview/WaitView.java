package gui.jan.quiz.overview;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WaitView
{
    private EditPresenter ep;

    public WaitView(EditPresenter ep)
    {
        this.ep = ep;
    }

    public Scene information()
    {
        VBox root = new VBox();
        Button okay = new Button();
        okay.setText("Okay");
        okay.setOnAction(e -> close());
        Label label = new Label();
        label.setText("Es muss eine Frage ausgewählt werden!");
        root.getChildren().add(label);
        root.getChildren().add(okay);
        return new Scene(root);
    }

    public Scene frage()
    {
        VBox root = new VBox();
        Button yes = new Button();
        yes.setText("Ja");
        yes.setOnAction(e -> delete());
        Button no = new Button();
        no.setText("Nein");
        no.setOnAction(e -> close());
        Label label = new Label();
        label.setText("Soll diese Frage gelöscht werden?");
        root.getChildren().add(label);
        root.getChildren().add(yes);
        root.getChildren().add(no);
        return new Scene(root);
    }

    public void delete()
    {
        ep.deleteq();
    }

    public void close()
    {
        ep.close();
    }
}
