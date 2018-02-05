package LoginBeispiel;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class View 
{
	private Presenter p;
	private GridPane pane;
	private TextField loginName;
	private PasswordField passWord;
	private Label status;
	private Button loginBtn;
	
	public View(Presenter presenter)
	{
		this.p = presenter;
	}
	
	public GridPane initView() 
	{
		pane = new GridPane();
		loginName = new TextField();
		passWord = new PasswordField();
		status = new Label();
		loginBtn = new Button("Login");
		
		pane.add(new Label("LoginName: "), 0, 0);
		pane.add(loginName, 1, 0);
		pane.add(new Label("Password: "), 0, 1);
		pane.add(passWord, 1, 1);
		pane.add(loginBtn, 0, 2);
		pane.add(status, 0, 3,2,1);
		
		loginBtn.setOnAction(e -> login());
		
		return pane;
	}

	private void login() 
	{
		String name = loginName.getText();
		String pw = passWord.getText();
		
		p.login(name,pw);
	}

	public void reset() {
		loginName.setText("");
		passWord.setText("");
	}

	public void showWrongPW() {
		status.setText("PW or Name falsch eingegeben");
	}

	public void showErrorEmpty() {
		status.setText("leere Eingabe");
	}

	public void showLoginCorrect() {
		status.setText("login erfolgreich");
	}

}
