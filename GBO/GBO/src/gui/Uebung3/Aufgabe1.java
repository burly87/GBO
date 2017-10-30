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

        /* 1b) unidirektional eine Property ist von mehreren abhängig */
        prop1.bind(prop2);
        prop1.bind(prop3);
        prop1.bind(prop4);// */

        /* 1c) unidirektional eine Property gibt Änderung an mehrere weiter */
        prop1.bind(prop2);
        prop2.bind(prop2);
        prop3.bind(prop2);// */

        /* 1d) unidirekttion im Kreis gekoppelt */
        prop1.bind(prop2);
        prop2.bind(prop3);
        prop3.bind(prop4);
        prop4.bind(prop1);// */

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
        System.out.println("Änderung von prop1: ");
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
        System.out.println("Änderung von prop2: ");
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
        System.out.println("Änderung von prop3: ");
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
        System.out.println("Änderung von prop4: ");

        for (int i = 1; i <= 4; i++)
        {
            int newValue = (int) (Math.random() * 100) - 50;
            prop4.set(newValue);
            System.out.println("   " + prop1.get() + " / " + prop2.get() + " / " + prop3.get() + " / " + prop4.get());
        }
        /* END: PROP4 */
    }

    /* SO SOLLS NICHT GEMACHT WERDEN - funktioniert aber auch */
    /*
     * private static final int FACTOR = 1;
     * 
     * private IntegerProperty accountBalanceEuro;
     * 
     * private ReadOnlyIntegerWrapper accountBalanceDollar;
     * 
     * public Aufgabe1(int value) { accountBalanceEuro = new
     * SimpleIntegerProperty(value); accountBalanceDollar = new
     * ReadOnlyIntegerWrapper(value * FACTOR); }
     */

    /*
     * public int getAccountBalanceEuro() { return accountBalanceEuro.get(); }
     * 
     * public int getAccountBalanceDollar() { return accountBalanceDollar.get();
     * }
     * 
     * public void setAccountBalanceEuro(int newValue) {
     * accountBalanceEuro.set(newValue); accountBalanceDollar.set(newValue *
     * FACTOR); }
     * 
     * public IntegerProperty accountBalanceEuroProperty() { return
     * accountBalanceEuro; }
     * 
     * public ReadOnlyIntegerProperty accountBalanceDollarProperty() { return
     * accountBalanceDollar.getReadOnlyProperty(); }
     */
}
