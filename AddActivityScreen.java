package com.example.travelmaniac;
import models.User;
import models.Trip;
import models.Activity;
import utils.FileHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddActivityScreen {
    private Scene scene;

    public AddActivityScreen(Stage stage, App app) {
        TextField activityNameField = new TextField();
        activityNameField.setPromptText("Enter activity name");

        TextField dateField = new TextField();
        dateField.setPromptText("Enter date");

        Button saveButton = new Button("Save Activity");
        saveButton.setOnAction(e -> {
            Activity activity = new Activity(activityNameField.getText(), dateField.getText());
            System.out.println("Activity saved: " + activityNameField.getText());
            app.showDashboard();
        });

        VBox layout = new VBox(10, activityNameField, dateField, saveButton);
        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
