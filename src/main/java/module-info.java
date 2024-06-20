module com.example.db {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens com.example.db to javafx.fxml;
    opens com.example.db.controllers to javafx.fxml;
    exports com.example.db;
    exports com.example.db.controllers;
    opens com.example.db.entities to org.hibernate.orm.core, javafx.base;
    exports com.example.db.entities;
}
