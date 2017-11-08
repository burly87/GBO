package gui.Uebung3;

import javafx.beans.property.SimpleIntegerProperty;

public class UnidirectionalProperties
{

    /* 1a) unidirektional vier in Reihe gekoppelt */
    public static void aufgabeA()
    {
        try
        {
            SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop3 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop4 = new SimpleIntegerProperty();
            prop1.bind(prop2);
            prop2.bind(prop3);
            prop3.bind(prop4);
            prop4.set(5);
            System.out.println(prop1.get());

        }
        catch (Exception e)
        {
            System.out.println("Funktioniert nicht");
        }

    }

    /* 1b) unidirektional eine Property ist von mehreren abhängig */
    public static void aufgabeB()
    {
        try
        {
            SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop3 = new SimpleIntegerProperty();

            prop1.bind(prop2);
            prop1.bind(prop3);
            prop3.set(5);
            prop2.set(10);
            System.out.println(prop1.get());

        }
        catch (Exception e)
        {
            System.out.println("Funktioniert nicht");
        }

    }

    /* 1c) unidirektional eine Property gibt Änderung an mehrere weiter */
    public static void aufgabeC()
    {
        try
        {
            SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop3 = new SimpleIntegerProperty();

            prop1.bind(prop2);
            prop3.bind(prop2);

            prop2.set(10);
            System.out.println(prop1.get());
            System.out.println(prop3.get());

        }
        catch (Exception e)
        {
            System.out.println("Funktioniert nicht");
        }

    }

    /* 1d) unidirekttion im Kreis gekoppelt */
    public static void aufgabeD()
    {
        try
        {
            SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop3 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop4 = new SimpleIntegerProperty();

            prop1.bind(prop2);
            prop2.bind(prop3);
            prop3.bind(prop4);
            prop4.bind(prop1);

            prop2.set(10);
            System.out.println(prop1.get());

        }
        catch (Throwable e)
        {
            System.out.println("Funktioniert nicht");
        }

    }

    /* 1e) bidirektional vier in Reihe gekoppelt */
    public static void aufgabeE()
    {
        try
        {
            SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop3 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop4 = new SimpleIntegerProperty();
            prop1.bindBidirectional(prop2);
            prop2.bindBidirectional(prop3);
            prop3.bindBidirectional(prop4);
            prop4.set(5);
            System.out.println(prop1.get());
            System.out.println(prop2.get());
            System.out.println(prop3.get());
            System.out.println(prop4.get());

        }
        catch (Exception e)
        {
            System.out.println("Funktioniert nicht");
        }
    }

    /* 1f) bidirekttion im Kreis gekoppelt */
    public static void aufgabeF()
    {
        try
        {
            SimpleIntegerProperty prop1 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop2 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop3 = new SimpleIntegerProperty();
            SimpleIntegerProperty prop4 = new SimpleIntegerProperty();

            prop1.bindBidirectional(prop2);
            prop2.bindBidirectional(prop3);
            prop3.bindBidirectional(prop4);
            prop4.bindBidirectional(prop1);

            prop2.set(10);
            System.out.println(prop1.get());
            System.out.println(prop2.get());
            System.out.println(prop3.get());
            System.out.println(prop4.get());
        }
        catch (Throwable e)
        {
            System.out.println("Funktioniert nicht");
        }

    }

    public static void main(String[] args)
    {
        System.out.println("Aufgabe A: ");
        aufgabeA();
        System.out.println();
        System.out.println("Aufgabe B: ");
        aufgabeB();
        System.out.println();
        System.out.println("Aufgabe C: ");
        aufgabeC();
        System.out.println();
        System.out.println("Aufgabe D: ");
        aufgabeD();
        System.out.println();
        System.out.println("Aufgabe E: ");
        aufgabeE();
        System.out.println();
        System.out.println("Aufgabe F: ");
        aufgabeF();
    }

}
