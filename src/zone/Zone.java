package zone;

import driver.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zone implements Serializable {

    private String name;
    private int run;

    private HashMap<Main.Currency, Integer> currencies;

    private List<HashMap<Main.Currency, Integer>> runs;

    public Zone(String name) {
        this.name = name;
        //default first run
        this.run = 1;
        currencies = new HashMap<>();
        runs = new ArrayList<>();

        //default values of zero for new zone
        resetCurrencies();
    }

    public void addCurrency(Main.Currency currencyType, int amount) {
        int currentAmount = currencies.get(currencyType);
        int total = currentAmount + amount;

        if (total < 0) {
            total = 0;
        }
        currencies.put(currencyType, total);
    }

    public int getCurrency(Main.Currency currencyType) {
        return currencies.get(currencyType);
    }

    public void createNewRun() {
        runs.add(new HashMap<>(currencies));
        run += 1;
        resetCurrencies();
    }

    public void totalReset() {
        resetCurrencies();
        runs.clear();
        run = 1;
    }

    private void resetCurrencies() {
        for (Main.Currency currency : Main.Currency.values()) {
            currencies.put(currency, 0);
        }
    }

    public int getRun() {
        return run;
    }

    public String getName() {
        return name;
    }

    public List<HashMap<Main.Currency, Integer>> getRuns() {
        return runs;
    }
}
