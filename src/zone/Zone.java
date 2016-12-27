package zone;

import driver.Main;

import java.io.Serializable;
import java.util.HashMap;

public class Zone implements Serializable {

    private String name;
    private int run;

    private HashMap<Main.Currency, Integer> currencies;

    public Zone(String name) {
        this.name = name;
        //default first run
        this.run = 1;
        currencies = new HashMap<>();

        //default values of zero for new zone
        for (Main.Currency currency : Main.Currency.values()) {
            currencies.put(currency, 0);
        }
    }

    public void addCurrency(Main.Currency currencyType, int amount) {
        int currentAmount = currencies.get(currencyType);
        currencies.put(currencyType, currentAmount + amount);
    }

    public int getRun() {
        return run;
    }

    public String getName() {
        return name;
    }
}
