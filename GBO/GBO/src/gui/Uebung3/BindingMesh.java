package gui.Uebung3;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

//UEBUNG 3 - Aufgabe 2
/* Varriieren Sie das Kopplungsnetz aus der VL, indem Sie die Formal a^2 + b^2 berechnen!
 * Jedes Mal, wenn sich a oder b ändern, sollen Sie den neuen Wert der Formel auf der Konsole ausgeben!*/
public class BindingMesh
{
    public static void main(String[] args)
    {
        SimpleIntegerProperty a = new SimpleIntegerProperty(0);
        SimpleIntegerProperty b = new SimpleIntegerProperty(0);

        // (a*a) + (b*b)
        NumberBinding sum = (a.multiply(a)).add(b.multiply(b));

        sum.addListener(new ChangeListener<Number>()
        {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                System.out.println(">>>Sum changed from " + oldValue + " to " + newValue);
            }
        });

        System.out.println("Start:");
        System.out.println("Sum = " + sum.getValue());
        System.out.println("==============");

        System.out.println("Setting a to 2:");
        a.setValue(2);
        System.out.println("Sum = " + sum.getValue());
        System.out.println("==============");

        System.out.println("Setting b to 2:");
        b.setValue(2);
        System.out.println("Sum = " + sum.getValue());
        System.out.println("==============");

        System.out.println("Setting b to 4:");
        b.setValue(4);

    }
}
