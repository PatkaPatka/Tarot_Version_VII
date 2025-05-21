module com.example.tarot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tarot to javafx.fxml;
    exports com.example.tarot;
}