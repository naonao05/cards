package com.example.cards.pinochle;

/**
 * Defines the API for a deck of cards.
 * Used for extensibility for other types of decks that you may want to add later.
 */
public interface Deck {

    public void shuffle();

    public void cut(int index);

    public Card deal();

    public Card turnOver();

    public int search(Card card);

    public void newOrder(Deck cards);

    public int size();

}
