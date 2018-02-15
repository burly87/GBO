package Date1502.ListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model
{
	
	private ObservableList<Country> list;
	
	public Model()
	{
		list = FXCollections.observableArrayList();
		list.add(new Country("Deutschland", 12312312, 20000));
		list.add(new Country("Italien", 123123123, 91991));
		list.add(new Country("Frankreich", 2266263, 123123));
	}

	public ObservableList<Country> getData()
	{
		return  list;
	}


}
