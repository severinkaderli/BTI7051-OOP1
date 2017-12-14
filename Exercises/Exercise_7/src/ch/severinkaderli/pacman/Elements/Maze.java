package ch.severinkaderli.pacman.Elements;

import ch.severinkaderli.pacman.Common.Type;
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
     * The maze as a multi dimensional list of game elements.
     */
    private List<List<GameElement>> maze;

    /**
     * List of all static game elements in the maze.
     */
    private List<StaticElement> staticElements;

    /**
     * List of all entities in the maze.
     */
    private List<Entity> entities;

    /**
     * Set the row and col pointer to the default values.
     */
    public Maze() {
        this.rowPointer = -1;
        this.colPointer = 0;
        this.maze = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.staticElements = new ArrayList<>();
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

    public List<Entity> getEntities() {return this.entities; }
    public List<StaticElement> getStaticElements() {return this.staticElements; }

    /**
     * Increase the row pointer and create a new ArrayList at that position.
     * This also resets the col pointer back to 0.
     */
    public void addRow() {
        this.rowPointer++;
        this.maze.add(rowPointer, new ArrayList<>());
        this.colPointer = 0;
    }

    /**
     * Adds the given element to the current row and increments the
     * col pointer by one.
     *
     * @param element The element that should be added.
     */
    private void addElement(GameElement element) {
        this.maze.get(rowPointer).add(colPointer, element);
        this.colPointer++;
    }

    private void addStaticElement(StaticElement element) {
        this.addElement(element);
        this.staticElements.add(element);
    }

    private void addEntity(Entity element) {
        this.addElement(element);
        this.entities.add(element);
    }

    /**
     * Adds a wall to the current row.
     */
    public void addWall() {
        this.addStaticElement(new Wall(new Point(colPointer, rowPointer)));
    }

    /**
     * Adds a floor to the current row.
     */
    public void addFloor() {
        this.addStaticElement(new Floor(new Point(colPointer, rowPointer)));
    }

    /**
     * Adds a pellet to the current row.
     */
    public void addPellet() {
        this.addStaticElement(new Pellet(new Point(colPointer, rowPointer)));
    }

    public void addPacman() {
        this.addEntity(new Pacman(new Point(colPointer, rowPointer), this));
    }

    public void addGhost(Type type) {
        /*Ghost ghost = new Ghost(new Point(colPointer, rowPointer), this, Type.CLYDE);
        this.addElement(pacman);
        this.entities.add(ghost);*/
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
