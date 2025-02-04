import java.util.Objects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Duke extends Application {
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image userImage = new Image(
            Objects.requireNonNull(
                    this.getClass().getResourceAsStream(
                            "/images/DaUser.png")));
    private Image dukeImage = new Image(
            Objects.requireNonNull(
                    this.getClass().getResourceAsStream(
                            "/images/DaDuke.png")));

    @Override
    public void start(Stage stage) {
        // Setting up required components
        this.scrollPane = new ScrollPane();
        this.dialogContainer = new VBox();
        this.scrollPane.setContent(this.dialogContainer);

        this.userInput = new TextField();
        this.sendButton = new Button("Send");

        DialogBox dialogBox = new DialogBox("Hello!", this.userImage);
        this.dialogContainer.getChildren().addAll(dialogBox);

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(
                this.scrollPane, this.userInput, this.sendButton);
        this.scene = new Scene(mainLayout); // Setting the scene to be our Label

        stage.setScene(this.scene); // Setting the stage to show our scene
        stage.show(); // Render the stage

        // More code to be added here later
    }
}
