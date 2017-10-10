import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class HighestBuilding extends Application {
    /**
     * The height of the scene
     */
    private final int SCENE_HEIGHT = 600;

    /**
     * The width of the scene
     */
    private final int SCENE_WIDTH = 500;

    /**
     * The padding that is used in the drawing of the bars
     */
    private final int PADDING = 20;

    /**
     * The width of the bars
     */
    private final int BAR_WIDTH = 50;

    /**
     * The margin between the bars
     */
    private final int BAR_MARGIN = 70;

    /**
     * The list of the buildings that should be drawn.
     */
    private List<Building> buildings = new ArrayList<Building>();

    @Override
    public void start(Stage stage) {
        // Add buildings to list
        this.buildings.add(new Building("Sears Tower", 527));
        this.buildings.add(new Building("Taipei 101", 508));
        this.buildings.add(new Building("Empire State Building", 449));
        this.buildings.add(new Building("Eiffel Tower", 324));
        this.buildings.add(new Building("Berner Münster", 100));

        // Create rectangles and labels for the building
        Group group = new Group();
        for(int i = 0; i < buildings.size(); i++) {
            Rectangle rectangle = new Rectangle(i * this.BAR_MARGIN + this.PADDING, this.SCENE_HEIGHT - this.PADDING - buildings.get(i).getHeight(), this.BAR_WIDTH, buildings.get(i).getHeight());
            rectangle.setFill(Color.DARKBLUE);
            group.getChildren().add(rectangle);

            // Add label for the building
            Text text = new Text(i * this.BAR_MARGIN + this.PADDING, this.SCENE_HEIGHT - 1.2 * this.PADDING - buildings.get(i).getHeight(), buildings.get(i).getName());
            text.setFont(new Font("Courier", 20));
            group.getChildren().add(text);
        }


        Scene scene = new Scene(group, this.SCENE_WIDTH, this.SCENE_HEIGHT);
        scene.setFill(Color.LIGHTGRAY);
        stage.setScene(scene);
        stage.setTitle("World's Highest Buildings");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        HighestBuilding.launch(args);
    }
}
