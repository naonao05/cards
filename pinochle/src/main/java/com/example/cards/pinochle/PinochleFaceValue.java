package com.example.cards.pinochle;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.TreeSet;

/**
 * Face values for pinochle cards
 */
public class PinochleFaceValue
        implements FaceValue, Comparable<PinochleFaceValue> {

    public static final FaceValue NINE = new PinochleFaceValue("nine", 1);
    public static final FaceValue JACK = new PinochleFaceValue("jack", 2);
    public static final FaceValue QUEEN = new PinochleFaceValue("queen", 3);
    public static final FaceValue KING = new PinochleFaceValue("king", 4);
    public static final FaceValue TEN = new PinochleFaceValue("ten", 5);
    public static final FaceValue ACE = new PinochleFaceValue("ace", 6);

    private final String name;
    private final int ordinal;

    /**
     * Constructor.
     *
     * @param name    name
     * @param ordinal ordinal
     */
    private PinochleFaceValue(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    /**
     * Get values.
     *
     * @return Set of face values.
     */
    public static Set<FaceValue> values() {
        Set<FaceValue> set = new TreeSet<>();

        Field[] fields = PinochleFaceValue.class.getFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                try {
                    set.add((PinochleFaceValue) field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return set;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Get ordinal.
     *
     * @return ordinal
     */
    public int ordinal() {
        return ordinal;
    }

    @Override
    public int compareTo(PinochleFaceValue that) {

        if (this.ordinal > that.ordinal) {
            return 1;
        } else if (this.ordinal > that.ordinal) {
            return -1;
        } else {
            return 0;
        }

    }

}
