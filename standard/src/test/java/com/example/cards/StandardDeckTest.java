package com.example.cards;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StandardDeckTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shuffle() {

        Deck control = new StandardDeck();
        Deck shuffled = new StandardDeck();

        shuffled.shuffle();

        assertNotEquals(control.turnOver(), shuffled.turnOver());

    }

    @Test
    public void cut() {

        Deck control = new StandardDeck();
        Deck cut = new StandardDeck();

        cut.cut(1);

        Card controlCard = control.turnOver();
        Card actualCard = ((StandardDeck) cut).getDeck().get(((StandardDeck) cut).getDeck().size() - 1);
        assertEquals(controlCard, actualCard);
        assertEquals(((StandardDeck) control).getDeck().size(), ((StandardDeck) cut).getDeck().size());

    }

    @Test
    public void deal() {

        Deck control = new StandardDeck();
        Deck deal = new StandardDeck();

        assertEquals(control.turnOver(), deal.deal());
        assertNotEquals(control.turnOver(), deal.turnOver());

    }

    @Test
    public void turnOver() {

        Deck control = new StandardDeck();

        assertEquals(control.turnOver(), ((StandardDeck) control).getDeck().get(0));

    }
}
