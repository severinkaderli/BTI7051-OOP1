
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Wall implements GameElement {

    private static final Color WALL_COLOR = Color.BLACK;

    private Rectangle2D rectangle;

    public Wall(int x, int y) {
        this.rectangle = new Rectangle2D(x, y, Constants.UNIT, Constants.UNIT);
    }

    public void draw(GraphicsContext context) {
        context.setFill(WALL_COLOR);
        context.fillRect(rectangle.getMinX(), rectangle.getMinY(), rectangle.getWidth(), rectangle.getHeight());
    }
}
