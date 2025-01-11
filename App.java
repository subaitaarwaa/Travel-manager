package com.example.travelmaniac;


import models.User;
import models.Trip;
import models.Activity;
import utils.FileHandler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class App extends Application {
    public static ArrayList<Trip> trips = new ArrayList<>();
    public static User currentUser = null;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

       // Create a default user for testing
    currentUser = new User("admin", "password");
        trips = FileHandler.loadTrips();

        
        showLoginScreen();
    }

    private void showLoginScreen() {
        LoginScreen loginScreen = new LoginScreen(primaryStage, this);
        primaryStage.setScene(loginScreen.getScene());
        primaryStage.setTitle("TravelManiac - Login");
        primaryStage.show();
    }

    public void showDashboard() {
        DashboardScreen dashboardScreen = new DashboardScreen(primaryStage, this);
        primaryStage.setScene(dashboardScreen.getScene());
        primaryStage.setTitle("TravelManiac - Dashboard");
    }

    public void showAddTripScreen() {
        AddTripScreen addTripScreen = new AddTripScreen(primaryStage, this);
        primaryStage.setScene(addTripScreen.getScene());
        primaryStage.setTitle("TravelManiac - Add Trip");
    }
    
    public void showTripDetails(Trip trip) {
    TripDetailsScreen tripDetailsScreen = new TripDetailsScreen(primaryStage, this, trip);
    primaryStage.setScene(tripDetailsScreen.getScene());
    primaryStage.setTitle("Trip Details");
}


    public void showAddActivityScreen() {
        AddActivityScreen addActivityScreen = new AddActivityScreen(primaryStage, this);
        primaryStage.setScene(addActivityScreen.getScene());
        primaryStage.setTitle("TravelManiac - Add Activity");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
