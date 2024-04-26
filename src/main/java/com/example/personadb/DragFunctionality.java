package com.example.personadb;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DragFunctionality {
    private static double xOffset;
    private static double yOffset;
    public static void makeDraggable(Pane pane, Stage stage) {
        pane.setOnMousePressed(mouseEvent -> {
            xOffset = mouseEvent.getSceneX();
            yOffset = mouseEvent.getSceneY();
        });

        pane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - xOffset);
            stage.setY(mouseEvent.getScreenY() - yOffset);
        });
    }
}
