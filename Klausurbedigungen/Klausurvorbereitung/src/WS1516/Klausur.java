package WS1516;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*	Klausur bestand aus 3 Teilen;
 * Die Klassen Item und Model waren bereits gegeben (MVP)
 * a)
 * Methoden im Model (getter/setter) mussten gr��tenteils,
 * gef�llt werden, Konstruktor war vorgegeben mit �berpr�fung, 
 * ob itemWeigths und itemNames gleich lang sind usw.
 * 
 * b) 
 * View initialisieren mit vorgegebenen Methoden und �bergabe-Parametern
 * Checkboxes mit funktionalit�t implementieren
 * Main Klasse (hier Klausur) mit Beispielen bef�llen und Stage erstellen
 *  
 * c)
 * Statusleiste (Visualisierung des F�llstatus) implementieren
 * (hier: updateTotal()).
 * 
 * Diese Implementierung ist nicht 100%ig Klausurnahe, da nicht alle
 * �bergabeparameter/Methoden im View mit der Aufgabenstellung �berein-
 * stimmen. Aufgabenstellung sollte aber dadurch relativ klar sein ;)
 *
 * Good luck and have fun!
 * @adamkev
 */

public class Klausur extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setScene(new Scene(initScene()));
        primaryStage.setTitle("Rucksack");
        primaryStage.show();
    }

    private Parent initScene()
    {
        String[] names =
        { "Eier", "Kuchen", "Bacon", "Bananen", "Wassermelone", "Fisch", "Gefl�gel" };
        double[] weights =
        { 0.5, 1.2, 3.4, 1.75, 4.8, 2.1, 0.75 };
        double maxWeight = 7.5;

        View v = new View();
        Model m = new Model(names, weights, maxWeight);

        Presenter p = new Presenter();

        v.setPresenter(p);
        p.setModel(m);
        p.setView(v);

        p.startView();

        return v;
    }
}
