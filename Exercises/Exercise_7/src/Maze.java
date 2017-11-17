import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Maze {


    /**
     * The width of the maze in px.
     */
    private int width;

    /**
     * The height of the maze in px.
     */
    private int height;

    private GameElement[][] maze;

    public Maze(int[][] mazeConfiguration) {
        // First we get the height and width of the maze
        this.height = mazeConfiguration.length;

        for (int[] row : mazeConfiguration) {
            if (row.length > this.width) {
                this.width = row.length;
            }
        }

        GameElement[][] elementMaze = new GameElement[this.height][this.width];

        for (int row = 0; row < mazeConfiguration.length; row++) {
            for (int field = 0; field < mazeConfiguration[row].length; field++) {
                int elementType = mazeConfiguration[row][field];

                switch(elementType) {
                    case 1:
                        elementMaze[row][field] = new Wall(field * Constants.UNIT, row * Constants.UNIT);
                        break;

                    default:
                        elementMaze[row][field] = new Floor(field * Constants.UNIT, row * Constants.UNIT);
                        break;
                }

            }
        }


        this.maze = elementMaze;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void draw(GraphicsContext context) {
        for (int row = 0; row < this.maze.length; row++) {
            for (int field = 0; field < this.maze[row].length; field++) {
                if (this.maze[row][field] != null) {
                    this.maze[row][field].draw(context);
                }

            }
        }

    }

    public boolean intersects(Pacman pacman) {
        Rectangle2D rect = new Rectangle2D();
        rect.intersects();
    }
}
