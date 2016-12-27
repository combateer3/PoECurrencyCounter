package gui;

import driver.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import zone.Zone;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class StatsController {

    @FXML
    private Label titleLabel;

    @FXML
    private Label transmuteAverage;

    @FXML
    private Label transmuteTotal;

    @FXML
    private Label augmentAverage;

    @FXML
    private Label augmentTotal;

    @FXML
    private Label altAverage;

    @FXML
    private Label altTotal;

    @FXML
    private Label alchAverage;

    @FXML
    private Label alchTotal;

    @FXML
    private Label regalAverage;

    @FXML
    private Label regalTotal;

    @FXML
    private Label chaosAverage;

    @FXML
    private Label chaosTotal;

    @FXML
    private Label exaltAverage;

    @FXML
    private Label exaltTotal;

    @FXML
    private Label divineAverage;

    @FXML
    private Label divineTotal;

    @FXML
    private Label mirrorAverage;

    @FXML
    private Label mirrorTotal;

    @FXML
    private Label silverAverage;

    @FXML
    private Label silverTotal;

    private Zone currentZone;

    private List<HashMap<Main.Currency, Integer>> runs;

    @FXML
    private void initialize() {
        currentZone = MainController.getCurrentZone();
        runs = currentZone.getRuns();

        appendLabelText(titleLabel, currentZone.getName());

        //averages
        appendLabelText(transmuteAverage, average(Main.Currency.TRANSMUTE));
        appendLabelText(augmentAverage, average(Main.Currency.AUGMENT));
        appendLabelText(altAverage, average(Main.Currency.ALT));
        appendLabelText(alchAverage, average(Main.Currency.ALCH));
        appendLabelText(regalAverage, average(Main.Currency.REGAL));
        appendLabelText(chaosAverage, average(Main.Currency.CHAOS));
        appendLabelText(exaltAverage, average(Main.Currency.EXALT));
        appendLabelText(divineAverage, average(Main.Currency.DIVINE));
        appendLabelText(mirrorAverage, average(Main.Currency.MIRROR));
        appendLabelText(silverAverage, average(Main.Currency.SILVER));

        //totals
        appendLabelText(transmuteTotal, total(Main.Currency.TRANSMUTE));
        appendLabelText(augmentTotal, total(Main.Currency.AUGMENT));
        appendLabelText(altTotal, total(Main.Currency.ALT));
        appendLabelText(alchTotal, total(Main.Currency.ALCH));
        appendLabelText(regalTotal, total(Main.Currency.REGAL));
        appendLabelText(chaosTotal, total(Main.Currency.CHAOS));
        appendLabelText(exaltTotal, total(Main.Currency.EXALT));
        appendLabelText(divineTotal, total(Main.Currency.DIVINE));
        appendLabelText(mirrorTotal, total(Main.Currency.MIRROR));
        appendLabelText(silverTotal, total(Main.Currency.SILVER));
    }

    private double average(Main.Currency currencyType) {
        double avg = 0;
        for (HashMap<Main.Currency, Integer> run : runs) {
            avg += run.get(currencyType);
        }
        if (runs.size() != 0) {
            avg /= runs.size();
        } else {
            return 0;
        }

        return avg;
    }

    private int total(Main.Currency currencyType) {
        int sum = 0;
        for (HashMap<Main.Currency, Integer> run : runs) {
            sum += run.get(currencyType);
        }

        return sum;
    }

    private void appendLabelText(Label label, String text) {
        String currentText = label.getText();
        label.setText(currentText + text);
    }

    private void appendLabelText(Label label, double text) {
        String currentText = label.getText();
        label.setText(currentText + new DecimalFormat("0.00").format(text));
    }

    private void appendLabelText(Label label, int text) {
        String currentText = label.getText();
        label.setText(currentText + text);
    }

}
