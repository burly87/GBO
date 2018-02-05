package TabelViewPlayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
	private ObservableList<Player> list;

	public Model()
	{
		list = FXCollections.observableArrayList();
		list.add(new Player("Tobias","Forve","Abwehr",200));
		list.add(new Player("Test","Fall","Abwehr",300));
	}

	public ObservableList<Player> getPlayerList()
	{
		return list;
	}

}
