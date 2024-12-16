package AimsProject.src.hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.ResourceBundle;

import AimsProject.src.hust.soict.dsai.aims.media.CompactDisc;
import AimsProject.src.hust.soict.dsai.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTrackScreenController {
    private CompactDisc CD;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSaveTrack;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    private boolean allFieldsFilled = false;

    public AddTrackScreenController(CompactDisc CD) {
        super();
        this.CD = CD;
    }

    @FXML
    void btnSaveTrackPressed(ActionEvent event) {
        String title = tfTitle.getText();
        if (title.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Empty title", "Please enter a title.");
            return;
        }
        int length;
        try {
            length = Integer.parseInt(tfLength.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid length", "Failed to parse length!");
            return;
        }
        Track track = new Track(title, length);
        CD.addTrack(track);
        tfTitle.clear();
        tfLength.clear();
        showAlert(Alert.AlertType.INFORMATION, "Success", "Track has been added!");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType, content);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSaveTrack.setDisable(true);

        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    private void checkFieldsFilled() {
        allFieldsFilled = !tfTitle.getText().isEmpty() && !tfLength.getText().isEmpty();
        btnSaveTrack.setDisable(!allFieldsFilled);
    }

}