package com.example.personadb.controller;

import com.example.personadb.Database;
import com.example.personadb.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class RegisterPageController {
    @FXML
    private Pane content_area;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    @FXML
    private void openLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/personadb/login_page.fxml"));
        content_area.getScene().setRoot(root);
    }
    private void openLogin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/personadb/login_page.fxml"));
        content_area.getScene().setRoot(root);
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleRegistration(ActionEvent event) throws IOException {
        //hashing password
        String sha256hex = Hashing.sha256()
                .hashString(password.getText(), StandardCharsets.UTF_8)
                .toString();

        Person person = new Person();
        person.setUsername(username.getText());
        person.setEmail(email.getText());
        person.setPassword(sha256hex);
        person.setAccountType("user");
        person.setLogin(person.getUsername());
        person.setBalance(1000);
        person.setRanking(0);
        person.setHp(0);
        person.setAvatar(0);
        boolean registered = Database.registerPerson(person);
        if(registered) {
            openLogin();
        }
    }
}
