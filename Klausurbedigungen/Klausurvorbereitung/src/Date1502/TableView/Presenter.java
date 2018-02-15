package Date1502.TableView;

import java.util.Optional;

import Date1502.TableView.ExtraDialogs.AddDialog;
import Date1502.TableView.ExtraDialogs.AnimalAddHandle;
import Date1502.TableView.ExtraDialogs.AnimalDeleteHandle;
import Date1502.TableView.ExtraDialogs.UndoRedoManager;
import javafx.collections.ObservableList;

public class Presenter
{
	private Model model;
	private View view;
	private AddDialog addDialog;
	private Animal animal;
	private UndoRedoManager urm;
	
	public Presenter()
	{
		this.urm = new UndoRedoManager();
	}
	
	public Model getModel()
	{
		return model;
	}
	public void setModel(Model model)
	{
		this.model = model;
	}
	public View getView()
	{
		return view;
	}
	public void setView(View view)
	{
		this.view = view;
	}

	public ObservableList<Animal> getData()
	{
		return model.getData();
	}

	public void showDialog()
	{
		AddDialog ad= new AddDialog();
		Optional<Animal> r = ad.showAndWait();
		r.ifPresent(animal-> addAnimal(animal));
	}

	private void addAnimal(Animal animal)
	{
		AnimalAddHandle aah = new AnimalAddHandle(model, animal, view);
		urm.addAction(aah);
		view.addAnimal(animal);
		model.addAnimal(animal);
		view.upDateList(model.getData());
	}

	public void delete(Animal selectedItem)
	{
		AnimalDeleteHandle adh = new AnimalDeleteHandle(model, selectedItem, view);
		urm.addAction(adh);
		model.delete(selectedItem);
		view.deleteAnimal(selectedItem);
		view.upDateList(model.getData());
	}

	public void redo()
	{
		urm.redo();
	}

	public void undo()
	{
		urm.undo();
	}



}
