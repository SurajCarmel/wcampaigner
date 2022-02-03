package com.carmel.wcampaigner;

import com.carmel.wcampaigner.Main.StageReadyEvent;
import com.carmel.wcampaigner.controller.ScreenPane;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("${spring.application.ui.title}")
    String title;

    String CONTACTSPATH = "/fxml/contacts.fxml";
    String GROUPSPATH = "/fxml/groups.fxml";
    String CAMPAIGNSPATH = "/fxml/campaigns.fxml";
    String CSSPATH = "/css/fx.css";

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            Stage landingStage = event.getStage();
            ScreenPane mainContainer = new ScreenPane();
            mainContainer.loadScreen("contacts",CONTACTSPATH);
            mainContainer.loadScreen("groups", GROUPSPATH);
            mainContainer.loadScreen("campaigns", CAMPAIGNSPATH);
            mainContainer.setScreen("contacts");

            Scene scene = new Scene(mainContainer);
            scene.getStylesheets().add(getClass().getResource(CSSPATH).toExternalForm());

            Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

            landingStage.setX(bounds.getMinX());
            landingStage.setY(bounds.getMinY());
            landingStage.setWidth(bounds.getWidth());
            landingStage.setHeight(bounds.getHeight());
            landingStage.setResizable(true);
            landingStage.setTitle(title);
            landingStage.setScene(scene);
            landingStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
