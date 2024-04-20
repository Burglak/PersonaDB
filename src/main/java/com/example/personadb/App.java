package com.example.personadb;

import javafx.animation.PauseTransition;
import com.example.personadb.model.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

public class App extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED); //remove title bar

        // Load and show the loading panel
        Parent loadingRoot = FXMLLoader.load(getClass().getResource("loading_panel.fxml"));
        Scene loadingScene = new Scene(loadingRoot);
        stage.setScene(loadingScene);
        stage.show();

        // Pause for 2 seconds (2000 milliseconds)
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event -> {
            // Hide the loading panel after the delay
            stage.hide();

            try {
                // Load the login panel
                Parent loginRoot = FXMLLoader.load(getClass().getResource("login_page.fxml"));

                // Set up drag functionality for the login panel
                loginRoot.setOnMousePressed(mouseEvent -> {
                    xOffset = mouseEvent.getSceneX();
                    yOffset = mouseEvent.getSceneY();
                });

                loginRoot.setOnMouseDragged(mouseEvent -> {
                    stage.setX(mouseEvent.getScreenX() - xOffset);
                    stage.setY(mouseEvent.getScreenY() - yOffset);
                });

                // Create a new scene with the login panel and show it on stage
                Scene loginScene = new Scene(loginRoot);
                stage.setScene(loginScene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        delay.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
