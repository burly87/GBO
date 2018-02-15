package SS15NEU;

import com.sun.javafx.webkit.drt.DumpRenderTree;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class View
{
	private GridPane root;
	private VBox labelBox;
	private Presenter presenter;
	
	private Label kennung, time, distance, durchschnitt;
	private Button add, delete;
	private ListView<String> list;
	private ObservableList<String> data;
	

	
	public View(Presenter presenter)
	{
		this.presenter = presenter;
		initView();
	}

	public Pane initView()
	{
		root = new GridPane();
		labelBox = new VBox();
		
		kennung = new Label();
		time = new Label();
		distance = new Label();
		durchschnitt = new Label();
		
		data = FXCollections.observableArrayList(getData());
		list = new ListView<>(data);
		
		labelBox.getChildren().addAll(kennung, time, distance, durchschnitt);
		root.add(list, 0, 0);
		root.add(labelBox, 0, 1);
		
		return root;
	}

	private String[] getData()
	{
		return presenter.getData();
	}

}
