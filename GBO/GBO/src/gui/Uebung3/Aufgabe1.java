package gui.Uebung3;

import javafx.beans.property.SimpleIntegerProperty;

/* Simple Properties */
public class Aufgabe1
{

    public static void main(String[] args)
    {
        SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop3 = new SimpleIntegerProperty();
        SimpleIntegerProperty prop4 = new SimpleIntegerProperty();

        /* 1a) unidirektional vier in Reihe gekoppelt */
        prop1.bind(prop2);
        prop2.bind(prop3);
        prop3.bind(prop4);// */

        /* 1b) unidirektional eine Property ist von mehreren abh�ngig */
        prop1.bind(prop2);
        prop1.bind(prop3);
        prop1.bind(prop4);// eigentlich unn�tig, da nur noch prop1.bind(prop4)
                          // am ende existiert */

        /* 1c) unidirektional eine Property gibt �nderung an mehrere weiter */
        prop1.bind(prop2);
        prop2.bind(prop2);
        prop3.bind(prop2);// */

        /* 1d) unidirekttion im Kreis gekoppelt */
        prop1.bind(prop2);
        prop2.bind(prop3);
        prop3.bind(prop4);
        prop4.bind(prop1);// StackOverflow, da kein set mehr m�glich ist*/

        /* 1e) bidirektional vier in Reihe gekoppelt */
        prop1.bindBidirectional(prop2);
        prop2.bindBidirectional(prop3);
        prop3.bindBidirectional(prop4);// */

        /* 1f) bidirekttion im Kreis gekoppelt */
        prop1.bindBidirectional(prop2);
        prop2.bindBidirectional(prop3);
        prop3.bindBidirectional(prop4);
        prop4.bindBidirectional(prop1);// */

        /* PROP1 */
        System.out.println("�nderung von prop1: ");
        try
        {
            for (int i = 1; i <= 4; i++)
            {
                int newValue = (int) (Math.random() * 100) - 50;

                prop1.set(newValue);
                System.out.println("   " + prop1.get() + " / " + prop2.get() + " / " + prop3.get() + " / " + prop4.get());
            }
        }
        catch (Exception e)
        {
            System.out.println(" scheint nicht zu funktionieren \n");
        }
        /* END: PROP1 */

        /* PROP2 */
        System.out.println("�nderung von prop2: ");
        try
        {
            for (int i = 1; i <= 4; i++)
            {
                int newValue = (int) (Math.random() * 100) - 50;

                prop2.set(newValue);
                System.out.println("   " + prop1.get() + " / " + prop2.get() + " / " + prop3.get() + " / " + prop4.get());
            }
        }
        catch (Exception e)
        {
            System.out.println(" scheint nicht zu funktionieren \n");
        }
        /* END: PROP2 */

        /* PROP3 */
        System.out.println("�nderung von prop3: ");
        try
        {
            for (int i = 1; i <= 4; i++)
            {
                int newValue = (int) (Math.random() * 100) - 50;

                prop3.set(newValue);
                System.out.println("   " + prop1.get() + " / " + prop2.get() + " / " + prop3.get() + " / " + prop4.get());
            }
        }
        catch (Exception e)
        {
            System.out.println(" scheint nicht zu funktionieren \n");
        }
        /* END: PROP3 */

        /* PROP4 */
        System.out.println("�nderung von prop4: ");

        for (int i = 1; i <= 4; i++)
        {
            int newValue = (int) (Math.random() * 100) - 50;
            prop4.set(newValue);
            System.out.println("   " + prop1.get() + " / " + prop2.get() + " / " + prop3.get() + " / " + prop4.get());
        }
        /* END: PROP4 */
    }

}
