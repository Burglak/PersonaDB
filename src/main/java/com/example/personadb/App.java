package com.example.personadb;

import com.example.personadb.model.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage stage) throws Exception {
        //Person person = new Person("john123", "password123", "John Doe", "john@example.com", "standard", 500, 0, 100, 100);
        //Persona persona = new Persona("Izanagi", "chariot", 3, 4, 5, 6, 7, 8);
        //PersonPersona personPersona = new PersonPersona(1, 2, 1);
        //PersonaAffinity personaAffinity = new PersonaAffinity(2, 2, "weakness");

//        Configuration cfg = new Configuration().configure();
//
//        // add annotated classes
//        cfg.addAnnotatedClass(Person.class);
//        cfg.addAnnotatedClass(Persona.class);
//        cfg.addAnnotatedClass(Affinity.class);
//        cfg.addAnnotatedClass(Skill.class);
//        cfg.addAnnotatedClass(PersonPersona.class);
//        cfg.addAnnotatedClass(PersonPersonaSkill.class);
//        cfg.addAnnotatedClass(PersonaAffinity.class);

//        SessionFactory sf = cfg.configure().buildSessionFactory();
//        Session session = sf.openSession();
//        Transaction tx = session.beginTransaction();
//        tx.commit();
        stage.initStyle(StageStyle.UNDECORATED); //remove title bar
        Parent root = FXMLLoader.load(getClass().getResource("login_page.fxml"));
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                xOffset = mouseEvent.getSceneX();
                yOffset = mouseEvent.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setX(mouseEvent.getScreenX() - xOffset);
                stage.setY(mouseEvent.getScreenY() - yOffset);
            }
        });

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
