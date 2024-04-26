module com.example.personadb {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires com.google.common;


    opens com.example.personadb to javafx.fxml, org.hibernate.orm.core;
    opens com.example.personadb.model to org.hibernate.orm.core;
    exports com.example.personadb;
    exports com.example.personadb.controller;
    opens com.example.personadb.controller to javafx.fxml, org.hibernate.orm.core;
}