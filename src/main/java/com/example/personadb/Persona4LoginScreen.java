package com.example.personadb;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Persona4LoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Persona 4 Logowanie");

        // Tworzenie pól tekstowych dla nazwy użytkownika i hasła
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        // Tworzenie etykiet
        Label usernameLabel = new Label("Nazwa użytkownika:");
        Label passwordLabel = new Label("Hasło:");
        Label titleLabel = new Label("Persona 4 Logowanie");

        // Stylowanie etykiet
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.web("#FFA500")); // Orange

        // Tworzenie przycisku logowania
        Button loginButton = new Button("Zaloguj");
        loginButton.setStyle("-fx-background-color: #FFA500; -fx-text-fill: #000000;"); // Orange background, black text

        // Stylowanie przycisku po najechaniu myszką
        loginButton.setOnMouseEntered(e -> loginButton.setStyle("-fx-background-color: #FFD700; -fx-text-fill: #000000;")); // Gold background on hover
        loginButton.setOnMouseExited(e -> loginButton.setStyle("-fx-background-color: #FFA500; -fx-text-fill: #000000;")); // Restore original style on exit

        // Obsługa zdarzenia przycisku logowania
        loginButton.setOnAction(event -> {
            // Tutaj można dodać logikę logowania, np. sprawdzanie poprawności danych
            System.out.println("Próba logowania z nazwą użytkownika: " + usernameField.getText());
        });

        // Tworzenie siatki i dodawanie elementów do niej
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(titleLabel, 0, 0, 2, 1);
        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(loginButton, 1, 3);

        // Ustawianie tła siatki na motyw "Persona 4"
        grid.setBackground(new Background(new BackgroundFill(Color.web("#1F1F1F"), CornerRadii.EMPTY, Insets.EMPTY))); // Dark background

        // Ustawianie siatki na scenę
        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

