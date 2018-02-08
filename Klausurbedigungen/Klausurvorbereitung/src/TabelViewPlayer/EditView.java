package TabelViewPlayer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditView extends Stage {

	private Presenter presenter;

	private VBox vbox;
	private TextField vorName, nachName, pos, games;
	private Button add;

	public void setPresenter(Presenter p) {
		this.presenter = p;
	}

	public EditView() {
		vbox = new VBox();
		add = new Button("Hinzufuegen");
		add.setOnAction(e -> add());

		vorName = new TextField();
		nachName = new TextField();
		pos = new TextField();
		games = new TextField();

		vorName.setPromptText("Vorname");
		nachName.setPromptText("Nachname");
		pos.setPromptText("Position");
		games.setPromptText("Anzahl Spiele");

		vbox.getChildren().addAll(vorName, nachName, pos, games, add);

		this.setScene(new Scene(vbox));
	}

	private void add() {
		presenter.addNewPlayer(generateNewPlayer());
		this.close();
	}

	public Player generateNewPlayer() {
		Player p=null;
		
			try 
			{
				String strVName = vorName.getText();
				String strNName = nachName.getText();
				String strPos = pos.getText();
				int intGames = Integer.parseInt(games.getText());
				p = new Player(strVName, strNName, strPos, intGames);
			}		
			catch(NumberFormatException e) 
			{
				System.out.println("Leere eingabe");
			}
		return p;
	}

}
