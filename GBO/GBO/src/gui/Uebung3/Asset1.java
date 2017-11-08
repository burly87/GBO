package gui.Uebung3;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;

public class Asset1
{

    private static final int FACTOR = 1;

    private IntegerProperty accountBalanceEuro;

    private ReadOnlyIntegerWrapper accountBalanceDollar;

    private NumberBinding accountBalanceDollar2;

    public Asset1(int value)
    {
        accountBalanceEuro = new SimpleIntegerProperty(value);
        accountBalanceDollar = new ReadOnlyIntegerWrapper(value * FACTOR);

        // hier gebunden! und jetzt ändert sich Dollar immer mit
        accountBalanceDollar2 = accountBalanceEuro.multiply(FACTOR);

        // ReadOnly - Daten können Inkonsistent sein
        // ich kann get.accountBalanceEuroProp().set(AccountBalance) verwenden
        // und damit würde sch nur Euro ändern nicht dolar

    }

    public int getAccountBalanceEuro()
    {
        return accountBalanceEuro.get();
    }

    public int getAccountBalanceDollar()
    {
        return accountBalanceDollar.get();
    }

    public void setAccountBalanceEuro(int newValue)
    {
        accountBalanceEuro.set(newValue);
        accountBalanceDollar.set(newValue * FACTOR);
    }

    public IntegerProperty accountBalanceEuroProperty()
    {
        return accountBalanceEuro;
    }

    // kann mit set nicht geändert werden. ReadOnly
    public ReadOnlyIntegerProperty accountBalanceDollarProperty()
    {
        return accountBalanceDollar.getReadOnlyProperty();
    }

    public static void main(String[] args)
    {
        Asset1 betrag = new Asset1(0);
        betrag.setAccountBalanceEuro(15);
        betrag.accountBalanceEuroProperty().set(20);
        System.out.println("Betrag Dollar: " + betrag.getAccountBalanceDollar());
        System.out.println("Betrag Euro: " + betrag.getAccountBalanceEuro());

    }

}
