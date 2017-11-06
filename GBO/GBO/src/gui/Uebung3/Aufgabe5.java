package gui.Uebung3;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/*  Aufgabe: Programmieren Sie ein Beispiel, in dem Sie ausführlich die Informationen darstellen, die
    Ihnen ein Objekt der Klasse ListChangeListener.Change liefert! 
    Durchlaufen Sie in Ihrem ChangeListener das Change-Objekt in einer While-Schleife, wie es in der Vorlesung gezeigt wurde,
    und geben Sie bei jedem Schleifendurchlauf die meisten auszulesenden Informationen aus! Sie
    können auf die Nutzung der Methode getPermutation verzichten! Ändern Sie nun Ihre Liste auf
    unterschiedliche Arten! Wenden Sie u.a. auch die Methoden sort und reverse auf Ihre Liste an! Sie
    benötigen kein Beispiel, in dem die Methode wasUpdated true zurückliefert. Sie können aber auf
    freiwilliger Basis herausfinden, was Sie tun müssen, damit bei der Änderung eines Elements der Liste
    die ChangeListener benachrichtigt werden, wobei wasUpdated true liefert.
*/

public class Aufgabe5
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("d");
        list.add("b");
        list.add("a");
        list.add("c");

        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener<String>()
        {
            public void onChanged(ListChangeListener.Change<? extends String> change)
            {
                System.out.println("Change:");
                while (change.next())
                {
                    System.out.println("   added? " + change.wasAdded());
                    System.out.println("   removed? " + change.wasRemoved());
                    System.out.println("   replaced? " + change.wasReplaced());
                    System.out.println("   permutated? " + change.wasPermutated());
                    System.out.println("   update? " + change.wasUpdated());
                }
            }
        });
        System.out.println("List zu Beginn:");
        System.out.println(list);
        System.out.println("===========");
        FXCollections.sort(observableList);
        System.out.println(list);
        System.out.println("===========");
        FXCollections.reverse(observableList);
        System.out.println(list);
        System.out.println("===========");
        FXCollections.sort(observableList);
        System.out.println(list);
    }

}
