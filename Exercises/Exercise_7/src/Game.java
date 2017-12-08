import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends Application {
    /**
     * The refresh rate of the game.
     */
    private static final double FPS = 1_000_000_000 / 60;

    /**
     * The configuration for the maze.
     */
    private static final int[][] MAZE_CONFIGURATION = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
    };

    private long oldTime;

    /**
     * The current score of the game
     */
    private long score;

    /**
     * List of all drawables elements in the game.
     */
    private List<Drawable> drawables;

    private Canvas canvas;

    /**
     * Draw all drawable elements on the screen.
     *
     * @param context The graphics context to draw the elements on
     */
    private void render(GraphicsContext context) {
        // Clear the canvas
        context.setFill(Color.GREY);
        context.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());

        for (Drawable element : this.drawables) {
            element.draw(context);
        }

        // Draw the text for the score
        context.fillText("Score: " + this.score, 0, 10);
    }

    private void moveElements() {
        this.pacman.move();
    }

    /**
     * The object for the maze.
     */
    private Maze maze;

    /**
     * The player character.
     */
    private Pacman pacman;


    private void initializeGameElements() {
        MazeFactory mazeFactory = new MazeFactory();
        this.maze = mazeFactory.buildMaze(Game.MAZE_CONFIGURATION);
        this.pacman = new Pacman(new Point(1, 2), this.maze);

        this.drawables = new ArrayList<Drawable>();
        this.drawables.add(this.maze);
        this.drawables.add(this.pacman);
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


            primaryStage.setTitle("Pacman");


            GraphicsContext context = canvas.getGraphicsContext2D();

            // Keyboard controls
            scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                switch (key.getCode()) {
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
                }
            });


            // Main game loop
            AnimationTimer animation = new AnimationTimer() {

                public void handle(long now) {
                    if (now > oldTime + Game.FPS) {
                        oldTime = now;
                        Game.this.moveElements();
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
