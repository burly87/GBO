package gui.mvp.quiz.main;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

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
	
}
