package TabelViewPlayer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditorView extends Stage
{
	private Presenter presenter;

	private Button edit;
	private VBox pane;
	private TextField vorName, nachName, pos, games;
	private Player old;
	
	public void setPresenter(Presenter presenter)
	{
		this.presenter = presenter;
	}
	
	public EditorView(Player p)
	{
		pane = new VBox();
		edit = new Button("Editieren");
		vorName = new TextField();
		nachName = new TextField();
		pos = new TextField();
		games = new TextField();
		
		old = p;
		
		vorName.setText(p.getVorName());
		nachName.setText(p.getNachName());
		pos.setText(p.getPosition());
		games.setText(Integer.toString(p.getGames()));
		
		edit.setOnAction(e -> editPlayer());
		
		
		pane.getChildren().addAll(vorName,nachName,pos,games,edit);
		
		this.setScene(new Scene(pane,400,300));
		
	}

	private void editPlayer()
	{
		Player n = new Player(vorName.getText(),nachName.getText(),pos.getText(),Integer.parseInt(games.getText()));
		presenter.edit(old, n);
		this.close();
	}
	
	
	
	

}
