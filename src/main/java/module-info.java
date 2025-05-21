module com.example.tarot {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.example.tarot to javafx.fxml;
    exports com.example.tarot;
}