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

    // LinkedList Methoden gehen nicht??? addFirst(), addLast(), getFirst(),
    // getLast(), removeFirst(), removeLast()
    public static void main(String[] args)
    {
        /* zur direkten Laufzeitmessung */
        long start, end, time;

        /* zum Testen der Laufzeit */

        /* initialisierung Listen */

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

        /* ARRAYLIST STUFF */

        // Einf�gen am Anfang
        System.out.println("Gr��e ArrayList zu Beginn: " + observableArrayList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            arrayList.add(0, "Element ");

        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e ArrayList EINF�GEN ANFANG: " + observableArrayList.size());
        System.out.println("vergangene Zeit ArrayList: " + time);
        System.out.println("=======================");
        arrayList.clear();

        // Einf�gen am Ende
        System.out.println("Gr��e ArrayList zu Beginn: " + observableArrayList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            arrayList.add(arrayList.size(), "Element");
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e ArrayList EINF�GEN ENDE: " + observableArrayList.size());
        System.out.println("vergangene Zeit ArrayList: " + time);
        System.out.println("=======================");

        // L�schen erstes Element
        System.out.println("Gr��e ArrayList zu Beginn: " + observableArrayList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            arrayList.remove(0);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e ArrayList L�SCHEN ERTES: " + observableArrayList.size());
        System.out.println("vergangene Zeit ArrayList: " + time);
        System.out.println("=======================");

        // L�schen letztes Element

        for (int i = 0; i < 100000; i++)
        {
            arrayList.add(0, "Element ");
        }
        System.out.println("Gr��e ArrayList zu Beginn: " + observableArrayList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            arrayList.remove(arrayList.size() - 1);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e ArrayList L�SCHEN LETZTES: " + observableArrayList.size());
        System.out.println("vergangene Zeit ArrayList: " + time);
        System.out.println("=======================");

        // Zugreifen erstes Element
        for (int i = 0; i < 100000; i++)
        {
            arrayList.add(0, "Element ");
        }
        System.out.println("Gr��e ArrayList zu Beginn: " + observableArrayList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++)
        {
            arrayList.get(0);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("ZUGRIFF ERSTES");
        System.out.println("vergangene Zeit ArrayList: " + time);
        System.out.println("=======================");

        // Zugreifen letztes Element
        System.out.println("Gr��e ArrayList zu Beginn: " + observableArrayList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            arrayList.get(arrayList.size() - 1);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("ZUGRIFF LETZTES");
        System.out.println("vergangene Zeit ArrayList: " + time);
        System.out.println("=======================");

        // Zugreifen mittleres Element
        System.out.println("Gr��e ArrayList zu Beginn: " + observableArrayList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            arrayList.get(arrayList.size() / 2);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("ZUGRIFF MITTLERES");
        System.out.println("vergangene Zeit ArrayList: " + time);
        System.out.println("=======================");

        /* LINKEDLIST STUFF */
        System.out.println("=======================");
        System.out.println("LINKED LIST NOW");
        System.out.println("=======================");

        // Einf�gen Anfang
        System.out.println("Gr��e LinkedList zu Beginn: " + observableLinkedList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            linkedList.add(0, "Element ");
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e LinkedList EINF�GEN ANFANG: " + observableLinkedList.size());
        System.out.println("vergangene Zeit LinkedList: " + time);
        System.out.println("=======================");
        linkedList.clear();

        // Einf�gen Ende
        System.out.println("Gr��e LinkedList zu Beginn: " + observableLinkedList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            linkedList.add(linkedList.size(), "Element ");
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e LinkedList EINF�GEN ENDE: " + observableLinkedList.size());
        System.out.println("vergangene Zeit LinkedList: " + time);
        System.out.println("=======================");

        // L�schen erstes Element
        System.out.println("Gr��e LinkedList zu Beginn: " + observableLinkedList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            linkedList.remove(0);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e LinkedList L�SCHEN ERSTES: " + observableLinkedList.size());
        System.out.println("vergangene Zeit LinkedList: " + time);
        System.out.println("=======================");

        // L�schen letztes Element
        for (int i = 0; i < 100000; i++)
        {
            linkedList.add(0, "Element ");
        }
        System.out.println("Gr��e LinkedList zu Beginn: " + observableLinkedList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            linkedList.remove(linkedList.size() - 1);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Gr��e LinkedList L�SCHEN LETZTES: " + observableLinkedList.size());
        System.out.println("vergangene Zeit LinkedList: " + time);
        System.out.println("=======================");

        // Zugreifen erstes Element
        for (int i = 0; i < 100000; i++)
        {
            linkedList.add(0, "Element ");
        }
        System.out.println("Gr��e LinkedList zu Beginn: " + observableLinkedList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            linkedList.get(0);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("ZUGRIFF ERSTES");
        System.out.println("vergangene Zeit LinkedList: " + time);
        System.out.println("=======================");

        // Zugreifen letztes Element
        System.out.println("Gr��e LinkedList zu Beginn: " + observableLinkedList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            linkedList.get(linkedList.size() - 1);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("ZUGRIFF LETZTES");
        System.out.println("vergangene Zeit LinkedList: " + time);
        System.out.println("=======================");

        // Zugreifen mittleres Element
        System.out.println("Gr��e LinkedList zu Beginn: " + observableLinkedList.size());
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++)
        {
            linkedList.get(linkedList.size() / 2);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("ZUGRIFF MITTLERES");
        System.out.println("vergangene Zeit LinkedList: " + time);
        System.out.println("=======================");
        linkedList.clear();
        /* END: Testen der Laufzeit */
    }

}
