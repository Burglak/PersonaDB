package com.example.personadb.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class LoginPageController {
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    private Pane content_area;

    @FXML
    private void openRegistration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("register_page.fxml"));
        //content_area.getChildren().clear();
        //content_area.getChildren().removeAll();
        //content_area.getChildren().setAll(root);
    }
}
