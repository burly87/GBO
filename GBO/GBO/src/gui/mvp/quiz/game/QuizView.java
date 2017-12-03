package gui.mvp.quiz.game;

import java.util.List;

import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class QuizView
{
	private QuizPresenter presenter;
	private Label question1;
	private RadioButton radioButtons[];
	private RadioButton choiceTwo;
	private RadioButton choiceThree;
	private RadioButton choiceFour;
	private Button answer;
	private String loesung;
	private int amount;
	private GridPane pane;
	
	private ToggleGroup group;
	
	public QuizView(QuizPresenter quizPresenter)
	{
		this.presenter = quizPresenter;
	}
	
	public GridPane initView(ObservableList<String> list)
	{
		pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		
		question1 = new Label();

			
		question1.setId("question");
		
		answer = new Button("=>");
//		answer.setOnAction(e-> presenter.answer());
					
		pane.add(question1	,0,0);
		pane.add(answer		,0,5);
		
		radioButtons = new RadioButton[list.size()-1];
		for (int i = 0; i<4; i++)
		{
			radioButtons[i] = new RadioButton();
			radioButtons[i].setToggleGroup(group);
			pane.add(radioButtons[i],0,i+1);
		}
		return pane;
		
	}
	
	public void setPresenter(QuizPresenter presenter)
	{
		this.presenter = presenter;
	}

	public void setQuestion(ObservableList<String> list)
	{
		question1.setText(list.get(0));
		for (int i =0; i <radioButtons.length;i++)
		{
			radioButtons[i].setText(list.get(i+1));
		}
	}
	
}
