package SS15;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class View extends GridPane
{
    private Presenter presenter;
    
    private Label kennung;
    private Label entfernung;
    private Label zeit;
    private Label durchschnitt;
    private Button hinzu;
    private Button delete;
    private ListView<String> list;
    private ObservableList<String> data;
    private GridPane oben, unten, text;
    
    public View()
    {
        initView();
    }
    
    public void setPresenter(Presenter p)
    {
        this.presenter = p;
    }
    
    public void initView()
    {        
        oben = new GridPane();
        unten = new GridPane();
        text = new GridPane();
        
        kennung = new Label();
        entfernung = new Label();
        zeit = new Label();
        durchschnitt = new Label();
        hinzu = new Button("Trainingseinheit hinzufügen");
        delete = new Button("Einheit löschen");
        
        data = FXCollections.observableArrayList();
        list = new ListView<>(data);
        
        list.getSelectionModel().selectedItemProperty().addListener((ov, oldValue, newValue) -> elementeAnzeigen(newValue));
        delete.setOnAction(e -> deleteElement());
        hinzu.setOnAction(e -> elementHinzu());
        
        add(oben, 0, 0);
        add(unten, 0, 1);
        oben.add(text, 1, 0);
        text.add(kennung, 0, 0);
        text.add(entfernung, 0, 1);
        text.add(zeit, 0, 2);
        text.add(durchschnitt, 0, 3);
        unten.add(hinzu, 0, 0);
        unten.add(delete, 1, 0);
        oben.add(list, 0, 0);
        
        setPadding(new Insets(20, 20, 20, 20));
        unten.setHgap(5);
        setVgap(5);
        oben.setHgap(5);
    }

    public void listeSetzen()
    {
        data.clear();
        data.addAll(presenter.getKennungen());        
    }
    
    private void elementeAnzeigen(String newValue)
    {
        
        if(newValue != null)
        {
            TrainingUnit t = presenter.getUnit(newValue);
            kennung.setText("Kennung: " + t.getKennung());
            entfernung.setText("Entfernung [km]: " + t.getEntfernung());
            zeit.setText("Zeit [min]: " + t.getZeit());
            durchschnitt.setText("Durchschnitt [km/h]: " + t.getDurchschnitt());
        }
        else
        {
            kennung.setText("Kennung: ");
            entfernung.setText("Entfernung [km]: ");
            zeit.setText("Zeit [min]: ");
            durchschnitt.setText("Durchschnitt [km/h]: ");
        }
    }
    
    public void deleteElement()
    {
        if(list.getSelectionModel().getSelectedItem() != null)
        {
            String s = list.getSelectionModel().getSelectedItem();
            presenter.delete(s);
            listeSetzen();
            int anzahl = data.size();
            if(anzahl > 0)
            {
                list.getSelectionModel().select(0);
            }
        }
    }
    
    public void elementHinzu()
    {
        EditorDialog d = new EditorDialog();
    }

}
