import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextEditor extends Application {

    /**
     * This label contains the current error message.
     */
    private Label errorLabel;

    /**
     * This is the text input where the user will input the name
     * of the file.
     */
    private TextField fileName;

    /**
     * This is the text area where the contents of the file will be
     * displayed.
     */
    private TextArea fileContents;

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(20);
        root.setAlignment(Pos.TOP_LEFT);

        Label enterFileName = new Label("Enter file name:");
        root.getChildren().add(enterFileName);

        this.fileName = new TextField();
        root.getChildren().add(this.fileName);

        // Set up the error label
        this.errorLabel = new Label("");
        this.errorLabel.setTextFill(Color.RED);
        root.getChildren().add(this.errorLabel);

        Label fileContentLabel = new Label("File contents:");
        root.getChildren().add(fileContentLabel);

        this.fileContents = new TextArea();
        root.getChildren().add(this.fileContents);

        // Add buttons
        HBox buttonBar = new HBox();
        buttonBar.setPadding(new Insets(10));
        buttonBar.setSpacing(20);
        buttonBar.setAlignment(Pos.BOTTOM_CENTER);

        // Load the text from the file
        Button loadButton = new Button("Load");
        loadButton.setOnAction(event -> {
            try {
                FileReader fileReader = new FileReader(this.fileName.getText());
                Scanner fileScanner = new Scanner(fileReader);
                while (fileScanner.hasNextLine()) {
                    this.fileContents.appendText(fileScanner.nextLine() + "\n");
                }
                fileReader.close();
            } catch (IOException exception) {
                this.showError("There was an error reading the file!");
            }
        });
        buttonBar.getChildren().add(loadButton);

        // Save the text to the file
        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            try {
                FileWriter fileWriter = new FileWriter(this.fileName.getText());
                fileWriter.write(this.fileContents.getText());
                fileWriter.close();
            } catch (IOException exception) {
                this.showError("Invalid file name");
            }
        });
        buttonBar.getChildren().add(saveButton);

        // Clears the text area
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(event -> {

            this.fileContents.clear();
        });
        buttonBar.getChildren().add(clearButton);

        // Add the elements to the scene
        root.getChildren().add(buttonBar);
        stage.setScene(new Scene(root));

        stage.setHeight(600);
        stage.setWidth(800);
        stage.setTitle("Text Editor");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Display an error message.
     *
     * @param errorMessage The message that should be displayed
     */
    private void showError(String errorMessage) {
        this.errorLabel.setText(errorMessage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
