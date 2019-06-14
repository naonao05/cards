package com.example.cards.pinochle;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.TreeSet;

/**
 * Represents the suit of a card
 */
public class Suit
        implements Comparable<Suit> {

    public static final Suit HEARTS = new Suit("Hearts", 1);
    public static final Suit CLUBS = new Suit("Clubs", 2);
    public static final Suit DIAMONDS = new Suit("Diamonds", 3);
    public static final Suit SPADES = new Suit("Spades", 4);

    private final String name;
    private final int ordinal;

    private Suit(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public static Set<Suit> values() {
        Set<Suit> set = new TreeSet<>();

        Field[] fields = Suit.class.getFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                try {
                    set.add((Suit) field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return set;
    }

    public String toString() {
        return name;
    }

    public int ordinal() {
        return ordinal;
    }

    @Override
    public int compareTo(Suit that) {

        if (this.ordinal > that.ordinal) {
            return 1;
        } else if (this.ordinal > that.ordinal) {
            return -1;
        } else {
            return 0;
        }

    }
}
