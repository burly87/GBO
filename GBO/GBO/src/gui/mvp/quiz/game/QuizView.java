package gui.mvp.quiz.game;

import gui.mvp.quiz.model.Model;
import gui.mvp.quiz.model.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class QuizView extends GridPane
{
	private QuizPresenter presenter;
	private Label question1;
	private RadioButton choiceOne;
	private RadioButton choiceTwo;
	private RadioButton choiceThree;
	private RadioButton choiceFour;
	private Button answer;
	private String loesung;
	private int amount;
	
	private ToggleGroup group;
	
	public QuizView()
	{
		initView();
	}
	
	private void initView()
	{
		setHgap(10);
		setVgap(10);
		
		question1 = new Label();
		choiceOne = new RadioButton();
		choiceTwo = new RadioButton();
		choiceThree = new RadioButton();
		choiceFour = new RadioButton();
		
		choiceOne.setToggleGroup(group);
		choiceTwo.setToggleGroup(group);
		choiceThree.setToggleGroup(group);
		choiceFour.setToggleGroup(group);
		
		question1.setId("question");
		
		answer = new Button("=>");
		answer.setOnAction(e-> presenter.answer());
						
		add(question1	,0,0);
		add(choiceOne	,1,0);
		add(choiceTwo	,2,0);
		add(choiceThree	,3,0);
		add(choiceFour	,4,0);
		add(answer		,5,0);
	}
	
	public void setPresenter(QuizPresenter presenter)
	{
		this.presenter = presenter;
	}
	
	public Question getQuestion()
	{
		return new Question
		(
			question1.getText(),
			choiceOne.getText(), 
			choiceTwo.getText(),
			choiceThree.getText(),
			choiceFour.getText()
	
		);
	}
	
	public void showQuestion(Question question)
	{
		if(question != null)
		{
			question1.setText(question.getQuestion());
			choiceOne.setText(question.getAnswer());
			choiceTwo.setText(question.getAnswer());
			choiceThree.setText(question.getAnswer());
			choiceFour.setText(question.getAnswer());
					
		}
		else
		{
			question1.setText("");
			choiceOne.setText("");
			choiceTwo.setText("");
			choiceThree.setText("");
			choiceFour.setText("");
		}
		
	
	}
}
