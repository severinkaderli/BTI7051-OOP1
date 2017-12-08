
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class Wall extends GameElement {

    private static final Color WALL_COLOR = Color.BLUE;

    public Wall(Point position) {
        super(position);
        this.type = Type.WALL;
    }

    public void draw(GraphicsContext context) {
        context.setFill(WALL_COLOR);
        context.fillRect(this.hitbox.getX() * Constants.UNIT, this.hitbox.getY() * Constants.UNIT, this.hitbox.getWidth(), this.hitbox.getHeight());
    }
}
