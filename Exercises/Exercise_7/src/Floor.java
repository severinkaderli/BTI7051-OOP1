import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Floor implements GameElement {
    private static final Color FLOOR_COLOR = Color.BLUE;

    private Rectangle2D rectangle;

    public Floor(int x, int y) {
        this.rectangle = new Rectangle2D(x, y, Constants.UNIT, Constants.UNIT);
    }

    public void draw(GraphicsContext context) {
        context.setFill(FLOOR_COLOR);
        context.fillRect(rectangle.getMinX(), rectangle.getMinY(), rectangle.getWidth(), rectangle.getHeight());

    }
}
