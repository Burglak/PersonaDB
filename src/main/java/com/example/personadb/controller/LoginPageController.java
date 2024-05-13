package com.example.personadb.controller;

import com.example.personadb.Database;
import com.example.personadb.model.Person;
import com.google.common.hash.Hashing;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import com.google.common.hash.Hashing;
import javafx.util.Duration;

import java.nio.charset.StandardCharsets;

public class LoginPageController {
    @FXML
    public Label errorLabel;
    @FXML
    private Pane content_area;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    private void openRegistration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/personadb/register_page.fxml"));
        content_area.getChildren().removeAll();
        content_area.getChildren().setAll(root);
    }

    private void openCeratingCharaceter() {
        try{
            Parent root;
            if(Database.getPerson().getHp() != 0 || Database.getPerson().getSp() != 0 || Database.getPerson().getAvatar() != 0)
                root = FXMLLoader.load(getClass().getResource("/com/example/personadb/user_menu.fxml"));
            else
                root = FXMLLoader.load(getClass().getResource("/com/example/personadb/create_character_page.fxml"));

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        content_area.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogin(ActionEvent event) throws InterruptedException {
        Person person = new Person();
        person.setLogin(username.getText());
        //hashing password
        String sha256hex = Hashing.sha256()
                .hashString(password.getText(), StandardCharsets.UTF_8)
                .toString();
        person.setPassword(sha256hex);
        boolean loggedIn = Database.loginPerson(person);
        if (loggedIn) {
            errorLabel.setText("");
            openCeratingCharaceter();
        }
        else{
            errorLabel.setText("WRONG USERNAME OR PASSWORD");
        }
    }
}
