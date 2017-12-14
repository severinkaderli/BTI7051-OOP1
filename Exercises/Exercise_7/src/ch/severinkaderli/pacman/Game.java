package ch.severinkaderli.pacman;

import ch.severinkaderli.pacman.Common.Constants;
import ch.severinkaderli.pacman.Common.Direction;
import ch.severinkaderli.pacman.Elements.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends Application {
    /**
     * The configuration for the maze.
     */
    private static final int[][] MAZE_CONFIGURATION = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {2, 2, 2, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
    };

    private long oldTime;

    /**
     * The current score of the game
     */
    private long score;

    private Canvas canvas;

    /**
     * List of all drawables elements in the game.
     */
    private List<StaticElement> staticElements;

    /**
     * List of all movable elements in the game.
     */
    private List<Entity> entities;

    /**
     * Draw all drawable elements on the screen.
     *
     * @param context The graphics context to draw the elements on
     */
    private void render(GraphicsContext context) {
        // Clear the canvas
        context.setFill(Constants.FLOOR_COLOR);
        context.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());

        // Draw static elements
        for (Drawable element : this.staticElements) {
            element.draw(context);
        }

        // Draw entities
        for (Drawable element : this.entities) {
            element.draw(context);
        }

        // Draw the text for the score
        context.fillText("Score: " + this.score, 0, 10);
    }

    /**
     * Move all entities.
     */
    private void moveEntities() {
        for(Entity entity : this.entities) {
            entity.move();
        }
    }

    /**
     * Initialize all game elements so they are ready when the game
     * starts.
     */
    private void initializeGameElements() {
        MazeFactory mazeFactory = new MazeFactory();
        Maze maze = mazeFactory.buildMaze(Game.MAZE_CONFIGURATION);

        this.staticElements = maze.getStaticElements();
        this.entities = maze.getEntities();
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            this.initializeGameElements();
            score = 0;
            canvas = new Canvas(600, 400);
            BorderPane root = new BorderPane();
            root.setCenter(canvas);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Create a new maze object based on the given configuration array


            // Set the dimensions of the canvas based on the maze.
            canvas.setWidth(30 * Constants.UNIT);
            canvas.setHeight(30 * Constants.UNIT);
            primaryStage.sizeToScene();


            primaryStage.setTitle("ch.severinkaderli.pacman.Elements.Pacman");


            GraphicsContext context = canvas.getGraphicsContext2D();

            // Keyboard controls
            scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                /*switch (key.getCode()) {
                    case UP:
                        pacman.setDirection(Direction.UP);
                        break;
                    case RIGHT:
                        pacman.setDirection(Direction.RIGHT);
                        break;
                    case DOWN:
                        pacman.setDirection(Direction.DOWN);
                        break;
                    case LEFT:
                        pacman.setDirection(Direction.LEFT);
                        break;
                    default:
                        break;
                }*/
            });


            // Main game loop
            AnimationTimer animation = new AnimationTimer() {

                public void handle(long now) {
                    if (now > oldTime + Constants.FPS) {
                        oldTime = now;
                        Game.this.moveEntities();
                        Game.this.render(context);
                    }
                }
            };
            animation.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
