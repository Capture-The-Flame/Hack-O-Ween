package Spooky_Hunt.Hack_O_Ween;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.text.TextFlow;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class spooky_hunt extends Application {
    Scene startScene;
    Scene questionScene;
    BorderPane starterPane;
    BorderPane questionPane;
    Button startButton;
    Button submitButton;
    Text question;
    TextField answerField;

    @Override
    public void start(Stage stage) {
        startButton = new Button();
        startButton.setText("START");
        starterPane = new BorderPane(startButton);
        startScene = new Scene(starterPane, 700,600);
        stage.setScene(startScene);
        stage.setTitle("Spooky_Hunt");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
