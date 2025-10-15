package Spooky_Hunt.Hack_O_Ween;

import java.util.Vector;
import javafx.geometry.Pos;
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
    static Stage stage;
    Scene startScene;
    Scene questionScene;
    BorderPane starterPane;
    BorderPane questionPane;
    Button startButton;
    Button submitButton;
    Text question;
    TextField answerField;
    String pumpkin1 = "/Spooky_Hunt/Hack_O_Ween/pumpkin_1.gif";

    static Vector<Question_Round> rounds = createQuestions();

    @Override
    public void start(Stage stage) {
        spooky_hunt.stage = stage;
        startButton = new Button();
        startButton.setText("START");
        startButton.setStyle("-fx-border-radius:100px;-fx-width:40%;-fx-height:20%;-fx-background-color:red;-fx-padding:5%;");
        startButton.setPrefWidth(200);
        startButton.setPrefHeight(80);


        Image pumpkin_cat = new Image(getClass().getResource(pumpkin1).toExternalForm());
        ImageView pumpkin_cat_view = new ImageView(pumpkin_cat);
        HBox tmp = new HBox(startButton, pumpkin_cat_view);
        starterPane = new BorderPane(tmp);
        starterPane.setStyle("-fx-background-color:darkred;");
        startScene = new Scene(starterPane, 700,600);

        startButton.setOnAction(e->{
            // System.out.println("CLICKED");
            stage.setScene(rounds.get(0).getScene());
        });

        stage.setScene(startScene);
        
        stage.setTitle("Spooky_Hunt");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    public static Vector<Question_Round> createQuestions(){
        rounds = new Vector<>(5);

        for(int i =0; i<5;i++){
            Question_Round tmp = new Question_Round(i);
            rounds.add(tmp);
        }

        rounds.get(0).setQandA("What town was Michael Myers from?","Haddonfield");
        rounds.get(1).setQandA("Where did the most famous witch trials occur?","Salem");
        rounds.get(2).setQandA("Who was the killer in Friday the 13th?","Pamela Voorhees");
        rounds.get(3).setQandA("What`s his name?","Spikey");
        rounds.get(4).setQandA("How old was Carrie when she went on her rampage?","16");

        return rounds;
    }

    public static void updateScene(int spot){
        System.out.println(spot);
        if(spot<4)
            stage.setScene(rounds.get(spot+1).getScene());
        // else   
        //     stage.setScene(congrats);
    }
}

class Question_Round{
        private String question;
        private String Answer;
        private int roundNum;
        private Scene scene;

        Question_Round(int roundNum){
            this.roundNum=roundNum;
        }
        
        public void setQandA(String question, String answer){
            this.question=question;
            this.Answer = answer;
            this.createScene();
        }

        public void getQandA(){
            System.out.println(question + " " + Answer);
        }

        public void createScene(){

            Text questionArea = new Text(question);
            TextField answerBox = new TextField();
            answerBox.setPrefWidth(50);
            answerBox.setStyle("-fx-background-color:#394F3F;");

            Button submit = new Button("Submit");
            submit.setStyle("-fx-background-color:#2D5155;");
            submit.setOnAction(e->{
                String inputText = answerBox.getText();
                if(matches(inputText)){
                    spooky_hunt.updateScene(roundNum);
                }
            });

            VBox Everything = new VBox(questionArea,answerBox, submit);
            Everything.setAlignment(Pos.CENTER);
            BorderPane inner = new BorderPane();
            inner.setCenter(Everything);
            Everything.setStyle("-fx-background-color:#263F42;");
            
            this.scene = new Scene(inner,700,600);

        }

        public Scene getScene(){
            return scene;
        }

        public int getNum(){
            return roundNum;
        }

        public boolean matches(String text){
            System.out.println(Answer + " " + text);
            if(text.equals(Answer))
                return true;
            else
                return false;
        }
}
