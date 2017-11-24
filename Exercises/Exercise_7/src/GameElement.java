import javafx.geometry.Rectangle2D;

abstract class GameElement implements Drawable {
    /**
     * The x position of the entity.
     */
    protected int x;

    /**
     * The y position of the entity.
     */
    protected int y;

    /**
     * The "hitbox" of the entity.
     */
    protected Rectangle2D hitbox;

    public GameElement(int x, int y) {
        this.x = x;
        this.y = y;
        this.updateHitbox();
    }

    /**
     * Returns the hitbox of the entity.
     *
     * @return The hitbox
     */
    public Rectangle2D getHitbox() {
        return this.hitbox;
    }

    protected void updateHitbox() {
        this.hitbox = new Rectangle2D(this.x, this.y, Constants.UNIT, Constants.UNIT);
    }


}