package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.io.InputStream;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TarotDeck {
    private List<TarotCard> cards;
    private List<TarotCard> drawnCards;

    public TarotDeck(){
        loadDeckfromJson();
        drawnCards = new ArrayList<>();
    }

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

    public void shuffle() {
        Collections.shuffle(cards);
        Random random = new Random();
        for (TarotCard card : cards){
            card.setReserved(random.nextBoolean());
        }
    }


    public TarotCard drawCard() {
        if (cards.isEmpty()) {
            resetDeck();
        }
        TarotCard drawn = cards.remove(0);
        drawnCards.add(drawn);
        return drawn;
    }
    public void resetDeck() {
        cards.addAll(drawnCards);
        drawnCards.clear();
        shuffle();
    }

    public List<TarotCard> drawSpread(int count) {
        return new ArrayList<>(cards.subList(0, 3));
    }
}
