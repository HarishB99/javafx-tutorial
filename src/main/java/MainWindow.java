import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class MainWindow {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(
            Objects.requireNonNull(
                    this.getClass().getResourceAsStream(
                            "/images/DaUser.png")));
    private Image dukeImage = new Image(
            Objects.requireNonNull(
                    this.getClass().getResourceAsStream(
                            "/images/DaDuke.png")));

    @FXML
    public void initialize() {
        this.scrollPane.vvalueProperty().bind(
                this.dialogContainer.heightProperty());
    }

    /** Injects the Duke instance */
    public void setDuke(Duke duke) {
        this.duke = duke;
    }

    /**
     * Creates two dialog boxes, one echoing user input and
     * the other containing Duke's reply and then appends
     * them to the dialog container. Clears the user input
     * after processing
     */
    @FXML
    private void handleUserInput() {
        String input = this.userInput.getText();
        String response = this.duke.getResponse(input);
        this.dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, this.userImage),
                DialogBox.getDukeDialog(response, this.dukeImage)
        );
        this.userInput.clear();
    }
}
