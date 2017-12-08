import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;


abstract class GameElement implements Drawable {
    /**
     * The position of the game element.
     */
    protected Point position;

    protected Type type;

    protected Color color;

    /**
     * The "hitbox" of the entity.
     */
    protected Rectangle hitbox;

    public GameElement(Point position) {
        this.position = position;
        this.type = Type.FLOOR;
        this.color = Color.GREEN;
        this.updateHitbox();
    }

    public Type getType() {
        return this.type;
    }

    public Point getPosition() { return this.position; }

    /**
     * Returns the hitbox of the entity.
     *
     * @return The hitbox
     */
    public Rectangle getHitbox() {
        return this.hitbox;
    }

    protected void updateHitbox() {
        this.hitbox = new Rectangle(this.position.x, this.position.y, Constants.UNIT, Constants.UNIT);
    }


}