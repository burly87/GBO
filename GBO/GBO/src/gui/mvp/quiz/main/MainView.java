package gui.mvp.quiz.main;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MainView extends BorderPane
{

	public MainView()
	{
		initView();
	}

	private void initView()
	{
		HBox topArea = new HBox(5);
	
		Button start = new Button("Quiz starten!");
		Button weiter = new Button("Quiz fortsetzen!");
		Button overview  = new Button("Ueberblick!");
		
		overview.setId("overview");
		
		topArea.getChildren().addAll(start, weiter, overview);
		setTop(topArea);
	}
	
	public void setContent(Pane content)
	{
		setCenter(content);
		setMargin(content, new Insets(20,20,20,20));
	}
	
}
