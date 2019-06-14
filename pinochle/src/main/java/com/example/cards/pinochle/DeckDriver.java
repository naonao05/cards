package com.example.cards.pinochle;

/**
 * Driver class to demonstrate the use of the deck.
 */
public class DeckDriver {

    public static void main(String[] args) {

        Deck cards = new PinochleDeck();

        System.out.println("\nNew Deck:");
        displayDeck(cards);

        cards.shuffle();
        System.out.println("Shuffled: ");
        displayDeck(cards);

        System.out.println("\nTop card dealt:");
        System.out.println(cards.deal());

        System.out.println("\nCurrent deck state: ");
        displayDeck(cards);

        System.out.println("\nTop card displayed: ");
        System.out.println(cards.turnOver());

        System.out.println("\nCurrent deck state: ");
        displayDeck(cards);
        
        cards.cut(cards.size() / 2);
        System.out.println("\nCut deck:");
        displayDeck(cards);

        System.out.println("\nCurrent deck state: ");
        displayDeck(cards);

    }

    private static void displayDeck(Deck cards) {
        System.out.println(cards);
    }

}
