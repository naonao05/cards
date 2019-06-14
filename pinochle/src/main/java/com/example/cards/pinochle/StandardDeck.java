package com.example.cards.pinochle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray Hedgecock on 4/7/2017.
 * <p>
 * This could benefit from using an abstract class as there are a lot of common method
 * implementations between deck types. Ran out of time to implement abstract class.
 *
 * @author Ray Hedgecock
 * @since 1.0.0
 */
public class StandardDeck
        extends AbstractDeck {

    List<Card> cards;

    public StandardDeck() {
        this.cards = newDeck();
    }


    /**
     * Generates new unshuffled deck of cards.
     *
     * @return deck of cards
     */
    private List<Card> newDeck() {

        List<Card> newDeck = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (FaceValue faceValue : StandardFaceValue.values()) {
                newDeck.add(new Card(suit, faceValue));
            }
        }
        return newDeck;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StandardDeck{");
        sb.append("cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}
