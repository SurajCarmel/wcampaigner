package com.carmel.wcampaigner.controller;

import com.carmel.wcampaigner.entity.ContactEntity;
import com.carmel.wcampaigner.repository.ContactRepository;
import com.carmel.wcampaigner.service.ContactService;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ContactsController implements Initializable, ScreenController {

    public String[] contacts = {"John DZoe", "Jane Doe", "Charlie", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name", "name"};
    Double dragX;
    Double dragY;
    Double popupX;
    Double popupY;

    @FXML
    private MenuItem goToGroups;

    @FXML
    private MenuItem goToCampaigns;

    @FXML
    private ListView<String> contactsListView;

    @FXML
    private Button addContact;

    @FXML
    private Button importContact;

    @FXML
    private ImageView contactDelete;

    @FXML
    private ImageView contactEdit;

    private ScreenPane screenPane;

    @Autowired
    ContactService contactService;

/*    @Autowired
    ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (contactsListView!=null) {
            contactsListView.getItems().addAll(contacts);
        }
    }

    @Override
    public void setScreenPane(ScreenPane screenPage) {
        screenPane = screenPage;
    }

    public void mainMenuClickHandler(Event event) {
        if (event.getSource() == goToGroups) {
            screenPane.setScreen("groups");
        }
        if (event.getSource() == goToCampaigns) {
            screenPane.setScreen("campaigns");
        }
    }

    public void deleteContactHandle(Event event) {
        Alert alert = new Alert(Alert.AlertType.NONE, "Confirm deletion?", ButtonType.NO, ButtonType.YES);
        alert.setTitle("DELETE");
        alert.showAndWait();
        alert.setX((screenPane.getWidth() - alert.getWidth()) / 2);
        alert.setY((screenPane.getHeight() / 2));
        if (alert.getResult() == ButtonType.YES) {
            System.out.println("DELETED");
        }
        if (alert.getResult() == ButtonType.NO) {
            alert.close();
        }
    }

    public void addContactHandler(Event event) throws IOException {

        if (event.getSource() == addContact) {
            FXMLLoader loader = new FXMLLoader();
            URL popupURL = getClass().getResource("/fxml/contacts-form.fxml");
            loader.setLocation(popupURL);
            AnchorPane pane = (AnchorPane) loader.load();
            Popup popup = new Popup();
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);
            popup.setAutoFix(true);
            popup.getContent().add(pane);
            popup.show(contactsListView.getScene().getWindow());
            popup.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {
                    dragX = mouseEvent.getScreenX();
                    dragY = mouseEvent.getScreenY();
                    popupX = popup.getX();
                    popupY = popup.getY();
                }
            });
            popup.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {
                    popup.setX(popupX + mouseEvent.getScreenX() - dragX);
                    popup.setY(popupY + mouseEvent.getScreenY() - dragY);
                }
            });
        }
    }

    public void editContactHandler(Event event) throws IOException {
        if (event.getSource() == contactEdit) {
            FXMLLoader loader = new FXMLLoader();
            URL popupURL = getClass().getResource("/fxml/contacts-form.fxml");
            loader.setLocation(popupURL);
            AnchorPane pane = (AnchorPane) loader.load();
            Popup popup = new Popup();
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);
            popup.setAutoFix(true);
            popup.getContent().add(pane);
            popup.show(contactsListView.getScene().getWindow());
            popup.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {
                    dragX = mouseEvent.getScreenX();
                    dragY = mouseEvent.getScreenY();
                    popupX = popup.getX();
                    popupY = popup.getY();
                }
            });
            popup.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {
                    popup.setX(popupX + mouseEvent.getScreenX() - dragX);
                    popup.setY(popupY + mouseEvent.getScreenY() - dragY);
                }
            });
        }
    }

    public void importContactHandler(Event event) {
        FileChooser filePopup = new FileChooser();
        filePopup.showOpenDialog(contactsListView.getScene().getWindow());
    }

    public void handleSaveContact(Event event) {
        contactService.save(new ContactEntity("suraj", "8660882025", null, null));
    }
}