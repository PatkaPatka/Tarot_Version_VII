package controller;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import model.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.util.List;
import javafx.animation.RotateTransition;
import javafx.animation.Interpolator;
import javafx.util.Duration;
import javafx.scene.transform.Rotate;

/**
 * Hauptcontroller für die Tarot-Leseanwendung.
 * Verwaltet die Benutzeroberfläche, die Kartenanzeige und die Interaktion mit dem Tarotdeck.
 * Verwaltet Moduswechsel, Kartenmischen (basierend auf der berechneten Anzahl der Kartenmischungen) und die Kartenaufdeckungsfunktion.
 */
public class MainController {
    @FXML public BorderPane rootPane;
    @FXML public HBox titleBar;
    @FXML public Label time1Label, time2Label, time3Label;
    @FXML public Label meaning1Label, meaning2Label, meaning3Label;
    @FXML public ImageView card1Image, card2Image, card3Image;
    @FXML public Button modeBtn, shuffleBtn, openBtn, toggleHelpBtn;
    @FXML public SplitPane mainSplit;
    @FXML public TextArea helpText;
    @FXML public ScrollPane helpPanel;

    private boolean isHelpVisible = true;
    private double xOffset = 0;
    private double yOffset = 0;
    private int shuffleCount = 1;

    public TarotDeck tarotDeck;
    public ReadingMode currentMode;
    public List<TarotCard> currentSpread;

    public void initialize() {

        tarotDeck = new TarotDeck();
        currentMode = ReadingMode.past_present_future;
        updateModeLabels();

        helpText.setText("How to play:\n\n" +
                "1. Wählen Sie zunächst einen Modus, klicken Sie auf die Schaltfläche \"mode\", um den Modus zu ändern\n" +
                "Vergangenheit, Gegenwart, Zukunft\n" +
                "Du, Sie, Beziehung\n" +
                "Situation, Hindernis, Lösung\n" +
                "Geist, Körper, Seele\n" +
                "Pfad I, Pfad II, Pfad III\n" +
                "Akzeptieren, Annehmen, Loslassen\n\n" +
                "2. Mischen Sie die Karten (klicken Sie auf die Schaltfläche \"shuffle\").\n\n" +
                "3. Öffnen Sie die Karten (klicken Sie auf die Schaltfläche \"open\").\n\n" +
                "4. Deuten Sie die Karten.\n\n");

        Image cardBack = new Image(getClass().getResourceAsStream("/images/resource/card_back.jpg"));
        initializeCard(card1Image, cardBack);
        initializeCard(card2Image, cardBack);
        initializeCard(card3Image, cardBack);

        // Set initial card sizes
        updateCardSizes(120, 190, 14, 12);

        // Setup window dragging
        if (titleBar != null) {
            titleBar.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            titleBar.setOnMouseDragged(event -> {
                Stage stage = (Stage) titleBar.getScene().getWindow();
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });
        }

        mainSplit.setDividerPosition(0, 0.85);

        // Add listener for scene changes
        rootPane.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                setupWindowListeners(newScene);
            }
        });
    }

    private void setupWindowListeners(Scene scene) {
        // Wait for window to be set
        scene.windowProperty().addListener((obs, oldWindow, newWindow) -> {
            if (newWindow != null) {
                Stage stage = (Stage) newWindow;

                // Listen to window maximized state
                stage.maximizedProperty().addListener((obsMax, oldMax, newMax) -> {
                    if (newMax) {
                        updateCardSizes(180, 280, 16, 14);
                    } else {
                        updateCardSizes(120, 190, 14, 12);
                    }
                });

                // Also listen to window size changes
                stage.widthProperty().addListener((obsWidth, oldWidth, newWidth) -> {
                    if (stage.isMaximized()) {
                        updateCardSizes(180, 280, 16, 14);
                    }
                });

                stage.heightProperty().addListener((obsHeight, oldHeight, newHeight) -> {
                    if (stage.isMaximized()) {
                        updateCardSizes(180, 280, 16, 14);
                    }
                });
            }
        });
    }

    /**
     * Aktualisiert die Kartengrößen und Schriftgrößen basierend auf der Fenstergröße.
     * @param width Breite der Karten
     * @param height Höhe der Karten
     * @param labelSize Schriftgröße für die Zeitlabels
     * @param meaningSize Schriftgröße für die Bedeutungslabels
     */
    private void updateCardSizes(double width, double height, double labelSize, double meaningSize) {
        card1Image.setFitWidth(width);
        card1Image.setFitHeight(height);
        card2Image.setFitWidth(width);
        card2Image.setFitHeight(height);
        card3Image.setFitWidth(width);
        card3Image.setFitHeight(height);

        // Update font sizes
        String labelStyle = String.format("-fx-font-size: %.0fpx;", labelSize);
        String meaningStyle = String.format("-fx-font-size: %.0fpx;", meaningSize);

        time1Label.setStyle(labelStyle);
        time2Label.setStyle(labelStyle);
        time3Label.setStyle(labelStyle);
        meaning1Label.setStyle(meaningStyle);
        meaning2Label.setStyle(meaningStyle);
        meaning3Label.setStyle(meaningStyle);
    }

    /**
     * Initialisiert die Kartenbilder mit den Standardparametern.
     * @param imageView Das ImageView, das die Karte anzeigen soll
     * @param image Das Bild der Karte
     */
    private void initializeCard(ImageView imageView, Image image) {
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
    }

    /**
     * Behandelt das Klicken auf die Schaltfläche "Hilfe" und wechselt die Sichtbarkeit des Hilfebereichs.
     * Wenn der Hilfebereich sichtbar ist, wird er ausgeblendet und umgekehrt.
     */
    @FXML
    public void toggleHelp() {
        isHelpVisible = !isHelpVisible;
        if (isHelpVisible) {
            mainSplit.setDividerPosition(0, 0.85);
            helpPanel.setVisible(true);
        } else {
            mainSplit.setDividerPosition(0, 1.0);
            helpPanel.setVisible(false);
        }
    }

    /**
     * Behandelt das Klicken auf die Schaltfläche "Modus" und wechselt den aktuellen Lesemodus.
     * Aktualisiert die Labels entsprechend dem neuen Modus.
     */
    @FXML
    public void handleModeChange() {
        ReadingMode[] modes = ReadingMode.values();
        currentMode = modes[(currentMode.ordinal() + 1) % modes.length];
        updateModeLabels();
    }

    /**
     * Aktualisiert die Labels für die Positionen basierend auf dem aktuellen Lesemodus.
     * Setzt die Texte der Labels für die drei Positionen des aktuellen Modus.
     */
    public void updateModeLabels() {
        String[] positions = currentMode.getPositions();
        time1Label.setText(positions[0]);
        time2Label.setText(positions[1]);
        time3Label.setText(positions[2]);
    }

    /**
     * setzt den Shuffle-Zähler auf die angegebene Anzahl.
     * @param shuffleCount
     */
    public void setShuffleCount(int shuffleCount) {
        this.shuffleCount = Math.max(1, shuffleCount);
        System.out.println("Shuffle count set to: " + this.shuffleCount); //Debugging output
    }

    /**
     * Behandelt das Klicken auf die Schaltfläche "Shuffle" und führt die Mischeoperation durch.
     * Setzt das Deck zurück und mischt es die angegebene Anzahl von Malen.
     * Initialisiert die Kartenbilder mit dem Kartenrückseitenbild und leert die Bedeutungslabels.
     */
    @FXML
    public void handleShuffle() {
        System.out.println("Performing " + shuffleCount + " shuffles."); //Debugging output

        //reset the deck before shuffling
        tarotDeck.resetDeck();

        //perform the personalized number of shuffles
        for (int i = 0; i < shuffleCount; i++){
            tarotDeck.shuffle();
        }

        Image cardBack = new Image(getClass().getResourceAsStream("/images/resource/card_back.jpg"));
        initializeCard(card1Image, cardBack);
        initializeCard(card2Image, cardBack);
        initializeCard(card3Image, cardBack);
        meaning1Label.setText("");
        meaning2Label.setText("");
        meaning3Label.setText("");
    }

    /**
     * Behandelt das Klicken auf die Schaltfläche "Open" und deckt die Karten auf.
     * Zieht drei Karten aus dem Deck und zeigt sie an.
     * Führt die Flip-Animation für jede Karte aus und aktualisiert die Bedeutungslabels.
     */
    @FXML
    public void handleOpen() {
        currentSpread = tarotDeck.drawSpread(3);
        flipCard(card1Image, meaning1Label, currentSpread.get(0));
        flipCard(card2Image, meaning2Label, currentSpread.get(1));
        flipCard(card3Image, meaning3Label, currentSpread.get(2));
    }

    /**
     * Führt die Flip-Animation für die angegebene Karte aus.
     * @param imageView
     * @param meaningLabel
     * @param card
     */
    private void flipCard(ImageView imageView, Label meaningLabel, TarotCard card) {
        // Completes the flip from 90° to 0°
        RotateTransition flipIn = new RotateTransition(Duration.millis(250), imageView);
        flipIn.setAxis(Rotate.Y_AXIS);
        flipIn.setFromAngle(90);
        flipIn.setToAngle(0);
        flipIn.setInterpolator(Interpolator.LINEAR);

        try {
            Image image = new Image(getClass().getResourceAsStream(card.getImagePath()));
            imageView.setImage(image);
            imageView.setScaleY(card.getReversed() ? -1 : 1);

            meaningLabel.setText(card.getName() + (card.getReversed() ? " (Reversed)" : "") +
                    "\n" + card.getMeaning());
        } catch (Exception e) {
            e.printStackTrace();
        }

        flipIn.play();
    }
}