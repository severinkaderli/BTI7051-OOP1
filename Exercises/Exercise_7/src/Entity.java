import java.awt.*;

abstract class Entity extends GameElement {
    /**
     * The maze which the entity belongs to.
     */
    protected Maze maze;

    /**
     * The direction where the entity is heading.
     */
    protected Direction direction;

    /**
     * Create a new instance of the entity.
     *
     * @param position The position
     * @param maze The maze
     */
    public Entity(Point position, Maze maze) {
        super(position);
        this.type = Type.ENTITY;
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



}
