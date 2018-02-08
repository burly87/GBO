package TabelViewPlayer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
	private ObservableList<Player> list;

	public Model()
	{
		list = FXCollections.observableArrayList();
		list.add(new Player("Tobias", "Forve", "Abwehr", 200));
		list.add(new Player("Test", "Fall", "Abwehr", 300));
	}

	public ObservableList<Player> getPlayerList()
	{
		return list;
	}

	public void delete(Player selectedItem)
	{
		list.remove(selectedItem);

	}

	public void addNewPlayer(Player p)
	{
		if (p == null)
		{
			System.out.println("so nicht mein freund");
		} else
			list.add(p);
	}

	public void edit(Player old, Player n)
	{
		int i = list.indexOf(old);
		list.remove(i);
		list.add(i,n);
	}

}
