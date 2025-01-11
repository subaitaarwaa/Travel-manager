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

public class AddTripScreen {
    private Scene scene;

    public AddTripScreen(Stage stage, App app) {
        TextField tripNameField = new TextField();
        tripNameField.setPromptText("Enter trip name");

        TextField destinationField = new TextField();
        destinationField.setPromptText("Enter destination");

        TextField startDateField = new TextField();
        startDateField.setPromptText("Start date");

        TextField endDateField = new TextField();
        endDateField.setPromptText("End date");

        Button saveButton = new Button("Save Trip");
        saveButton.setOnAction(e -> {
            Trip trip = new Trip(tripNameField.getText(), destinationField.getText(), startDateField.getText(), endDateField.getText());
            App.trips.add(trip);
            System.out.println("Trip saved: " + tripNameField.getText());
            app.showDashboard();
        });

        VBox layout = new VBox(10, tripNameField, destinationField, startDateField, endDateField, saveButton);
        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
