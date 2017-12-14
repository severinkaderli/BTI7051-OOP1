package ch.severinkaderli.pacman.Common;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for the different types of game elements.
 */
public enum Type {
    FLOOR(0),
    WALL(1),
    PELLET(2),
    POWER_PELLET(3),
    PACMAN(4),
    BLINKY(5),
    PINKY(6),
    INKY(7),
    CLYDE(8);

    /**
     * The value of the current type.
     */
    private final int value;

    /**
     * A map to hold integer type pairs.
     */
    private static final Map<Integer, Type> map = new HashMap<Integer, Type>();

    // Initialise the map
    static {
        for (Type type : Type.values()) {
            map.put(type.value, type);
        }
    }

    /**
     * Create a type.
     *
     * @param value The value of the type
     */
    private Type(int value) {
        this.value = value;
    }

    /**
     * Returns the type representated by the given integer.
     *
     * @param value The integer
     * @return The corresponding type
     */
    public static Type valueOf(int value) {
        return map.get(value);
    }

}
