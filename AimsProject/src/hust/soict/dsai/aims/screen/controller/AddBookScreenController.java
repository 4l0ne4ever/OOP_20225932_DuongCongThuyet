package AimsProject.src.hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.ResourceBundle;

import AimsProject.src.hust.soict.dsai.aims.media.Book;
import AimsProject.src.hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBookScreenController {

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
    private TextField tfTitle;

    private boolean allFieldsFilled = false;

    public AddBookScreenController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        if (title.isEmpty() || category.isEmpty()) {
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
        Book book = new Book(title, category, cost);
        store.addMedia(book);
        clearFields();
        showAlert(Alert.AlertType.INFORMATION, "Success", "Book has been added to the store!");
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
        tfCost.clear();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);

        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    private void checkFieldsFilled() {
        allFieldsFilled = !tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty()
                && !tfCost.getText().isEmpty();
        btnSave.setDisable(!allFieldsFilled);
    }

}