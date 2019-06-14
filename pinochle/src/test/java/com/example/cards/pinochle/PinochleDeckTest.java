package com.example.cards.pinochle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PinochleDeckTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shuffle() {

        Deck control = new PinochleDeck();
        Deck shuffled = new PinochleDeck();

        shuffled.shuffle();

        assertNotEquals(control.turnOver(), shuffled.turnOver());

    }

    @Test
    public void cut() {

        Deck control = new PinochleDeck();
        Deck cut = new PinochleDeck();

        cut.cut(1);

        Card controlCard = control.turnOver();
        Card actualCard = ((PinochleDeck) cut).getDeck().get(((PinochleDeck) cut).getDeck().size() - 1);
        assertEquals(controlCard, actualCard);
        assertEquals(((PinochleDeck) control).getDeck().size(), ((PinochleDeck) cut).getDeck().size());

    }

    @Test
    public void deal() {

        Deck control = new PinochleDeck();
        Deck deal = new PinochleDeck();

        assertEquals(control.turnOver(), deal.deal());
        assertNotEquals(control.turnOver(), deal.turnOver());

    }

    @Test
    public void turnOver() {

        Deck control = new PinochleDeck();

        assertEquals(control.turnOver(), ((PinochleDeck) control).getDeck().get(0));

    }
}
