

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Pacman {
	private static final Color PACMAN_COLOR = Color.YELLOW;
	private int x, y;
	private Direction direction = Direction.RIGHT;

	public Pacman(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void paint(GraphicsContext context) {
		context.setFill(PACMAN_COLOR);
		context.fillArc(x, y, Constants.UNIT, Constants.UNIT, this.getDirection().ordinal() * 90 + 30, 300, ArcType.ROUND);
	}
	
	public void move(Maze maze) {
	    if(maze.intersects(this)) {
	        return;
        }
		switch(this.direction) {
		case RIGHT:
			x += Constants.UNIT / 6;
			break;
		case UP:
			y -= Constants.UNIT / 6;
			break;
		case LEFT:
			x -= Constants.UNIT / 6;
			break;
		case DOWN:
			y += Constants.UNIT / 6;
			break;
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
