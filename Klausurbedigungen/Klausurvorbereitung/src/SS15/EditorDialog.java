package SS15;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EditorDialog extends Stage
{
    private Presenter presenter;
    
    private TextField kennung;
    private TextField entfernung;
    private TextField zeit;
    private Label kennunglbl;
    private Label entflbl;
    private Label zeitlbl;
    private Label status;
    private Button hinzu;
    private Button cancel;
    private GridPane p;
    private GridPane text;
    private GridPane buttons;
    
    public EditorDialog()
    {
        
        p = new GridPane();
        
        initView();
        
        Scene scene = new Scene(p, 300, 180);
        setScene(scene);
        setTitle("Einheit hinzufügen");
        showAndWait();
        
    }
    
    public void initView()
    {
        text = new GridPane();
        buttons = new GridPane();
        
        kennunglbl = new Label("Kennung: ");
        entflbl = new Label("Entfernung: ");
        zeitlbl = new Label("Zeit: ");
        kennung = new TextField();
        entfernung = new TextField();
        zeit = new TextField();
        hinzu = new Button("Einheit hinzufügen");
        cancel = new Button("Abbrechen");
        status = new Label();
        
        cancel.setOnAction(e -> cancel());
        hinzu.setOnAction(e -> check());        
        
        p.add(text, 0, 0);
        p.add(buttons, 0, 1);
        p.add(status, 0, 2);
        text.add(kennunglbl, 0, 0);
        text.add(entflbl, 0, 1);
        text.add(zeitlbl, 0, 2);
        text.add(kennung, 1, 0);
        text.add(entfernung, 1, 1);
        text.add(zeit, 1, 2);
        buttons.add(hinzu, 0, 0);
        buttons.add(cancel, 1, 0);
        
        p.setPadding(new Insets(10, 10, 10, 10));
        p.setVgap(5);
        text.setVgap(5);
        buttons.setHgap(5);
    }
    
    public void check()
    {
        
    }
    
    public void cancel()
    {
        close();
    }

}
