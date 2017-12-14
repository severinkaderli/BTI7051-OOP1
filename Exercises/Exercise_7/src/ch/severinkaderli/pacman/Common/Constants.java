package ch.severinkaderli.pacman.Common;

import javafx.scene.paint.Color;

/**
 * This is a class that is used for different constants throughout
 * the game.
 */
public final class Constants {
    /**
     * This is the standard unit size for elements. For example
     * single tiles have a width and height equal to this.
     */
    public static final int UNIT = 32;

    /**
     * The refresh rate of the game.
     */
    public static final double FPS = 1_000_000_000 / 15;

    /**
     * The color of the floor tiles.
     */
    public static final Color FLOOR_COLOR = Color.BLACK;
}
