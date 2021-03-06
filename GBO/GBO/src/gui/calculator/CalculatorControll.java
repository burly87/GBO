package gui.calculator;

import java.net.URL;
import java.util.ResourceBundle;

import javax.script.ScriptException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorControll extends Computation
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonPoint;

    @FXML
    private Button buttonIs;

    @FXML
    private Button buttonKlammerauf;

    @FXML
    private Button buttonKlammerzu;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonPlus;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonMulti;

    @FXML
    private Button buttonDivi;

    @FXML
    private TextField display; // Texttfeld ausgabe

    private String text = ""; // KA

    private String ausgabe = ""; // text evaluate temp

    @FXML
    void clickedClear(ActionEvent event)
    {
        display.clear();
        text = "";
        ausgabe = "";
    }

    @FXML
    void clickedDelete(ActionEvent event)
    {
        try
        {
            display.setText(display.getText().substring(0, display.getText().length() - 1));
        }
        catch (RuntimeException e)
        {
            ausgabe = "";
        }
    }

    @FXML
    void buttonClicked(ActionEvent event)
    {

        Button result = (Button) event.getSource();

        if (event.getSource().equals(buttonIs) && !text.equals(""))
        {
            try
            {
                Object temp = evaluate(text);
                System.out.println("Ergebnis: " + temp);
                ausgabe = temp.toString();
                // ergebnis.setText(text + ausgabe);

            }

            catch (ScriptException e)
            {
                ausgabe += ">FEHLER";
            }

        }

        text += result.getText();
        display.setText(text + ausgabe);
        System.out.println("Ergebnis: " + display);
        System.out.println("Text: " + text);
        System.out.println("Ausgabe: " + ausgabe);
    }

    @FXML
    void initialize()
    {
        assert buttonClear != null : "fx:id=\"buttonClear\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonDelete != null : "fx:id=\"buttonDelete\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonPoint != null : "fx:id=\"buttonPoint\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonIs != null : "fx:id=\"buttonIs\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonKlammerauf != null : "fx:id=\"buttonKlammerauf\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonKlammerzu != null : "fx:id=\"buttonKlammerzu\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button3 != null : "fx:id=\"button3\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button4 != null : "fx:id=\"button4\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button5 != null : "fx:id=\"button5\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button6 != null : "fx:id=\"button6\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button7 != null : "fx:id=\"button7\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button8 != null : "fx:id=\"button8\" was not injected: check your FXML file 'calculator.fxml'.";
        assert button9 != null : "fx:id=\"button9\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonPlus != null : "fx:id=\"buttonPlus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonMinus != null : "fx:id=\"buttonMinus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonMulti != null : "fx:id=\"buttonMulti\" was not injected: check your FXML file 'calculator.fxml'.";
        assert buttonDivi != null : "fx:id=\"buttonDivi\" was not injected: check your FXML file 'calculator.fxml'.";
        assert display != null : "fx:id=\"ergebnis\" was not injected: check your FXML file 'calculator.fxml'.";

    }
}
