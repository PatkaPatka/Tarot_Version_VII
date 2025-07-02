package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.InputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Stellt ein vollständiges Tarotdeck mit Funktionen zum Mischen, Ziehen und Zurücksetzen der Karten dar.
 * Lädt Kartendaten aus einer JSON-Datei und behält den Status der gezogenen Karten bei.
 */
public class TarotDeck {
    private List<TarotCard> cards;
    private List<TarotCard> drawnCards;

    /**
     * Konstruktor, der das Tarotdeck initialisiert und die Kartendaten aus der JSON-Datei lädt.
     */
    public TarotDeck(){
        loadDeckfromJson();
        drawnCards = new ArrayList<>();
    }

    /**
     * Lädt die Kartendaten aus einer JSON-Datei in das Tarotdeck.
     * Die Datei sollte im Ressourcenordner liegen und die Struktur der TarotCard-Klasse entsprechen.
     */
    private void loadDeckfromJson(){
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("tarot_cards.json"))
        {
            cards = mapper.readValue(is, new TypeReference<List<TarotCard>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            cards = new ArrayList<>();
        }
    }

    /**
     * Mischen der Karten im Deck basierend auf einem individuellen Shuffle-Count.
     * Die Karten werden zufällig angeordnet und einige Karten werden umgedreht.
     */
    public void shuffle() {
        // mischt die Karten im Deck
        Collections.shuffle(cards);

        // kehrt zufällige Karten um
        Random random = new Random();
        for (TarotCard card : cards) {
            card.setReserved(random.nextBoolean());
        }
    }


    public void resetDeck() {
        // setzt das Deck zurück, indem gezogene Karten wieder hinzugefügt werden
        if (!drawnCards.isEmpty()) {
            cards.addAll(drawnCards);
            drawnCards.clear();
            System.out.println("Deck reset with " + cards.size() + " cards"); // Debug
        }
    }

    /**
     * Zieht eine Karte aus dem Deck. Wenn das Deck leer ist, wird es zurückgesetzt.
     * Die gezogene Karte wird in der Liste der gezogenen Karten gespeichert.
     *
     * @return die gezogene TarotCard
     */
    public TarotCard drawCard() {
        if (cards.isEmpty()) {
            resetDeck();
        }
        TarotCard drawn = cards.remove(0);
        drawnCards.add(drawn);
        return drawn;
    }

    /**
     * Zieht eine Tarot-Legung, die aus drei Karten besteht.
     * Diese Methode wird für die Tarot-Lesung verwendet.
     *
     * @param count Anzahl der zu ziehenden Karten (in diesem Fall immer 3)
     * @return eine Liste von drei gezogenen TarotCards
     */
    public List<TarotCard> drawSpread(int count) {
        return new ArrayList<>(cards.subList(0, 3));
    }
}
