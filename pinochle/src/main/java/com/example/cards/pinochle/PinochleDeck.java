package com.example.cards.pinochle;

import java.util.ArrayList;
import java.util.List;

/**
 * Pinochle deck.
 * <p>
 * This could benefit from using an abstract class as there are a lot of common method
 * implementations between deck types. Ran out of time to implement abstract class.
 */
public class PinochleDeck
        extends AbstractDeck {

    public PinochleDeck() {
        this.cards = newDeck();
    }

    /**
     * Generates new unshuffled deck of cards.
     * This deck contains 2 regular decks of cards.
     *
     * @return deck of cards
     */
    private List<Card> newDeck() {

        List<Card> newDeck = new ArrayList<>();

        // adding deck 1
        for (Suit suit : Suit.values()) {
            for (FaceValue faceValue : PinochleFaceValue.values()) {
                newDeck.add(new Card(suit, faceValue));
            }
        }

        // adding deck 2
        for (Suit suit : Suit.values()) {
            for (FaceValue faceValue : PinochleFaceValue.values()) {
                newDeck.add(new Card(suit, faceValue));
            }
        }
        return newDeck;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PinochleDeck{");
        sb.append("cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}
