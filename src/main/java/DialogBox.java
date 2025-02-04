import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DialogBox extends HBox {
    private Label text;
    private ImageView displayPicture;

    public DialogBox(String s, Image i) {
        this.text = new Label(s);
        this.displayPicture = new ImageView(i);
        this.getChildren().addAll(
                this.text, this.displayPicture);
    }
}
