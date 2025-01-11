package com.example.travelmaniac;


import models.User;
import models.Trip;
import models.Activity;
import utils.FileHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen {
    private Scene scene;

    public LoginScreen(Stage stage, App app) {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (App.currentUser != null && App.currentUser.login(username, password)) {
                System.out.println("Login successful!");
                app.showDashboard();
            } else {
                System.out.println("Invalid credentials!");
            }
        });

        VBox layout = new VBox(10, usernameField, passwordField, loginButton);
        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
