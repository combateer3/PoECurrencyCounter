package zone;

import java.io.Serializable;
import java.util.HashMap;

public class Zone implements Serializable {

    private static final String[] CURRENCY_NAMES = {"transmute", "augment", "alt", "alch", "regal", "chaos", "exalt",
            "divine", "mirror", "silver"};

    private String name;

    private HashMap<String, Integer> currencies;

    public Zone(String name) {
        this.name = name;
        currencies = new HashMap<>();

        //initial values for zone are zero
        for (String currency : CURRENCY_NAMES) {
            currencies.put(currency, 0);
        }
    }

    public void addCurrency(String currencyType, int amount) {
        int currentAmount = currencies.get(currencyType);
        currencies.put(currencyType, currentAmount + amount);
    }

    public String getName() {
        return name;
    }
}
