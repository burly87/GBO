package Freihandzeichnen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class DrawingPaths extends Application
{

	private BorderPane root;
	private Path path;
	
	@Override
	public void start(Stage stage) throws Exception
	{
		root = new BorderPane();
		
		root.setOnMousePressed(e-> mousePressed(e.getX(),e.getY()));
		root.setOnMouseDragged(e -> mouseDragged(e.getX(),e.getY()));
		root.setOnMouseReleased(e-> mouseReleased());
		
		
		stage.setTitle("Freihandzeichnen");
		stage.setScene(new Scene(root,500,500));
		stage.show();
	}

	private void mouseReleased()
	{
		path = null;
	}

	private void mouseDragged(double x, double y)
	{
		path.getElements().add(new LineTo(x,y));
	}

	private void mousePressed(double x, double y)
	{
		path = new Path();
		path.setStroke(Color.BLUE);
		path.setStrokeWidth(4);
		path.getElements().add(new MoveTo(x,y));
		root.getChildren().add(path);
	}

	public static void main(String[] args)
	{
		launch(args);
	}
	
}
