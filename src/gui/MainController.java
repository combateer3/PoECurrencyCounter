package gui;

import driver.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import zone.Zone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    private static final String FILE = "data/zones.dat";

    private static List<Zone> zones;
    private static List<String> zoneNames;

    @FXML
    private ChoiceBox zonesBox;

    @FXML
    private TextField zoneField;

    @FXML
    private Label runLabel;

    @FXML
    private Label transmuteLabel;

    @FXML
    private Label augmentLabel;

    @FXML
    private Label altLabel;

    @FXML
    private Label alchLabel;

    @FXML
    private Label regalLabel;

    @FXML
    private Label chaosLabel;

    @FXML
    private Label exaltLabel;

    @FXML
    private Label divineLabel;

    @FXML
    private Label mirrorLabel;

    @FXML
    private Label silverLabel;

    private static Zone currentZone;

    @FXML
    private void initialize() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));

            zones = (List<Zone>) ois.readObject();
        } catch (EOFException e) {
            zones = new ArrayList<>();
            zones.add(new Zone("Dried Lake"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        zoneNames = new ArrayList<>();

        refreshZonesBox();
        updateLabels();

        zonesBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if ((int) newValue >= 0) {
                    currentZone = zones.get((int) newValue);
                    updateLabels();
                }
            }
        });
    }

    public static void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
            oos.writeObject(zones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void refreshZonesBox() {
        zoneNames.clear();
        for (Zone zone : zones) {
            zoneNames.add(zone.getName());
        }

        zonesBox.setItems(FXCollections.observableArrayList(zoneNames));
        //default selections
        zonesBox.setValue(zoneNames.get(0));
        currentZone = zones.get(0);
    }

    private void updateLabels() {
        transmuteLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.TRANSMUTE)));
        augmentLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.AUGMENT)));
        altLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.ALT)));
        alchLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.ALCH)));
        regalLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.REGAL)));
        chaosLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.CHAOS)));
        exaltLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.EXALT)));
        divineLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.DIVINE)));
        mirrorLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.MIRROR)));
        silverLabel.setText(String.valueOf(currentZone.getCurrency(Main.Currency.SILVER)));

        runLabel.setText("Run " + currentZone.getRun());
    }

    @FXML
    private void clearData() {
        currentZone.totalReset();
        updateLabels();
    }

    @FXML
    private void clearAllData() {
        for (Zone zone : zones) {
            zone.totalReset();
        }
        updateLabels();
    }

    @FXML
    private void openStatsWindow() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("statsGUI.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Stats");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void createNewZone() {
        String name = zoneField.getText();
        if (name != null) {
            zones.add(new Zone(name));
            zoneNames.add(name);

            zoneField.clear();
        }

        refreshZonesBox();
    }

    @FXML
    private void deleteZone() {
        zones.remove(currentZone);
        refreshZonesBox();
        updateLabels();
    }

    @FXML
    private void createNewRun() {
        currentZone.createNewRun();
        runLabel.setText("Run " + currentZone.getRun());
        updateLabels();
    }

    @FXML
    private void addTransmute() {
        currentZone.addCurrency(Main.Currency.TRANSMUTE, 1);
        updateLabels();
    }

    @FXML
    private void removeTransmute() {
        currentZone.addCurrency(Main.Currency.TRANSMUTE, -1);
        updateLabels();
    }

    @FXML
    private void addAugment() {
        currentZone.addCurrency(Main.Currency.AUGMENT, 1);
        updateLabels();
    }

    @FXML
    private void removeAugment() {
        currentZone.addCurrency(Main.Currency.AUGMENT, -1);
        updateLabels();
    }

    @FXML
    private void addAlt() {
        currentZone.addCurrency(Main.Currency.ALT, 1);
        updateLabels();
    }

    @FXML
    private void removeAlt() {
        currentZone.addCurrency(Main.Currency.ALT, -1);
        updateLabels();
    }

    @FXML
    private void addAlch() {
        currentZone.addCurrency(Main.Currency.ALCH, 1);
        updateLabels();
    }

    @FXML
    private void removeAlch() {
        currentZone.addCurrency(Main.Currency.ALCH, -1);
        updateLabels();
    }

    @FXML
    private void addRegal() {
        currentZone.addCurrency(Main.Currency.REGAL, 1);
        updateLabels();
    }

    @FXML
    private void removeRegal() {
        currentZone.addCurrency(Main.Currency.REGAL, -1);
        updateLabels();
    }

    @FXML
    private void addChaos() {
        currentZone.addCurrency(Main.Currency.CHAOS, 1);
        updateLabels();
    }

    @FXML
    private void removeChaos() {
        currentZone.addCurrency(Main.Currency.CHAOS, -1);
        updateLabels();
    }

    @FXML
    private void addExalt() {
        currentZone.addCurrency(Main.Currency.EXALT, 1);
        updateLabels();
    }

    @FXML
    private void removeExalt() {
        currentZone.addCurrency(Main.Currency.EXALT, -1);
        updateLabels();
    }

    @FXML
    private void addDivine() {
        currentZone.addCurrency(Main.Currency.DIVINE, 1);
        updateLabels();
    }

    @FXML
    private void removeDivine() {
        currentZone.addCurrency(Main.Currency.DIVINE, -1);
        updateLabels();
    }

    @FXML
    private void addMirror() {
        currentZone.addCurrency(Main.Currency.MIRROR, 1);
        updateLabels();
    }

    @FXML
    private void removeMirror() {
        currentZone.addCurrency(Main.Currency.MIRROR, -1);
        updateLabels();
    }

    @FXML
    private void addSilver() {
        currentZone.addCurrency(Main.Currency.SILVER, 1);
        updateLabels();
    }

    @FXML
    private void removeSilver() {
        currentZone.addCurrency(Main.Currency.SILVER, -1);
        updateLabels();
    }

    public static Zone getCurrentZone() {
        return currentZone;
    }

}
