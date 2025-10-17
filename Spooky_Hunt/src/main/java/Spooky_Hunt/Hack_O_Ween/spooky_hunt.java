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
    String banner_path = "/Spooky_Hunt/Hack_O_Ween/banner.gif";
    // String bloody_banner_path = "/Spooky_Hunt/Hack_O_Ween/blood-drip.gif";
    String pumpkin2_path = "/Spooky_Hunt/Hack_O_Ween/pumpkin_2.gif";
    // String spikey_path = "/Spooky_Hunt/Hack_O_Ween/spikey.png";

    static Scene congratsScene;

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

        Image banner = new Image(getClass().getResource(banner_path).toExternalForm());
        ImageView banner_view = new ImageView(banner);

        VBox tmp = new VBox(banner_view, startButton);
        HBox cat_container = new HBox(pumpkin_cat_view);
        cat_container.setAlignment(Pos.BOTTOM_RIGHT);
        tmp.setAlignment(Pos.CENTER);
        starterPane = new BorderPane();
        starterPane.setCenter(tmp);
        starterPane.setBottom(cat_container);
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
        if(spot<4)
            stage.setScene(rounds.get(spot+1).getScene());
        else   
            stage.setScene(createCongratsScene());
    }

    public static Scene createCongratsScene(){
        Text flag = new Text("flame{neeee3rd!}");
        VBox tempBox = new VBox(flag);
        tempBox.setAlignment(Pos.CENTER);
        BorderPane tempPage = new BorderPane(flag);
        Scene tmp = new Scene(tempPage,700,600);

        return tmp;
    }
}

class Question_Round{
        private String question;
        private String Answer;
        private int roundNum;
        private Scene scene;
        private String spikey_path = "/Spooky_Hunt/Hack_O_Ween/spikey.png";
        private String bloody_banner_path = "/Spooky_Hunt/Hack_O_Ween/bloody_drip.png";
        private String cute_gruntilda_path = "/Spooky_Hunt/Hack_O_Ween/pixel_art.png";
        private String gruntilda_path = "/Spooky_Hunt/Hack_O_Ween/gruntilda.png";

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
            answerBox.setPrefWidth(500);
            answerBox.setStyle("-fx-background-color:#394F3F;-fx-margin-left:50px;-fx-margin-right:50px;-fx-text-color:#000000;");

            Button submit = new Button("Submit");
            submit.setStyle("-fx-background-color:#2D5155;");
            submit.setOnAction(e->{
                String inputText = answerBox.getText();
                if(matches(inputText)){
                    spooky_hunt.updateScene(roundNum);
                }
            });

            VBox decoration = new VBox();

            switch(this.roundNum){
                //myers
                case 0:
                    break;
                    //witch
                case 1:
                    Image gruntilda_image = new Image(getClass().getResource(gruntilda_path).toExternalForm());
                    ImageView gruntilda_view = new ImageView(gruntilda_image);
                    gruntilda_view.setFitHeight(300);
                    gruntilda_view.setFitWidth(300);
                    gruntilda_view.setPreserveRatio(true);

                    Image cute_gruntilda = new Image(getClass().getResource(cute_gruntilda_path).toExternalForm());
                    ImageView cute_gruntilda_view = new ImageView(cute_gruntilda);
                    cute_gruntilda_view.setFitWidth(300);   
                    cute_gruntilda_view.setFitHeight(200);    
                    cute_gruntilda_view.setPreserveRatio(true);

                    HBox tmpor = new HBox(gruntilda_view,cute_gruntilda_view);
                    tmpor.setAlignment(Pos.CENTER);
                    HBox.setHgrow(tmpor, Priority.NEVER);
                    decoration.getChildren().add(tmpor);
                    decoration.setMaxWidth(100);
                    decoration.setMaxHeight(100);
                    break;
                    //friday
                case 2:
                    break;
                    //spikey
                case 3:
                    Image spikey_image = new Image(getClass().getResource(spikey_path).toExternalForm());
                    ImageView spikey_view = new ImageView(spikey_image);
                    
                    decoration.getChildren().add(spikey_view);
                    decoration.setAlignment(Pos.CENTER);
                    break;
                    //carrie
                case 4:
                    Image bloody_banner_image = new Image(getClass().getResource(bloody_banner_path).toExternalForm());
                    ImageView bloody_banner_view = new ImageView(bloody_banner_image);
                    bloody_banner_view.fitWidthProperty().bind(decoration.widthProperty());
                    bloody_banner_view.setFitHeight(200); 
                    bloody_banner_view.setPreserveRatio(false);
                    decoration.getChildren().add(bloody_banner_view);
                    decoration.setAlignment(Pos.TOP_CENTER);
                    break;
                default:
                    break;
            }


            VBox Everything = new VBox(questionArea,answerBox, submit);
            Everything.setAlignment(Pos.CENTER);
            answerBox.setMaxWidth(300);
            VBox.setVgrow(answerBox, Priority.NEVER);
            Everything.setSpacing(15);


            BorderPane inner = new BorderPane();
            inner.setTop(decoration);
            inner.setCenter(Everything);
           inner.setStyle("-fx-background-color:#263F42;");

            BorderPane.setAlignment(Everything,Pos.CENTER);
            
            this.scene = new Scene(inner,700,600);

        }

        public Scene getScene(){
            return scene;
        }

        public int getNum(){
            return roundNum;
        }

        public boolean matches(String text){
            if(text.equals(Answer))
                return true;
            else
                return false;
        }
}
