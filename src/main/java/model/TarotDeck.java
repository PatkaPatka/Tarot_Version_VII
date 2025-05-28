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
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("tarot_deck.json"))
        {
            cards = mapper.readValue(is, new TypeReference<List<TarotCard>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            cards = new ArrayList<>();
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
    public List<TarotCard> drawSpread(int count) {
        return new ArrayList<>(cards.subList(0, count));
    }
}
