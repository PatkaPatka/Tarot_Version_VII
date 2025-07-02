package com.example.tarot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


/**
 * Die Hauptanwendungsklasse, die die JavaFX-Anwendung startet.
 * Sie zeigt zunächst einen Anmeldebildschirm an, in dem Benutzer ihre persönlichen Daten eingeben.
 * Anschließend wird die Hauptoberfläche der Tarot-Lesung aufgerufen.
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/loginView.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/view/Style.css").toExternalForm());

        stage.setTitle("Tarot Reading App");
        stage.setScene(scene);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static void main(String[] args) {launch(args);}
}