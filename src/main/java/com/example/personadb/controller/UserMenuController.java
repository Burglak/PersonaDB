package com.example.personadb.controller;

import com.example.personadb.App;
import com.example.personadb.Database;
import com.example.personadb.DragFunctionality;
import com.example.personadb.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserMenuController implements Initializable {
    @FXML
    private AnchorPane anchor;
    @FXML
    private Pane content_area;
    @FXML
    private ImageView avatar;
    @FXML
    private Label username;
    @FXML
    private Label stats;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.primaryStage.setHeight(400);
        App.primaryStage.setWidth(600);
        DragFunctionality.makeDraggable(anchor, App.primaryStage);

        int avatarID = Database.getPerson().getAvatar();
        try {
            switch (avatarID) {
                case 1:
                    avatar.setImage(new Image(getClass().getResource("/avatars/yu.jpg").toURI().toString()));
                    break;
                case 2:
                    avatar.setImage(new Image(getClass().getResource("/avatars/yosuke.jpg").toURI().toString()));
                    break;
                case 3:
                    avatar.setImage(new Image(getClass().getResource("/avatars/chie.jpg").toURI().toString()));
                    break;
                case 4:
                    avatar.setImage(new Image(getClass().getResource("/avatars/yukiko.jpg").toURI().toString()));
                    break;
                case 5:
                    avatar.setImage(new Image(getClass().getResource("/avatars/aigis.jpg").toURI().toString()));
                    break;
                case 6:
                    avatar.setImage(new Image(getClass().getResource("/avatars/akechi.jpg").toURI().toString()));
                    break;
                case 7:
                    avatar.setImage(new Image(getClass().getResource("/avatars/joker.jpg").toURI().toString()));
                    break;
                case 8:
                    avatar.setImage(new Image(getClass().getResource("/avatars/mona.jpg").toURI().toString()));
                    break;
                case 9:
                    avatar.setImage(new Image(getClass().getResource("/avatars/makoto.jpg").toURI().toString()));
                    break;
                case 10:
                    avatar.setImage(new Image(getClass().getResource("/avatars/mitsuru.png").toURI().toString()));
                    break;
            }
        }
        catch (URISyntaxException e){
            e.printStackTrace();
        }
        username.setText(Database.getPerson().getUsername());
        stats.setText(Database.getPerson().getHp() + "HP / " + Database.getPerson().getSp() + "SP");

    }

    @FXML
    private void showPersona(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/personadb/persona_panel.fxml"));


        content_area.getScene().setRoot(root);
    }
    @FXML
    private void showLeaderboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/personadb/leaderboard_page.fxml"));


        content_area.getScene().setRoot(root);
    }

}
