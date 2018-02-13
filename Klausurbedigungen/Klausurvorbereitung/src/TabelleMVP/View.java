package TabelleMVP;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;

public class View
{

	private Presenter presenter;
	
	private Pane root;
	
	private TreeView<Animal> animal;
	private TreeItem<Animal> dackel;
	private TreeItem<String> test;
	
	public void setPresenter(Presenter presenter)
	{
		this.presenter = presenter;
	}


	public View(Presenter presenter)
	{
		this.presenter = presenter;
	}


	public Pane initView()
	{
		root = new Pane();
		
		animal = new TreeView<Animal>();
		dackel = new TreeItem<>();
		dackel.setExpanded(true);
		dackel.getChildren().addAll(
				new TreeItem<Animal>(presenter.getAnimal())
				);
		
		TreeView<Animal> dackelView = new TreeView<>(dackel);
		
		root.getChildren().add(dackelView);
		
		return root;
	}

}
