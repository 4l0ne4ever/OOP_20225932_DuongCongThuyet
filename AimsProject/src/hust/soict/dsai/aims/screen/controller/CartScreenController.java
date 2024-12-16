package AimsProject.src.hust.soict.dsai.aims.screen.controller;

import AimsProject.src.hust.soict.dsai.aims.cart.Cart;
import AimsProject.src.hust.soict.dsai.aims.exception.PlayerException;
import AimsProject.src.hust.soict.dsai.aims.media.Media;
import AimsProject.src.hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label costLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private Button placeOrder;

    @FXML
    void placeOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, cart.placeOrder());
        alert.setTitle("Order created");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media == null) {
            showAlert(Alert.AlertType.WARNING, "No media selected", "Please select a media to play.");
            return;
        }
        Alert alert;
        try {
            alert = new Alert(Alert.AlertType.NONE, media.playGUI());
            alert.setTitle("Playing");
            alert.setHeaderText(null);
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert.showAndWait();
        } catch (PlayerException e) {
            alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media == null) {
            showAlert(Alert.AlertType.WARNING, "No media selected", "Please select a media to remove.");
            return;
        }
        cart.removeMedia(media);
        costLabel.setText(cart.totalCost() + " $");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType, content);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        costLabel.setText(cart.totalCost() + "$");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                });

        tfFilter.textProperty().addListener(
                (observable, oldValue, newValue) -> showFilteredMedia(newValue));
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void showFilteredMedia(String keyword) {
        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());

        if (!keyword.isEmpty() && radioBtnFilterId.isSelected()) {
            filteredList.setPredicate(media -> String.valueOf(media.getId()).equals(keyword));
        } else if (!keyword.isEmpty() && radioBtnFilterTitle.isSelected()) {
            filteredList.setPredicate(media -> media.getTitle().toLowerCase().contains(keyword.toLowerCase()));
        } else {
            filteredList.setPredicate(null);
        }
        tblMedia.setItems(filteredList);
    }
}