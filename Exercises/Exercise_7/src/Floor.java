import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class Floor extends GameElement {
    private static final Color FLOOR_COLOR = Color.BLACK;

    public Floor(Point position) {
        super(position);
    }

    public void draw(GraphicsContext context) {
        context.setFill(FLOOR_COLOR);
        context.fillRect(this.hitbox.getX() * Constants.UNIT, this.hitbox.getY() * Constants.UNIT, this.hitbox.getWidth(), this.hitbox.getHeight());

    }
}
