package Date1502.ListView;

import java.util.Optional;

import Date1502.ListView.UndoRedo.HandleAdd;
import Date1502.ListView.UndoRedo.HandleDelete;
import Date1502.ListView.UndoRedo.HandleEdit;
import Date1502.ListView.UndoRedo.UndoRedoManager;
import javafx.collections.ObservableList;

public class Presenter
{
	private View view;
	private Model model;
	private boolean b = false;
	private UndoRedoManager urm;
	
	public Presenter()
	{
		this.urm = new UndoRedoManager();
	}

	public void setView(View view)
	{
		this.view = view;
	}

	public void setModel(Model model)
	{
		this.model = model;
	}

	public ObservableList<Country> getData()
	{
		return model.getData();
	}

	public void openDialog()
	{
		Country c = view.getItem();
		
		CountryEditDialog d = new CountryEditDialog(c, b);
		Optional<Country> result = d.showAndWait();
		result.ifPresent(country -> addCountry(country));
	}

	private void addCountry(Country country)
	{
		HandleAdd ha = new HandleAdd(model, country);
		urm.addAction(ha);		
		model.addCountry(country);
	}

	public void deleteCountry(Country country)
	{
		HandleDelete hd = new HandleDelete(model, country);
		urm.addAction(hd);
		model.deleteCountry(view.getItem());
	}

	public void openEditDialog()
	{
		Country c = view.getItem();
		b = true;
		
		CountryEditDialog d = new CountryEditDialog(c,b);
		Optional<Country> result = d.showAndWait();
		result.ifPresent(country ->editCountry(c,result.get()));
		
		b = false;
	}

	private void editCountry(Country old,Country newCountry)
	{
		HandleEdit he = new HandleEdit(model, newCountry, old);
		urm.addAction(he);
		model.editCountry(old, newCountry);
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
