import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class CounterApplication extends Application {

    /**
     * The counter for this application.
     */
    private Counter counter;

    /**
     * The label for the current count.
     */
    private Label countLabel;

    @Override
    public void start(Stage stage) {
        this.counter = new Counter();

        countLabel = new Label("0");

        // Count button
        Button countButton = new Button("Count");
        countButton.setOnAction(event -> {
            this.counter.count();
            countLabel.setText(String.valueOf(this.counter.getCount()));
        });

        // Reset button
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(event -> {
            this.counter.reset();
            countLabel.setText(String.valueOf(this.counter.getCount()));
        });

        VBox root = new VBox(countButton, resetButton, countLabel);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setTitle("Counter");
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
