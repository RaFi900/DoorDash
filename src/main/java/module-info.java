module org.example.doordash {
    requires javafx.controls;
    requires javafx.fxml;
    requires  java.sql;
    requires de.jensd.fx.glyphs.fontawesome;

    opens org.example.doordash to javafx.fxml;
    exports org.example.doordash;

    opens org.example.doordash.model to javafx.fxml;
    exports org.example.doordash.model;

    exports org.example.doordash.service;
    opens org.example.doordash.service to javafx.fxml;

    exports org.example.doordash.controller;
    opens org.example.doordash.controller to javafx.fxml;

}
