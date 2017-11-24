import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Floor extends GameElement {
    private static final Color FLOOR_COLOR = Color.BLACK;

    public Floor(int x, int y) {
        super(x, y);
    }

    public void draw(GraphicsContext context) {
        context.setFill(FLOOR_COLOR);
        context.fillRect(this.hitbox.getMinX(), this.hitbox.getMinY(), this.hitbox.getWidth(), this.hitbox.getHeight());

    }
}
