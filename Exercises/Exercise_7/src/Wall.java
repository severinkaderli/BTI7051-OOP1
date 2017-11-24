
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Wall extends GameElement {

    private static final Color WALL_COLOR = Color.BLUE;

    public Wall(int x, int y) {
        super(x, y);
    }

    public void draw(GraphicsContext context) {
        context.setFill(WALL_COLOR);
        context.fillRect(this.hitbox.getMinX(), this.hitbox.getMinY(), this.hitbox.getWidth(), this.hitbox.getHeight());
    }
}
