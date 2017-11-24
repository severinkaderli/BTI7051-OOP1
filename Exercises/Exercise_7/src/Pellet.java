import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;


public class Pellet extends GameElement implements Scorable {

    private static final int PELLET_SCORE = 100;
    private static final Color PELLET_COLOR = Color.ORANGE;

    private boolean isAlive;

    public Pellet(int x, int y) {
        super(x, y);
        this.isAlive = true;
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
        context.fillRect(this.hitbox.getMinX(), this.hitbox.getMinY(), this.hitbox.getWidth(), this.hitbox.getHeight());
        if (this.isAlive) {
            context.setFill(PELLET_COLOR);
            int x = this.x + Constants.UNIT / 2 - Constants.UNIT / 8;
            int y = this.y + Constants.UNIT / 2 - Constants.UNIT / 8;
            context.fillOval(x, y, Constants.UNIT / 4, Constants.UNIT / 4);
        }

    }

    public void kill() {
        this.isAlive = false;
    }
}
