package AimsProject.src.hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.ResourceBundle;

import AimsProject.src.hust.soict.dsai.aims.media.CompactDisc;
import AimsProject.src.hust.soict.dsai.aims.screen.AddTrack;
import AimsProject.src.hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCDScreenController {

    private Store store;

    private CompactDisc CD;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAddTrack;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnAddCD;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfArtist;

    @FXML
    private TextField tfTitle;

    private boolean allFieldsFilled = false;

    public AddCDScreenController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void btnAddCDPressed(ActionEvent event) {
        if (CD == null) {
            showAlert(Alert.AlertType.WARNING, "No CD", "Please save the CD details first.");
            return;
        }
        store.addMedia(CD);
        clearFields();
        disableButtons();
        showAlert(Alert.AlertType.INFORMATION, "Success", "CD has been added to the store!");
    }

    @FXML
    void btnAddTrackPressed(ActionEvent event) {
        new AddTrack(CD);
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String artist = tfArtist.getText();
        if (title.isEmpty() || category.isEmpty() || artist.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Empty fields", "Please fill in all fields.");
            return;
        }
        float cost;
        try {
            cost = Float.parseFloat(tfCost.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid cost", "Failed to parse cost!");
            return;
        }
        CD = new CompactDisc(title, category, artist, cost);
        btnAddCD.setDisable(false);
        btnAddTrack.setDisable(false);
        btnSave.setDisable(true);
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
        tfArtist.clear();
        tfCost.clear();
    }

    private void disableButtons() {
        btnSave.setDisable(true);
        btnAddCD.setDisable(true);
        btnAddTrack.setDisable(true);
    }

    @FXML
    void initialize() {
        disableButtons();

        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfArtist.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    private void checkFieldsFilled() {
        allFieldsFilled = !tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty()
                && !tfArtist.getText().isEmpty()
                && !tfCost.getText().isEmpty();
        btnSave.setDisable(!allFieldsFilled);
    }

}