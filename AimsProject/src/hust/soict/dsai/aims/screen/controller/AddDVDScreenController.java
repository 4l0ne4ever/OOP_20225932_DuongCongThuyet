package AimsProject.src.hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.ResourceBundle;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddDVDScreenController {

    private Store store;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    private boolean allFieldsFilled = false;

    public AddDVDScreenController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        if (title.isEmpty() || category.isEmpty() || director.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Empty fields", "Please fill in all fields.");
            return;
        }
        int length;
        try {
            length = Integer.parseInt(tfLength.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid length", "Failed to parse length!");
            return;
        }
        float cost;
        try {
            cost = Float.parseFloat(tfCost.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid cost", "Failed to parse cost!");
            return;
        }
        DigitalVideoDisc DVD = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(DVD);
        clearFields();
        showAlert(Alert.AlertType.INFORMATION, "Success", "DVD has been added to the store!");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType, content);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void clearFields() {
        tfTitle.clear();
        tfCategory.clear();
        tfDirector.clear();
        tfLength.clear();
        tfCost.clear();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);

        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfDirector.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    private void checkFieldsFilled() {
        allFieldsFilled = !tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty()
                && !tfDirector.getText().isEmpty()
                && !tfLength.getText().isEmpty() && !tfCost.getText().isEmpty();
        btnSave.setDisable(!allFieldsFilled);
    }

}