package com.example.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        implements Deck {

    List<Card> cards;

    public StandardDeck() {
        this.cards = newDeck();
    }

    public List<Card> getDeck() {
        return this.cards;
    }

    /**
     * Shuffles this deck of cards.
     */
    @Override
    public void shuffle() {
        // TODO implement shuffle
    }

    /**
     * Quick and dirty way to do a split.  There are more elegant ways using partitions and
     * generics.
     *
     * @param index
     */
    @Override
    public void cut(int index) {

        List<Card> top = this.cards.subList(0, index);
        List<Card> bottom = this.cards.subList(index, this.cards.size());

        this.cards.clear();

        this.cards.addAll(bottom);
        this.cards.addAll(top);

    }

    /**
     * Removes the card at the top.
     *
     * @return
     */
    @Override
    public Card deal() {
        return this.cards.remove(0);
    }

    /**
     * Gets the card at the top without removing it.
     *
     * @return
     */
    @Override
    public Card turnOver() {
        return this.cards.get(0);
    }

    /**
     * Returns the index of the given card.
     *
     * @param card
     * @return
     */
    @Override
    public int search(Card card) {
        return this.cards.indexOf(card);
    }

    /**
     * This method works because the cards are comparable.
     * Sort order is determined by the ordinality of the two
     * enums used for the cards suit and face values.
     *
     * @param cards
     */
    @Override
    public void newOrder(Deck cards) {
        Collections.sort(this.cards);
    }

    @Override public int size() {
        return this.cards.size();
    }

    /**
     * Generates new unshuffled deck of cards.
     *
     * @return deck of cards
     */
    private List<Card> newDeck() {

        List<Card> newDeck = new ArrayList<>();

        Arrays.stream(Suit.values()).forEach(suit -> {

            Arrays.stream(FaceValue.values()).map(faceValue -> new Card(suit, faceValue)).forEach(newDeck::add);

        });

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
