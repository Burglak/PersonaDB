package com.example.personadb;

import com.example.personadb.controller.LoadingPanel;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class App extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        stage.initStyle(StageStyle.UNDECORATED); //remove title bar
        // Load jand show the loading panel
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loading_panel.fxml"));
        Parent loadingRoot = loader.load();
        Scene loadingScene = new Scene(loadingRoot);
        stage.setScene(loadingScene);
        stage.show();

        Thread thread = new Thread(() -> {
            Database database = new Database();
        });
        thread.start();

        LoadingPanel loadingPanel = loader.getController();
        loadingPanel.startLoading();

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
