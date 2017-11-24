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
     * @param x    The x position
     * @param y    The y position
     * @param maze The maze
     */
    public Entity(int x, int y, Maze maze) {
        super(x, y);
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

    /**
     * Check if the entity collides with an element of the given type.
     *
     * @param gameElement The class which to check for.
     * @return True if there is a collision, false otherwise.
     */
    public boolean collidesWith(Class gameElement) {
        for (GameElement[] row : this.maze.getMaze()) {
            for (GameElement element : row) {
                if (gameElement.isInstance(element)) {
                    if (element.getHitbox().intersects(this.hitbox)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


}
