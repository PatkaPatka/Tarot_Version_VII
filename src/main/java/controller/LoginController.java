package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.io.IOException;

/**
 * Controller für den Anmeldebildschirm, auf dem Benutzer ihren Vor- und Nachnamen sowie ihr Alter eingeben.
 * Berechnet die Anzahl der Kartenmischungen basierend auf den ASCII-Werten der Eingabe.
 */
public class LoginController {
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField ageField;

    /**
     * Diese Methode wird aufgerufen, wenn der Benutzer auf "Continue" klickt.
     * Sie überprüft die Eingaben und berechnet die Anzahl der Kartenmischungen.
     * Wenn die Eingaben gültig sind, wechselt sie zur Hauptansicht.
     */
    @FXML
    public void handleContinue() throws IOException{
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String ageStr = ageField.getText().trim();

        /**
         * versichert dass alle Felder ausgefüllt sind, sodass die individuelle Shufflefunktion ablaufen kann
         */
        if(firstName.isEmpty() || lastName.isEmpty() || ageStr.isEmpty()) {
            // Show an error message or alert
            System.out.println("Fehlermeldung: Bitte füllen Sie alle Felder aus.");
            return;
        }

        /**
         * versichert dass das Alter eine Zahl ist und größer als 0
         */
        try {
            int age = Integer.parseInt(ageStr);
            if (age <= 0) {
                showAlert("Fehler", "Bitte geben Sie ein gültiges Alter ein.");
                return;
            }

            int shuffleCount = calculateShuffleCount(firstName, lastName, age);
            System.out.println("Kalkulierter shuffle count: " + shuffleCount); // Debug

            // Load main view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainView.fxml"));
            Parent root = loader.load();

            // Get controller and set shuffle count
            MainController mainController = loader.getController();
            mainController.setShuffleCount(shuffleCount);

            // Switch scene
            Stage stage = (Stage) firstNameField.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.setTitle("Tarot Reading - " + firstName + " " + lastName);
        } catch (NumberFormatException e) {
            showAlert("Fehlermeldung", "Bitte geben Sie ein gültiges Alter ein.");
        }
    }

    /**
     * Zeigt eine Fehlermeldung in einem Alert-Fenster an.
     *
     * @param title   Der Titel des Alerts
     * @param message Die Fehlermeldung, die angezeigt werden soll
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Berechnet die Anzahl der Kartenmischungen basierend auf den ASCII-Werten des Vornamens, Nachnamens und Alters.
     * Stellt sicher, dass mindestens 1 Shuffle durchgeführt wird.
     *
     * @param firstName Der Vorname des Benutzers
     * @param lastName  Der Nachname des Benutzers
     * @param age       Das Alter des Benutzers
     * @return Die berechnete Anzahl der Shuffles
     */
    private int calculateShuffleCount(String firstName, String lastName, int age) {
        int sum = 0;

        // Calculate ASCII sum of first name
        for (char c : firstName.toCharArray()) {
            sum += (int) c;
        }

        // Calculate ASCII sum of last name
        for (char c : lastName.toCharArray()) {
            sum += (int) c;
        }

        // Add age
        sum += age;

        // Ensure at least 1 shuffle
        return Math.max(1, sum);
    }
}
