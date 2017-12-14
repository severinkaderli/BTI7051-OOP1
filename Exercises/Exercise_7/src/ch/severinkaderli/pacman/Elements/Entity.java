package ch.severinkaderli.pacman.Elements;

import ch.severinkaderli.pacman.Common.Constants;
import ch.severinkaderli.pacman.Common.Direction;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

abstract public class Entity extends GameElement {
    /**
     * The maze which the entity belongs to.
     */
    protected Maze maze;

    /**
     * The direction where the entity is heading.
     */
    protected Direction direction;

    /**
     * Move the entity around the maze.
     */
    abstract public void move();

    /**
     * Create a new instance of the entity.
     *
     * @param position The position
     * @param maze The maze
     */
    public Entity(Point position, Maze maze) {
        super(position);
        this.maze = maze;
    }

    /**
     * Returns the current direction.
     *
     * @return The direction
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Set the new direction of the entity.
     *
     * @param direction The new direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void draw(GraphicsContext context) {
        context.setFill(Constants.FLOOR_COLOR);
        context.fillRect(this.position.x * Constants.UNIT, this.position.y * Constants.UNIT, Constants.UNIT, Constants.UNIT);
    }

}
