package ch.severinkaderli.pacman.Elements;

import ch.severinkaderli.pacman.Common.Constants;
import ch.severinkaderli.pacman.Common.Type;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;


abstract public class GameElement implements Drawable {
    /**
     * The position of the game element.
     */
    protected Point position;

    /**
     * The type of the element.
     */
    protected Type type;

    /**
     * The color of the elemet
     */
    protected Color color;

    /**
     * Create a new game element at the given position.
     *
     * @param position The position of the element.
     */
    public GameElement(Point position) {
        this.position = position;
        this.type = Type.FLOOR;
        this.color = Color.BLACK;
    }

    public Type getType() {
        return this.type;
    }

    public Point getPosition() { return this.position; }



}