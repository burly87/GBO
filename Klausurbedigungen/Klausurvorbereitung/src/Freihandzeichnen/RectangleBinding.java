package Freihandzeichnen;

import com.sun.javafx.geom.Curve;
import com.sun.javafx.geom.RectBounds;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleBinding extends Application
{

	private BorderPane root;
	private Rectangle rec;
	private Slider slider, sliderY, sliderMove;
	private HBox box;
	private Circle p1,p2,p3;
	private double xOrg, yOrg;
	
	
	@Override
	public void start(Stage stage) throws Exception
	{
		
		root = new BorderPane();
		box = new HBox();
		rec = new Rectangle(50,50,40,40);
		rec.setFill(Color.GREEN);
		//Rectangle
		slider = new Slider(-100, 100, 50);
		sliderY = new Slider(-120,200,0);
		sliderMove = new Slider(200,400, 100);
		
		rec.widthProperty().bind(slider.valueProperty());
		rec.heightProperty().bind(sliderY.valueProperty());
		rec.xProperty().bind(sliderMove.valueProperty());
		
		//Curve
		p1 = greateCircle(150, 300, 10, Color.BLUE);
		p2 = greateCircle(250, 22, 10, Color.RED);
		p3 = greateCircle(50, 60, 10, Color.AZURE);
		
		box.getChildren().addAll(slider, sliderY, sliderMove);
		root.getChildren().addAll(rec,box,p1,p2,p3);
		
		stage.setScene(new Scene(root, 500,500));
		stage.show();
		
	}
	
	private Circle greateCircle(double x, double y, double radius, Color color)
	{
		Circle c = new Circle(x,y,radius,color);
		c.setCursor(Cursor.HAND);
		
		c.setOnMousePressed(e -> {
			xOrg = e.getSceneX();
			yOrg = e.getSceneY();
			
			Circle c2 =(Circle) e.getSource();
			c2.toFront();
		});
		
		c.setOnMouseDragged(e->
		{
			Circle c2 = (Circle) e.getSource();
			c2.setCenterX(xOrg);
			c2.setCenterY(yOrg);
			
			xOrg = e.getSceneX();
			yOrg = e.getSceneY();
		});
		
		return c;
	}
	public static void main(String[] args)
	{
		launch(args);
	}

}
