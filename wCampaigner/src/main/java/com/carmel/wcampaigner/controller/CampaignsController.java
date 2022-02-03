package com.carmel.wcampaigner.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class CampaignsController implements Initializable, ScreenController {

    public String[] campaigns = {"21-01-2022", "20-01-2022", "19-01-2022"};
    @FXML
    private MenuItem goToGroups;
    @FXML
    private MenuItem goToContacts;
    @FXML
    private ListView<String> campaignsListView;
    private ScreenPane screenPane;

    @Override
    public void setScreenPane(ScreenPane screenPage) {
        screenPane = screenPage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        campaignsListView.getItems().addAll(campaigns);
    }

    public void mainMenuClickHandler(Event event) {
        if (event.getSource() == goToContacts) {
            screenPane.setScreen("contacts");
        }
        if (event.getSource() == goToGroups) {
            screenPane.setScreen("groups");
        }

    }
}
