package ch.severinkaderli.pacman.Elements;

import ch.severinkaderli.pacman.Common.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class Floor extends StaticElement {
    private static final Color FLOOR_COLOR = Color.BLACK;

    public Floor(Point position) {
        super(position);
    }

    public void draw(GraphicsContext context) {
        context.setFill(FLOOR_COLOR);
        context.fillRect(this.position.x * Constants.UNIT, this.position.y * Constants.UNIT, Constants.UNIT, Constants.UNIT);

    }
}
