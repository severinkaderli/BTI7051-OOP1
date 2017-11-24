import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Pacman extends Entity {
    /**
     * The color of pacman
     */
	private static final Color PACMAN_COLOR = Color.YELLOW;

    /**
     * Create a new instance of pacman.
     *
     * @param x The x position
     * @param y The y position
     * @param maze The maze
     */
	public Pacman(int x, int y, Maze maze) {
		super(x, y, maze);
		this.setDirection(Direction.RIGHT);
	}

    /**
     * Draw pacman on the graphics context.
     *
     * @param context The graphics context
     */
	public void draw(GraphicsContext context) {
		context.setFill(PACMAN_COLOR);
		context.fillArc(x, y, Constants.UNIT, Constants.UNIT, this.getDirection().ordinal() * 90 + 30, 300, ArcType.ROUND);
	}

    /**
     * Move pacman
     */
	public void move() {
	    int oldX = this.x;
	    int oldY = this.y;

		switch(this.direction) {
			case RIGHT:
				this.x += Constants.UNIT / 6;
				break;
			case UP:
				this.y -= Constants.UNIT / 6;
				break;
			case LEFT:
				this.x -= Constants.UNIT / 6;
				break;
			case DOWN:
				this.y += Constants.UNIT / 6;
				break;
		}

		this.updateHitbox();
		if(this.collidesWith(Wall.class)) {
            this.x = oldX;
            this.y = oldY;
        }
	}
}
