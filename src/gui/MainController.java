package gui;

import driver.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import zone.Zone;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private List<Zone> zones;

    @FXML
    private ChoiceBox zonesBox;

    @FXML
    private TextField zoneField;

    private Zone currentZone;

    @FXML
    private void initialize() {
        zones = new ArrayList<>();
        zones.add(new Zone("Dried Lake"));

        zonesBox.setItems(FXCollections.observableArrayList(zones));
        //default selections
        zonesBox.setValue(zones.get(0));
        currentZone = zones.get(0);

        zonesBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                currentZone = zones.get((int) newValue);
            }
        });
    }

    @FXML
    private void createNewZone() {
        String name = zoneField.getText();
        if (name != null) {
            zones.add(new Zone(name));
        }
    }

    @FXML
    private void addTransmute() {
        currentZone.addCurrency(Main.Currency.TRANSMUTE, 1);
    }

    @FXML
    private void removeTransmute() {
        currentZone.addCurrency(Main.Currency.TRANSMUTE, -1);
    }

    @FXML
    private void addAugment() {

    }

    @FXML
    private void removeAugment() {

    }

    @FXML
    private void addAlt() {

    }

    @FXML
    private void removeAlt() {

    }

    @FXML
    private void addAlch() {

    }

    @FXML
    private void removeAlch() {

    }

    @FXML
    private void addRegal() {

    }

    @FXML
    private void removeRegal() {

    }

    @FXML
    private void addChaos() {

    }

    @FXML
    private void removeChaos() {

    }

    @FXML
    private void addExalt() {

    }

    @FXML
    private void removeExalt() {

    }

    @FXML
    private void addDivine() {

    }

    @FXML
    private void removeDivine() {

    }

    @FXML
    private void addMirror() {

    }

    @FXML
    private void removeMirror() {

    }

    @FXML
    private void addSilver() {

    }

    @FXML
    private void removeSilver() {

    }

}
