package gui.uebungen;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Actor1 extends Application
{

    private Role1 role;

    public void action()
    {
        if (role != null)
        {
            role.play();
        }
    }

    /*
     * public void setOnAction(Role1 role1) { this.role = role1; }
     */

    public void addRole(Role1 role1)
    {
        ArrayList<Role1> roleFICKDICH = new ArrayList<Role1>();
        roleFICKDICH.add(role1);
        roleFICKDICH.add(new ByeRole());
        // roleFICKDICH.add(new GeneralRole("bla"));
        System.out.println(roleFICKDICH.toString());
    }

    public void clearRole()
    {

    }

    public static void main(String[] args)
    {
        Actor1 actor = new Actor1();
        actor.action();

        actor.addRole(new Hallo());
        actor.action();
        actor.addRole(new ByeRole());
        actor.action();
        actor.addRole(new GeneralRole("Das ist ein test"));
        actor.action();

        // launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Button actor = new Button();
        GridPane root = new GridPane();

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Actor");
        primaryStage.show();
    }
}
