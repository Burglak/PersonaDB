package com.example.personadb.controller;

import com.example.personadb.App;
import com.example.personadb.Database;
import com.example.personadb.DragFunctionality;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateCharacterPageController implements Initializable {
    @FXML
    private AnchorPane anchor;
    @FXML
    private Rectangle hp;
    @FXML
    private Rectangle sp;
    @FXML
    private Label strengthLabel;
    @FXML
    private Label justiceLabel;
    @FXML
    private Label magicianLabel;
    @FXML
    private Button strengthButton;
    @FXML
    private Button justiceButton;
    @FXML
    private Button magicianButton;
    @FXML
    private Label strengthStats;
    @FXML
    private Label justiceStats;
    @FXML
    private Label magicianStats;
    @FXML
    private Text description;
    @FXML
    private Pane content_area;

    private static int character = Character.None.ordinal();


    @FXML
    private void selectStrength(ActionEvent event) {
        selectingArcanaAnimation(200, 120);
        moveButton(strengthButton, strengthLabel);
    }

    @FXML
    private void selectJustice(ActionEvent event) {
        selectingArcanaAnimation(160, 160);
        moveButton(justiceButton, justiceLabel);
    }

    @FXML
    private void selectMagician(ActionEvent event) {
        selectingArcanaAnimation(120, 200);
        moveButton(magicianButton, magicianLabel);
    }

    private void selectingArcanaAnimation(int hpWidth, int spWidth) {
        int currentHpWidth = (int) Math.round(hp.getWidth());
        int currentSpWidth = (int) Math.round(sp.getWidth());


        Timeline timelineHp = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {
            private int i = currentHpWidth + 1;

            @Override
            public void handle(ActionEvent event) {
                if (i < hpWidth) {
                    i++;
                    hp.setWidth(i);
                } else {
                    i--;
                    hp.setWidth(i);
                }

            }
        }));

        Timeline timelineSp = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {
            private int j = currentSpWidth + 1;

            @Override
            public void handle(ActionEvent actionEvent) {
                if (j < spWidth) {
                    j++;
                    sp.setWidth(j);
                } else {
                    j--;
                    sp.setWidth(j);
                }
            }
        }));
        timelineHp.setCycleCount(Math.abs(hpWidth - currentHpWidth) + 1);
        timelineSp.setCycleCount(Math.abs(spWidth - currentSpWidth) + 1);
        timelineSp.play();
        timelineHp.play();
    }

    private void moveButton(Button button, Label label) {
        strengthButton.setLayoutY(150);
        justiceButton.setLayoutY(150);
        magicianButton.setLayoutY(150);
        strengthLabel.setLayoutY(114);
        justiceLabel.setLayoutY(114);
        magicianLabel.setLayoutY(114);

        button.setLayoutY(button.getLayoutY() - 20);
        label.setLayoutY(label.getLayoutY() + 180);

        strengthStats.setText("");
        justiceStats.setText("");
        magicianStats.setText("");
        if(button == strengthButton){
            character = Character.Strength.ordinal();
            strengthStats.setText("100HP / 60SP");
            description.setText("\"The Arcana is the means by which all is revealed...\n" +
                    "Only with strength can one endure suffering and torment.\"");
        } else if(button == justiceButton){
            character = Character.Justice.ordinal();
            justiceStats.setText("80HP / 80SP");
            description.setText("\"The Arcana is the means by which all is revealed.\n" +
                    "To find the one true path, one must seek guidance amidst uncertainty...\"");
        }
        else if(button == magicianButton){
            character = Character.Magician.ordinal();
            magicianStats.setText("60HP / 100SP");
            description.setText("\"The moment man devoured the fruit of knowledge, he sealed his fate...Entrusting his future to the cards, man clings to a dim hope.Yes, the Arcana is the means by which all is revealed...Attaining one's dream requires a stern will and unfailing determination.\"");
        }
    }

    private enum Character {
        None,
        Strength,
        Justice,
        Magician
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DragFunctionality.makeDraggable(anchor, App.primaryStage);
    }

    public void next(ActionEvent event) throws IOException {
        if(character == Character.None.ordinal()){
            return;
        }

        if(character == 1){
            Database.getPerson().setHp(100);
            Database.getPerson().setSp(60);
        }
        if(character == 2){
            Database.getPerson().setHp(80);
            Database.getPerson().setSp(80);
        }
        if(character == 3){
            Database.getPerson().setHp(60);
            Database.getPerson().setSp(100);
        }

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/personadb/username_avatar_page.fxml"));

        FadeTransition fadeIn = new FadeTransition(Duration.millis(1000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        content_area.getScene().setRoot(root);
    }

    public int getCharacter(){
        return character;
    }
}
