package com.example.travelmaniac;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Trip;

public class DashboardScreen {
    private Scene scene;

    public DashboardScreen(Stage stage, App app) {
        ListView<Trip> tripList = new ListView<>();
        tripList.getItems().addAll(App.trips);

        // Display the selected trip details when clicked
        tripList.setOnMouseClicked(event -> {
            Trip selectedTrip = tripList.getSelectionModel().getSelectedItem();
            if (selectedTrip != null) {
                app.showTripDetails(selectedTrip);
            }
        });

        Button addTripButton = new Button("Add Trip");
        addTripButton.setOnAction(e -> app.showAddTripScreen());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> app.start(stage));

        VBox layout = new VBox(10, tripList, addTripButton, logoutButton);
        scene = new Scene(layout, 400, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
