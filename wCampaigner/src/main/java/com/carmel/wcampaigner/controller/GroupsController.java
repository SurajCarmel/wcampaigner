package com.carmel.wcampaigner.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class GroupsController implements Initializable, ScreenController {


    public String[] groups = {"Group 1", "Group 2", "Group 3"};
    @FXML
    private MenuItem goToContacts;
    @FXML
    private MenuItem goToCampaigns;
    @FXML
    private ListView<String> groupsListView;
    private ScreenPane screenPane;

    @Override
    public void setScreenPane(ScreenPane screenPage) {
        screenPane = screenPage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        groupsListView.getItems().addAll(groups);
    }

    public void mainMenuClickHandler(Event event) {
        if (event.getSource() == goToContacts) {
            screenPane.setScreen("contacts");
        }
        if (event.getSource() == goToCampaigns) {
            screenPane.setScreen("campaigns");
        }

    }
}
