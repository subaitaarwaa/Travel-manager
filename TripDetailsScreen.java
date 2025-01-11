package com.example.travelmaniac;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Trip;
import models.Activity
        ;

public class TripDetailsScreen {
    private Scene scene;

    public TripDetailsScreen(Stage stage, App app, Trip trip) {
        // Display trip details
        Label tripNameLabel = new Label("Trip Name: " + trip.tripName);
        Label destinationLabel = new Label("Destination: " + trip.destination);
        Label dateRangeLabel = new Label("Dates: " + trip.startDate + " - " + trip.endDate);

        // Display activities
        Label activitiesLabel = new Label("Activities:");
        VBox activitiesList = new VBox();
        for (var activity : trip.activities) {
            Label activityLabel = new Label("- " + activity.activityName + " on " + activity.dateTime);
            activitiesList.getChildren().add(activityLabel);
        }

        // Add activity button
        Button addActivityButton = new Button("Add Activity");
        addActivityButton.setOnAction(e -> app.showAddActivityScreen());

        // Back button
        Button backButton = new Button("Back to Dashboard");
        backButton.setOnAction(e -> app.showDashboard());

        // Layout
        VBox layout = new VBox(10, tripNameLabel, destinationLabel, dateRangeLabel, activitiesLabel, activitiesList, addActivityButton, backButton);
        scene = new Scene(layout, 400, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
