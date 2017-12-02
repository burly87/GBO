package gui.mvp.quiz.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Question
{
	private List<SimpleStringProperty> answer = new ArrayList<SimpleStringProperty>();
	private SimpleStringProperty question;
	private SimpleStringProperty answerOne;
	private SimpleStringProperty answerTwo;
	private SimpleStringProperty answerThree;
	private SimpleStringProperty answerFour;
	
	private SimpleStringProperty loesung;
	private SimpleIntegerProperty amount;
	private SimpleIntegerProperty correct;
	
	public Question(List<String> answer, String question, String loesung) 
	{
		this.question = new SimpleStringProperty(question);
		this.loesung = new SimpleStringProperty(loesung);
		this.amount = new SimpleIntegerProperty(0);
		this.correct = new SimpleIntegerProperty(0);
		
		for (String i: answer)
		{
			this.answer.add(new SimpleStringProperty(i));
		}
		
	}

	public Question(String question, String one, String two,String three, String four, String loesung) 
	{
		this.question = new SimpleStringProperty(question);
		this.answerOne = new SimpleStringProperty(one);
		this.answerTwo = new SimpleStringProperty(two);
		this.answerThree = new SimpleStringProperty(three);
		this.answerFour = new SimpleStringProperty(four);
		this.loesung = new SimpleStringProperty(loesung);
		
		answer.add(answerOne);
		answer.add(answerTwo);
		answer.add(answerThree);
		answer.add(answerFour);
		
	
	}

    public String getAnswer()
    {
        return loesung.get();
    }

	public void setAnswer(List<SimpleStringProperty> answer) 
	{
		this.answer = answer;		
	}
	
	public String getQuestion() 
	{
		return question.get();
	}

	public String getLoesung() 
	{
		return loesung.get();
	}
	
	
	/*Statistik*/
	public int getAmount() 
	{
		return amount.get();
	}
	
	public void setAmount(int amount)
	{
		this.amount = new SimpleIntegerProperty(amount);
	}
	
	public int getCorrect() 
	{
		return correct.get();
	}
	
	public void setCorrect(int correct)
	{
	    this.correct = new SimpleIntegerProperty(correct);
	}
	
	/*Statistik ändern*/
	public void incAmount() //amount erhöhen
	{
		this.amount.set(amount.get()+1);
	}
	
	public void incCorrect() //correct erhöhen
	{
		this.correct.set(correct.get()+1);
	}
	
	public void clear() // nullen
	{
		this.amount = new SimpleIntegerProperty(0);
		this.correct = new SimpleIntegerProperty(0);
	}
	
	
	

	



}
