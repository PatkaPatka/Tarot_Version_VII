package controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.shape.Circle;
import model.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import java.util.List;

public class MainController {
    @FXML private Circle closeBtn, minimizeBtn, hideBtn;
    @FXML private Label time1Label, time2Label, time3Label;
    @FXML private Label meaning1Label, meaning2Label, meaning3Label;
    @FXML private ImageView card1Image, card2Image, card3Image;
    @FXML private Button modeBtn, shuffleBtn, openBtn, helpBtn;

    private TarotDeck tarotDeck;
    private ReadingMode currentMode;
    private List<TarotCard> currentSpread;

    public void Initialize() {
        tarotDeck = new TarotDeck();
        currentMode = ReadingMode.past_present_future;
        updateModeLabels();

        Image cardBack = new Image(getClass().getResourceAsStream("/images/resource/card_back.jpg"));
        card1Image.setImage(cardBack);
        card2Image.setImage(cardBack);
        card3Image.setImage(cardBack);
    }
    @FXML
    private void handleModeChange() {
        ReadingMode[] modes = ReadingMode.values();
        currentMode = modes[(currentMode.ordinal() + 1) % modes.length];
        updateModeLabels();
    }
    private void updateModeLabels() {
        String[] positions = currentMode.getPositions();
        time1Label.setText(positions[0]);
        time2Label.setText(positions[1]);
        time3Label.setText(positions[2]);
    }

    @FXML
    private void handleShuffle() {
        tarotDeck.shuffle();
        Image card_back = new Image(getClass().getResourceAsStream("/images/resource/card_back.jpg"));
        card1Image.setImage(card_back);
        card2Image.setImage(card_back);
        card3Image.setImage(card_back);
        meaning1Label.setText("");
        meaning2Label.setText("");
        meaning3Label.setText("");
    }

    @FXML
    private void handleOpenCards() {
        currentSpread = tarotDeck.drawSpread(3);

        displayCard(card1Image, meaning1Label, currentSpread.get(0));
        displayCard(card2Image, meaning2Label, currentSpread.get(1));
        displayCard(card3Image, meaning3Label, currentSpread.get(2));
    }

    private void displayCard(ImageView imageView, Label meaningLabel, TarotCard card) {
        Image image = new Image(getClass().getResourceAsStream(card.getImagePath()));
        imageView.setImage(image);
        meaningLabel.setText(card.getName() + ": " + card.getMeaning());
    }

    @FXML
    private void showHelp() {
        Stage helpStage = new Stage();
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(15));

        TextArea helpText = new TextArea();
        helpText.setEditable(false);
        helpText.setWrapText(true);
        helpText.setText("How to play:\n\n" +
                "1. Wählen Sie zunächst einen Modus, klicken Sie auf die Schaltfläche \"Modus\", um den Modus zu ändern\n" +
                "Vergangenheit, Gegenwart, Zukunft\n" +
                "Du, Sie, Beziehung\n" +
                "Situation, Hindernis, Lösung\n" +
                "Geist, Körper, Seele\n" +
                "Pfad I, Pfad II, Pfad III\n" +
                "Akzeptieren, Annehmen, Loslassen\n\n" +
                "2. Mischen Sie die Karten (klicken Sie auf die Schaltfläche \"Mischen\").\n" +
                "3. Öffnen Sie die Karten (klicken Sie auf die Schaltfläche \"Öffnen\").\n" +
                "4. Deuten Sie die Karten.\n\n");

        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> helpStage.close());

        root.getChildren().addAll(helpText, closeBtn);
        Scene scene = new Scene(root, 400, 300);
        helpStage.setScene(scene);
        helpStage.setTitle("How to play");
        helpStage.show();
    }

    @FXML
    private void handleClose() {
        ((Stage) closeBtn.getScene().getWindow()).close();
    }

    @FXML
    private void handleMinimize() {
        ((Stage) minimizeBtn.getScene().getWindow()).setIconified(true);
    }

    @FXML
    private void handleHide() {
        ((Stage) hideBtn.getScene().getWindow()).setIconified(true);
        ((Stage) hideBtn.getScene().getWindow()).hide();
    }
}
