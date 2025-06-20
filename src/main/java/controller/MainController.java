package controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import model.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.util.List;

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
    private void initializeCard(ImageView imageView, Image image) {
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
    }

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

    @FXML
    public void handleModeChange() {
        ReadingMode[] modes = ReadingMode.values();
        currentMode = modes[(currentMode.ordinal() + 1) % modes.length];
        updateModeLabels();
    }

    public void updateModeLabels() {
        String[] positions = currentMode.getPositions();
        time1Label.setText(positions[0]);
        time2Label.setText(positions[1]);
        time3Label.setText(positions[2]);
    }

    @FXML
    public void handleShuffle() {
        tarotDeck.shuffle();
        Image cardBack = new Image(getClass().getResourceAsStream("/images/resource/card_back.jpg"));
        initializeCard(card1Image, cardBack);
        initializeCard(card2Image, cardBack);
        initializeCard(card3Image, cardBack);
        meaning1Label.setText("");
        meaning2Label.setText("");
        meaning3Label.setText("");
    }

    @FXML
    public void handleOpen() {
        currentSpread = tarotDeck.drawSpread(3);
        displayCard(card1Image, meaning1Label, currentSpread.get(0));
        displayCard(card2Image, meaning2Label, currentSpread.get(1));
        displayCard(card3Image, meaning3Label, currentSpread.get(2));
    }

    public void displayCard(ImageView imageView, Label meaningLabel, TarotCard card) {
        try {
            Image image = new Image(getClass().getResourceAsStream(card.getImagePath()));
            imageView.setImage(image);
            imageView.setRotate(card.getReversed() ? 180 : 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        meaningLabel.setText(card.getName() + (card.getReversed() ? " (Reversed)" : "") +
                "\n" + card.getMeaning());
    }
}