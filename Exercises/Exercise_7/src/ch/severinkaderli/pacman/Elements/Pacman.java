package ch.severinkaderli.pacman.Elements;

import ch.severinkaderli.pacman.Common.Constants;
import ch.severinkaderli.pacman.Common.Direction;
import ch.severinkaderli.pacman.Common.Type;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.awt.*;

public class Pacman extends Entity {

    /**
     * Whether pacman is currently moving or not.
     */
    private boolean isMoving;

    /**
     * Create a new instance of pacman.
     *
     * @param position The position
     * @param maze The maze
     */
    public Pacman(Point position, Maze maze) {
        super(position, maze);
        this.type = Type.PACMAN;
        this.setDirection(Direction.RIGHT);
        this.color = Color.YELLOW;
        this.isMoving = false;
    }

    /**
     * Draw pacman on the graphics context.
     *
     * @param context The graphics context
     */
    public void draw(GraphicsContext context) {
        super.draw(context);
        context.setFill(this.color);
        context.fillArc(position.x * Constants.UNIT, position.y * Constants.UNIT, Constants.UNIT, Constants.UNIT, this.getDirection().ordinal() * 90 + 30, 300, ArcType.ROUND);
    }

    /**
     * Move pacman
     */
    public void move() {
        Point oldPosition = (Point) this.position.clone();

        switch (this.direction) {
            case RIGHT:
                this.position.x++;
                break;
            case UP:
                this.position.y--;
                break;
            case LEFT:
                this.position.x--;
                break;
            case DOWN:
                this.position.y++;
                break;
        }

        GameElement element = this.maze.getElement(this.position);

        // If element doesn't exist do nothing
        if (element == null) {
            this.position = oldPosition;
            return;
        }

        switch (element.getType()) {
            case WALL:
                System.out.println("Collision with wall");
                this.position = oldPosition;
                break;

            case PELLET:
                Pellet pellet = (Pellet) element;
                if (!pellet.isEaten()) {
                    pellet.eat();
                }
                break;
        }
    }
}
