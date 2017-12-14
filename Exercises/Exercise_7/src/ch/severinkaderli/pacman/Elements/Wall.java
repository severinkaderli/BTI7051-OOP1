package ch.severinkaderli.pacman.Elements;

import ch.severinkaderli.pacman.Common.Constants;
import ch.severinkaderli.pacman.Common.Type;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;

public class Wall extends StaticElement {

    private static final Color WALL_COLOR = Color.BLUE;

    public Wall(Point position) {
        super(position);
        this.type = Type.WALL;
    }

    public void draw(GraphicsContext context) {
        context.setFill(WALL_COLOR);
        context.fillRect(this.position.x * Constants.UNIT, this.position.y * Constants.UNIT, Constants.UNIT, Constants.UNIT);
    }
}
