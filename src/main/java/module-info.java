module com.example.personadb {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;



    opens com.example.personadb to javafx.fxml, org.hibernate.orm.core;
    opens com.example.personadb.model to org.hibernate.orm.core;
    exports com.example.personadb;
}