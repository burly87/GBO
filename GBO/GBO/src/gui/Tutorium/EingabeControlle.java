package gui.Tutorium;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EingabeControlle extends Application
{

    /*
     * Funktioniert alles an sich, jedoch sollte garnicht unbedingt auf der
     * Ebene der Key events arbeiten Besser: TextProperty & ChangeListener
     */

    @Override
    public void start(Stage primaryStage)
    {
        VBox root = new VBox(10);
        TextField input = new TextField();
        root.getChildren().add(input);
        input.textProperty().addListener((elem, oldText, newText) -> textListener(elem, oldText, newText));
        input.setOnKeyTyped(e -> inputControl(e));

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Eingabekontrolle");
        primaryStage.show();
    }

    private void textListener(ObservableValue<? extends String> elem, String oldText, String newText)
    {
        System.out.println("wird ausgef�hrt");
        if (!isDigitString(newText))
        {
            ((TextInputControl) elem).setText(oldText);
        }
    }

    private boolean isDigitString(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (!Character.isDigit(s.charAt(i)))
            {
                return false;
            }

        }
        return true;

    }

    private void inputControl(KeyEvent e)
    {
        String typed = e.getCharacter();
        if (!isDigitString(typed))
        {
            TextField tf = (TextField) e.getSource();
            String text = tf.getText();
            text = text.replaceAll(typed, ""); // erzeugt neues StringObjekt
            tf.setText(text);
            e.consume(); // notwendig!
        }

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
