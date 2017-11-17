import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    /**
     * The configuration for the maze.
     */
    private int[][] mazeConfiguration = {
            {1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 3, 4, 5, 3},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 0}
    };

    private long oldTime;

    @Override
    public void start(Stage primaryStage) {
        try {
            Canvas canvas = new Canvas(600, 400);
            BorderPane root = new BorderPane();
            root.setCenter(canvas);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

            Maze maze = new Maze(mazeConfiguration);
            // Set the dimensions of the canvas based on the maze.
            canvas.setWidth(maze.getWidth() * Constants.UNIT);
            canvas.setHeight(maze.getHeight() * Constants.UNIT);

            Pacman pacman = new Pacman(5 * Constants.UNIT, 5 * Constants.UNIT);
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



            AnimationTimer animation = new AnimationTimer() {

                public void handle(long now) {
                    if(now > oldTime + (1_000_000_000 / 60)) {
                        oldTime = now;
                        System.out.println(now);
                        pacman.move();
                        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        maze.draw(context);
                        pacman.paint(context);
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
