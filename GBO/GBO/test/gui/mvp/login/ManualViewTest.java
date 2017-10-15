package gui.mvp.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ManualViewTest extends Application
{
    public void start(Stage primaryStage)
    {
        MockPresenter p = new MockPresenter();
        View v = new View(p);
        v.initView();
        
        TestView testView = new TestView(v);
        p.setOutput(testView.getOutput());
        
        HBox box = new HBox(20);
        box.getChildren().addAll(v.getUI(), testView.getPane());

        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Test");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
