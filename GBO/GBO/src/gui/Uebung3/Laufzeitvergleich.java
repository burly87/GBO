package gui.Uebung3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

//UEBUNG 3 Aufgabe 4
public class Laufzeitvergleich
{
    // ArrayListe dauert vorallem beim l�schen & einf�gen an list[0] lange, da
    // alle nachfolgenden list[n-1] verschoben werden m�ssen
    // LinkedList kann ich Zeiger "umbiegen", geht immer gleich schnell, egal wo
    // man l�scht bzw. einf�gt

    // Arraylist get.list[n] geht immer gleich schnell. Daher sehr schnell
    // LinkdList muss bei get komplett durchlaufen, bis zur [n]-gesuchten
    // Stelle. Daher langsamer

    public static void main(String[] args)
    {
        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();

        ObservableList<String> observableArrayList = FXCollections.observableList(arrayList);
        ObservableList<String> observableLinkedList = FXCollections.observableList(linkedList);

        /* hinzuf�gen Listener */
        observableArrayList.addListener(new ListChangeListener<String>()
        {
            public void onChanged(ListChangeListener.Change<? extends String> change)
            {
                System.out.println("ArrayListe wurde ge�ndert");
            }
        });

        observableLinkedList.addListener(new ListChangeListener<String>()
        {
            public void onChanged(ListChangeListener.Change<? extends String> change)
            {
                System.out.println("LinkedListe wurde ge�ndert");
            }
        });
        /* END: hinzuf�gen Listener */

        /* zur direkten Laufzeitmessung */
        long start, end, time;

        /* Testen der Laufzeit */
        int helpArray = 0;
        int inArray = 0;

        int inLinked = 0;
        int helpLinked = 0;
        /* ARRAYLIST STUFF */
        System.out.println("Gr��e ArrayList zu Beginn: " + observableArrayList.size());
        start = System.currentTimeMillis();
        while (helpArray <= 10000)
        {
            arrayList.add(0, "Element" + inArray);
            ++inArray;
            helpArray++;

        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e ArrayList nach �nderung: " + observableArrayList.size());
        System.out.println("vergangene Zeit ArraydList: " + time);
        System.out.println("=======================");

        /* LINKEDLIST STUFF */
        System.out.println("Gr��e LinkedList zu Beginn: " + observableLinkedList.size());
        start = System.currentTimeMillis();
        while (helpLinked <= 10000)
        {
            linkedList.add(0, "Element" + inLinked);
            ++inLinked;
            helpLinked++;
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e LinkedList nach �nderung: " + observableLinkedList.size());
        System.out.println("vergangene Zeit LinkedList: " + time);
        /* END: Testen der Laufzeit */
    }

}
