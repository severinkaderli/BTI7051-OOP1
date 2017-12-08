import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.awt.*;


public class Pellet extends GameElement implements Scorable {

    private static final int PELLET_SCORE = 100;
    private static final Color PELLET_COLOR = Color.ORANGE;

    private boolean isEaten;

    public Pellet(Point position) {
        super(position);
        this.type = Type.PELLET;
        this.isEaten = false;
    }

    public int getScore() {
        return PELLET_SCORE;
    }

    /**
     * Draw a pellet on the graphics context.
     *
     * @param context The graphics context
     */
    public void draw(GraphicsContext context) {
        context.setFill(Color.BLACK);
        context.fillRect(this.hitbox.getX() * Constants.UNIT, this.hitbox.getY() * Constants.UNIT, this.hitbox.getWidth(), this.hitbox.getHeight());
        if (!this.isEaten) {
            context.setFill(PELLET_COLOR);
            int x = this.position.x * Constants.UNIT + Constants.UNIT / 2 - Constants.UNIT / 8;
            int y = this.position.y * Constants.UNIT + Constants.UNIT / 2 - Constants.UNIT / 8;
            context.fillOval(x, y, Constants.UNIT / 4, Constants.UNIT / 4);
        }

    }

    public void eat() {
        this.isEaten = true;
    }
    public boolean isEaten() {
        return this.isEaten;
    }
}
