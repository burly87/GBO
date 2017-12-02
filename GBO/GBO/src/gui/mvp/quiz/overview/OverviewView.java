package gui.mvp.quiz.overview;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class OverviewView extends VBox
{
	private OverviewPresenter presenter;
	private Label text;
	private TextArea overview;
	private Button delete;
	
	public OverviewView()
	{
		initView();
	}
	
	private void initView()
	{
		setSpacing(10);
		
		text = new Label("Übersicht");
		overview = new TextArea();
		delete = new Button("Ergebnisse löschen");
		
		overview.setText(value);
		
		getChildren().addAll(text, overview, delete);
		
	}
	
	public void setPresenter(OverviewPresenter presenter)
	{
		this.presenter = presenter;
	}

	public void delete()
	{
		presenter.delete();
	}
	
}
