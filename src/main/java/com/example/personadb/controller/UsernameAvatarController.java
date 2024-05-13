package com.example.personadb.controller;

import com.example.personadb.App;
import com.example.personadb.Database;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsernameAvatarController implements Initializable {
    @FXML
    private Button avatar1;
    @FXML
    private Button avatar2;
    @FXML
    private Button avatar3;
    @FXML
    private Button avatar4;
    @FXML
    private Button avatar5;
    @FXML
    private Button avatar6;
    @FXML
    private Button avatar7;
    @FXML
    private Button avatar8;
    @FXML
    private Button avatar9;
    @FXML
    private Button avatar10;

    @FXML
    private TextField username;

    @FXML
    private Pane content_area;

    private int avatar = 0;
    public void next(ActionEvent actionEvent) throws IOException {
        if(avatar != 0 && !username.getText().isEmpty()) {
            Database.getPerson().setUsername(username.getText());
            Database.updatePerson(Database.getPerson());



            Parent root = FXMLLoader.load(getClass().getResource("/com/example/personadb/user_menu.fxml"));

            content_area.getScene().setRoot(root);
        }
    }

    @FXML
    private void selectAvatar(ActionEvent event) {
        avatar1.setLayoutY(248);
        avatar2.setLayoutY(248);
        avatar3.setLayoutY(248);
        avatar4.setLayoutY(248);
        avatar5.setLayoutY(248);
        avatar6.setLayoutY(349);
        avatar7.setLayoutY(349);
        avatar8.setLayoutY(349);
        avatar9.setLayoutY(349);
        avatar10.setLayoutY(349);

        if(event.getSource() == avatar1) {
            avatar = 1;
            Database.getPerson().setAvatar(1);
            avatar1.setLayoutY(avatar1.getLayoutY() - 15);
        }
        else if(event.getSource() == avatar2) {
            avatar = 2;
            Database.getPerson().setAvatar(2);
            avatar2.setLayoutY(avatar2.getLayoutY() - 15);
        }
        else if(event.getSource() == avatar3) {
            avatar = 3;
            Database.getPerson().setAvatar(3);
            avatar3.setLayoutY(avatar3.getLayoutY() - 15);
        }
        else if(event.getSource() == avatar4) {
            avatar = 4;
            Database.getPerson().setAvatar(4);
            avatar4.setLayoutY(avatar4.getLayoutY() - 15);
        }
        else if(event.getSource() == avatar5) {
            avatar = 5;
            Database.getPerson().setAvatar(5);
            avatar5.setLayoutY(avatar5.getLayoutY() - 15);
        }
        else if(event.getSource() == avatar6) {
            avatar = 6;
            Database.getPerson().setAvatar(6);
            avatar6.setLayoutY(avatar6.getLayoutY() - 15);
        }
        else if(event.getSource() == avatar7) {
            avatar = 7;
            Database.getPerson().setAvatar(7);
            avatar7.setLayoutY(avatar7.getLayoutY() - 15);
        }
        else if(event.getSource() == avatar8) {
            avatar = 8;
            Database.getPerson().setAvatar(8);
            avatar8.setLayoutY(avatar8.getLayoutY() - 15);
        }
        else if(event.getSource() == avatar9) {
            avatar = 9;
            Database.getPerson().setAvatar(9);
            avatar9.setLayoutY(avatar9.getLayoutY() - 15);
        }
        else if(event.getSource() == avatar10) {
            avatar = 10;
            Database.getPerson().setAvatar(10);
            avatar10.setLayoutY(avatar10.getLayoutY() - 15);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        avatar1.setLayoutY(248);
        avatar2.setLayoutY(248);
        avatar3.setLayoutY(248);
        avatar4.setLayoutY(248);
        avatar5.setLayoutY(248);
        avatar6.setLayoutY(349);
        avatar7.setLayoutY(349);
        avatar8.setLayoutY(349);
        avatar9.setLayoutY(349);
        avatar10.setLayoutY(349);
    }
}
