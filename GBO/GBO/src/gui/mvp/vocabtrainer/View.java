package gui.mvp.vocabtrainer;

import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class View
{	
	private GridPane pane;
	
	private Presenter presenter;
	
	private Button next;
	private Button check;
	private TextField eingabe;
	private Label topic;
	private Label word;
	private Label answer;
	
	private Label counterLabel;
	int countCorrect = 0;

	public View(Presenter presenter)
	{
		this.presenter = presenter;
	}

    public void initView()
    {	
    	//initialize
        pane = new GridPane();
        next = new Button("Weiter");
        check = new Button("Überprüfen");
        eingabe = new TextField();
        topic = new Label("Bitte ubersetzten Sie:");
        counterLabel = new Label("Korrekte Antworten: " + countCorrect);
        
        word = new Label(); // Muss noch word aus Hashmap rein
        answer = new Label();
        
        //zeichnen
        pane.add(topic, 0, 0);
        pane.add(word, 0, 1);
        pane.add(eingabe,1,1);
        pane.add(check, 0, 2);
        pane.add(next, 1, 2);
        pane.add(answer, 0, 3, 2, 1);
        pane.add(counterLabel, 0, 4);
       
        //IDs
        word.setId("vocable");
        eingabe.setId("translation");
        next.setId("next");
        check.setId("check");
        answer.setId("status");
        
        //Eventhandle
        EventHandler<ActionEvent> h = e-> handle();
        eingabe.setOnAction(h);
        check.setOnAction(h);
       
    }
    
    private void handle()
    {
    	String gerWord = word.getText();
    	String engWord = eingabe.getText();
    	presenter.translate(gerWord, engWord);
    }
    
    public Pane getUI()
    {
        return pane;
    }

    public void showInputRight()
    {
    	countCorrect++;
        answer.setText("Die Lösung war richtig.");
    }
    

    public void showInputWrong()
    {
    	answer.setText("Die Lösung war falsch. Sie können es nochmals versuchen.");
    }

    
  
}
