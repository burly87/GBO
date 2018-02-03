package Klausurvorbereitung.loginBsp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class View
{
    private Presenter presenter;

    private GridPane pane;

    private TextField loginName;

    private PasswordField pw;

    private Label status;

    private Button btnLogin;

    public View(Presenter p)
    {
        this.presenter = p;
    }

    public void initView()
    {
        pane = new GridPane();
        loginName = new TextField();
        pw = new PasswordField();
        btnLogin = new Button("Login");
        status = new Label();

        pane.add(new Label("Login Name: "), 0, 0);
        pane.add(loginName, 1, 0);
        pane.add(new Label("Password: "), 0, 1);
        pane.add(pw, 1, 1);
        pane.add(btnLogin, 0, 2);
        pane.add(status, 0, 3, 2, 1);

        EventHandler<ActionEvent> h = e -> handle();
        // loginName.setOnAction(h);
        btnLogin.setOnAction(h);

    }

    private void handle()
    {
        String name = loginName.getText();
        String password = pw.getText();
        name = name.trim(); // no whitspaces
        password = password.trim();
        presenter.login(name, password);
    }

    public void reset()
    {
        loginName.setText("");
        pw.setText("");
    }

    public Pane getView()
    {
        return pane;
    }

    public void showOkMsg()
    {
        status.setText("Login erfolgreich");
    }

    public void showErrorLogin()
    {
        status.setText("Loginname oder Password falsch");
    }

    public void showEmptyError()
    {
        status.setText("Sie muessen etwas eintragen");
    }
}
