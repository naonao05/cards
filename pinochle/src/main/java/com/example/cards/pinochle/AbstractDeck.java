package com.example.cards.pinochle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by rzf8th on 4/12/2017.
 */
public abstract class AbstractDeck
        implements Deck {

    List<Card> cards;

    public List<Card> getDeck() {
        return this.cards;
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    /**
     * Shuffles this deck of cards.
     */
    @Override
    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(this.cards, new Random(seed));
    }

    /**
     * Quick and dirty way to do a split.  There are more elegant ways using partitions and
     * generics.
     *
     * @param index
     */
    @Override
    public void cut(int index) {

        List<Card> top = new ArrayList<>();
        top.addAll(this.cards.subList(0, index));
        List<Card> bottom = new ArrayList<>();
        bottom.addAll(this.cards.subList(index, this.cards.size()));

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

    // TODO implement new toString method to display deck in a more user friendly way

}
