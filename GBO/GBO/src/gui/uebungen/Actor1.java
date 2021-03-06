package gui.uebungen;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Actor1 extends Application
{

    private Role1 role;

    private static int counter = 0;

    private static ArrayList<Role1> addRole = new ArrayList<Role1>();

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
        // counter++;
        addRole.add(role1);
        // System.out.println(addRole.toString());
    }

    public static void clearRole()
    {
        addRole.clear();
        // System.out.println("clear wurde ausgeführt");
    }

    public static void main(String[] args)
    {
        Actor1 actor = new Actor1();
        actor.action();
        actor.addRole(new Hallo());
        actor.action();
        actor.addRole(new ByeRole());
        actor.action();
        actor.addRole(new Hallo());
        actor.action();
        actor.addRole(new GeneralRole("I'll be back!"));
        actor.action();

        System.out.println("Anzahl an Rollen in ArrayList: " + counter);
        clearRole();
        System.out.println("Arraylist nach CLEAR:" + addRole.toString());

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
