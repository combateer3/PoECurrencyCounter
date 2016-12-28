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

    @FXML
    private Label chanceAverage;

    @FXML
    private Label chanceTotal;

    @FXML
    private Label scouringAverage;

    @FXML
    private Label scouringTotal;

    @FXML
    private Label blessedAverage;

    @FXML
    private Label blessedTotal;

    @FXML
    private Label regretAverage;

    @FXML
    private Label regretTotal;

    @FXML
    private Label chromaticAverage;

    @FXML
    private Label chromaticTotal;

    @FXML
    private Label gemcutterAverage;

    @FXML
    private Label gemcutterTotal;

    @FXML
    private Label fusingAverage;

    @FXML
    private Label fusingTotal;

    @FXML
    private Label jewellerAverage;

    @FXML
    private Label jewellerTotal;

    @FXML
    private Label chiselAverage;

    @FXML
    private Label chiselTotal;

    @FXML
    private Label vaalAverage;

    @FXML
    private Label vaalTotal;

    @FXML
    private Label baubleAverage;

    @FXML
    private Label baubleTotal;

    @FXML
    private Label scrapAverage;

    @FXML
    private Label scrapTotal;

    @FXML
    private Label whetstoneAverage;

    @FXML
    private Label whetstoneTotal;

    private static Zone currentZone;

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
        appendLabelText(chanceAverage, average(Main.Currency.CHANCE));
        appendLabelText(scouringAverage, average(Main.Currency.SCOURING));
        appendLabelText(blessedAverage, average(Main.Currency.BLESSED));
        appendLabelText(regretAverage, average(Main.Currency.REGRET));
        appendLabelText(chromaticAverage, average(Main.Currency.CHROMATIC));
        appendLabelText(fusingAverage, average(Main.Currency.FUSING));
        appendLabelText(gemcutterAverage, average(Main.Currency.GEMCUTTER));
        appendLabelText(jewellerAverage, average(Main.Currency.JEWELLER));
        appendLabelText(chiselAverage, average(Main.Currency.CHISEL));
        appendLabelText(vaalAverage, average(Main.Currency.VAAL));
        appendLabelText(baubleAverage, average(Main.Currency.BAUBLE));
        appendLabelText(scrapAverage, average(Main.Currency.SCRAP));
        appendLabelText(whetstoneAverage, average(Main.Currency.WHETSTONE));

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
        appendLabelText(chanceTotal, total(Main.Currency.CHANCE));
        appendLabelText(scouringTotal, total(Main.Currency.SCOURING));
        appendLabelText(blessedTotal, total(Main.Currency.BLESSED));
        appendLabelText(regalTotal, total(Main.Currency.REGRET));
        appendLabelText(chromaticTotal, total(Main.Currency.CHROMATIC));
        appendLabelText(fusingTotal, total(Main.Currency.FUSING));
        appendLabelText(gemcutterTotal, total(Main.Currency.GEMCUTTER));
        appendLabelText(jewellerTotal, total(Main.Currency.JEWELLER));
        appendLabelText(chiselTotal, total(Main.Currency.CHISEL));
        appendLabelText(vaalTotal, total(Main.Currency.VAAL));
        appendLabelText(baubleTotal, total(Main.Currency.BAUBLE));
        appendLabelText(scrapTotal, total(Main.Currency.SCRAP));
        appendLabelText(whetstoneTotal, total(Main.Currency.WHETSTONE));
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
