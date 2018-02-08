package TabelViewPlayer;

import javafx.collections.ObservableList;

public class Presenter {

	private Model model;
	private View view;
	private EditView editView;
	private EditorView editorView;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public ObservableList<Player> getPlayerList() {
		return model.getPlayerList();
	}

	public void delete(Player selectedItem) {
		model.delete(selectedItem);
		view.resetView();

	}

	public void setEditView(EditView ev) {
		this.editView = ev;

	}

	public void addNewPlayer(Player p) {
		model.addNewPlayer(p);
	}

	public void showEditDialog() {
		EditView ev = new EditView();
		ev.setPresenter(this);
		ev.showAndWait();	
	}

	public void showEditorView(Player p) {
		EditorView ev = new EditorView(p);
		ev.setPresenter(this);
		ev.showAndWait();
		
	}
	public void showEditorDialog()
	{
		Player p = view.getItem();
		showEditorView(p);
	}

	public void edit(Player old, Player n)
	{
		model.edit(old,n);
	}

	

}
