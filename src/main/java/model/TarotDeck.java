package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TarotDeck {
    private List<TarotCard> cards;
    private List<TarotCard> drawnCards;

    public TarotDeck(){
        initializeDeck();
        drawnCards = new ArrayList<>();
    }

    private void initializeDeck(){
        cards = new ArrayList<>();
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resource/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
        cards.add(new TarotCard("The Fool", "New Beginning, Innocence, Spontaneity", "Recklessness, Fearlessness, Risks", "/resources/The Fool upright.png"));
    }
}
