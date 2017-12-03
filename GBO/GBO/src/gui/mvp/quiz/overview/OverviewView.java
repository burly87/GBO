package gui.mvp.quiz.overview;

import gui.mvp.quiz.model.Question;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class OverviewView 
{
	private OverviewPresenter presenter;
	private Label text;
	private TextField overview;
	private Button delete;
	private GridPane pane;
	
	public OverviewView(OverviewPresenter overviewPresenter)
	{
		this.presenter = overviewPresenter;
	}
	
	public GridPane initView(ObservableList<Question> observableList)
	{			
		text = new Label("Übersicht");
		
		overview = new TextField();
		overview.setPrefColumnCount(20);
		overview.setOnAction(e->presenter.result());
				
		delete = new Button("Ergebnisse löschen");
		delete.setOnAction(e->presenter.delete());
		
		pane.getChildren().addAll(text, overview, delete);
		
		return pane;
		
	}
	
//	public void setPresenter(OverviewPresenter presenter)
//	{
//		this.presenter = presenter;
//	}

	public void delete()
	{
		presenter.delete();
	}
	
}
