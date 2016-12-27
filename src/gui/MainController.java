package gui;

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

    @FXML
    private void initialize() {
        zones = new ArrayList<>();

        zonesBox.setItems(FXCollections.observableArrayList(zones));
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

    }

    @FXML
    private void removeTransmute() {

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
