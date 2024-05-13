package com.example.personadb.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LeaderboardController {
    @FXML
    private Pane content_area;

    @FXML
    private void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/personadb/user_menu.fxml"));


        content_area.getScene().setRoot(root);
    }
}
