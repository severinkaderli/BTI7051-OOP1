import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Maze implements Drawable {
    /**
     * Pointer to the current row
     */
    private int rowPointer;

    /**
     * Pointer to the current free column in the row
     */
    private int colPointer;

    /**
     * The elements of the maze
     */
    private List<List<GameElement>> maze;

    /**
     * Set the row and col pointer to the default values.
     */
    public Maze() {
        this.rowPointer = -1;
        this.colPointer = 0;
        this.maze = new ArrayList<>();
    }

    /**
     * Return the width of the maze
     *
     * @return The width
     */
    public int getWidth() {
        int width = 0;
        for(List<GameElement> row : this.maze) {
            if(row.size() > width) {
                width = row.size();
            }
        }
        return width;
    }

    /**
     * Return the height of the maze
     *
     * @return The height
     */
    public int getHeight() {
        return this.maze.size();
    }

    /**
     * Increase the row pointer and create a new ArrayList at that position.
     * This also resets the col pointer back to 0.
     */
    public void addRow() {
        this.rowPointer++;
        this.maze.add(rowPointer, new ArrayList<>());
        this.colPointer = 0;
    }

    public void addWall() {
        this.maze.get(rowPointer).add(colPointer, new Wall(new Point(colPointer, rowPointer)));
        this.colPointer++;
    }

    public void addFloor() {
        this.maze.get(rowPointer).add(colPointer, new Floor(new Point(colPointer, rowPointer)));
        this.colPointer++;
    }

    public void addPellet() {
        this.maze.get(rowPointer).add(colPointer, new Pellet(new Point(colPointer, rowPointer)));
        this.colPointer++;
    }

    /**
     * Return the element at the given position.
     *
     * @param position The position
     * @return The element at the position
     */
    public GameElement getElement(Point position) {
        // Check the bounds
        boolean inBounds = position.y >= 0 && position.y < this.maze.size() && position.x >= 0 && position.x < this.maze.get(position.y).size();
        if(inBounds) {
            return this.maze.get(position.y).get(position.x);
        }

        return null;
    }

    /**
     * Draw the maze to the graphics context.
     *
     * @param context The graphics context
     */
    public void draw(GraphicsContext context) {
        for(List<GameElement> row : this.maze) {
            for(GameElement element : row) {
                element.draw(context);
            }
        }
    }


}
