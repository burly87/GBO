package gui.Uebung3;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;

public class Asset1
{
    /* SO SOLLS NICHT GEMACHT WERDEN - funktioniert aber auch */

    private static final int FACTOR = 1;

    private IntegerProperty accountBalanceEuro;

    private ReadOnlyIntegerWrapper accountBalanceDollar;

    public Asset1(int value)
    {
        accountBalanceEuro = new SimpleIntegerProperty(value);
        accountBalanceDollar = new ReadOnlyIntegerWrapper(value * FACTOR);
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

}
