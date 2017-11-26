package gui.jan.vocabtrainer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController
{
    private Presenter presenter;

    @FXML
    private TextField translation;

    @FXML
    private Label vocable;

    @FXML
    private Label status;
    
    @FXML
    private Button check;
    
    @FXML
    private Button next;

    public ViewController()
    {
    }

    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

    public void handleCheck()
    {
        String vokabel = vocable.getText();
        String uebersetzung = translation.getText();
        vokabel = vokabel.trim();
        uebersetzung = uebersetzung.trim();
        presenter.abfragen(vokabel, uebersetzung);
    }
    
    public void handleNext()
    {
        vocable.setText(presenter.nextVocab());
        translation.setText("");
        status.setText("");
    }
    
    public void resetInput()
    {
        vocable.setText("");
        translation.setText("");
    }
    
    public void showOkayMessage()
    {
        status.setText("Richtig!");
    }

    public void showInputError()
    {
        status.setText("Falsch!");
    }

    public void showLoginError()
    {
        status.setText("Keine gültige Eingabe!");
    }
}
