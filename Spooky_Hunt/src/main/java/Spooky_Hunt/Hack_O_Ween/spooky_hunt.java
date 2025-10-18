package Spooky_Hunt.Hack_O_Ween;

import java.util.Vector;

import javafx.geometry.Insets;
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
    String backdrop_path = "/Spooky_Hunt/Hack_O_Ween/backdrop.jpg";

    static Scene congratsScene;
    Font font= Font.loadFont(getClass().getResource("/Spooky_Hunt/Hack_O_Ween/SingleDay-Regular.ttf").toExternalForm(),24);

    static Vector<Question_Round> rounds = createQuestions();

    @Override
    public void start(Stage stage) {
        spooky_hunt.stage = stage;
        startButton = new Button();
        startButton.setText("START");
        startButton.setFont(font);
        startButton.setStyle("-fx-border-radius:100px;-fx-background-color:red;");
        startButton.setPrefWidth(200);
        startButton.setPrefHeight(80);


        Image pumpkin_cat = new Image(getClass().getResource(pumpkin1).toExternalForm());
        ImageView pumpkin_cat_view = new ImageView(pumpkin_cat);
        pumpkin_cat_view.setFitHeight(300);
        pumpkin_cat_view.setFitWidth(300);
        pumpkin_cat_view.setPreserveRatio(true);

        Image banner = new Image(getClass().getResource(banner_path).toExternalForm());
        ImageView banner_view = new ImageView(banner);

        VBox tmp = new VBox(banner_view, startButton);
        HBox cat_container = new HBox(pumpkin_cat_view);
        cat_container.setAlignment(Pos.BOTTOM_RIGHT);
        cat_container.setMaxWidth(300);
        cat_container.setMaxHeight(300);
        VBox total = new VBox(tmp,cat_container);
        tmp.setAlignment(Pos.CENTER);
        total.setAlignment(Pos.CENTER);

        StackPane stackpain = new StackPane();

        stackpain.getChildren().addAll(tmp, cat_container);
        StackPane.setAlignment(cat_container, Pos.BOTTOM_RIGHT);

        starterPane = new BorderPane();
        starterPane.setCenter(stackpain);
        // starterPane.setStyle("-fx-background-color:darkred;");

        startScene = new Scene(starterPane, 700,600);

        startButton.setOnAction(e->{
            // System.out.println("CLICKED");
            stage.setScene(rounds.get(0).getScene());
        });

        stage.setScene(startScene);
        stage.setResizable(false);
        stage.setTitle("Spooky_Hunt");
        Image icon = new Image(getClass().getResource("/Spooky_Hunt/Hack_O_Ween/pumpkin_2.gif").toExternalForm());

        stage.getIcons().add(icon);
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
        Font font = Font.loadFont(spooky_hunt.class.getResource("/Spooky_Hunt/Hack_O_Ween/SingleDay-Regular.ttf").toExternalForm(), 30);
        flag.setFont(font);
        VBox tempBox = new VBox(flag);
        tempBox.setAlignment(Pos.CENTER);
        BorderPane tempPage = new BorderPane(flag);
        tempPage.setStyle("-fx-background-color:darkred;");
        Scene tmp = new Scene(tempPage,700,600);

        return tmp;
    }
}

class Question_Round{
        private String question;
        private String Answer;
        private int roundNum;
        private Scene scene;
        private String color;
        private String spikey_path = "/Spooky_Hunt/Hack_O_Ween/spikey.png";
        private String bloody_banner_path = "/Spooky_Hunt/Hack_O_Ween/bloody_drip.png";

        private String carrie_backdrop = "/Spooky_Hunt/Hack_O_Ween/backdrop-blood.jpg";
        private String spikey_backdrop = "/Spooky_Hunt/Hack_O_Ween/spikey-background.jpg";
        private String jason_backdrop = "/Spooky_Hunt/Hack_O_Ween/crystal_lake.png";
        private String salem_backdrop = "/Spooky_Hunt/Hack_O_Ween/salem.jpeg";
        private String michael_back = "/Spooky_Hunt/Hack_O_Ween/michael_back.jpg";
        private Font font= Font.loadFont(getClass().getResource("/Spooky_Hunt/Hack_O_Ween/SingleDay-Regular.ttf").toExternalForm(),24);


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
            questionArea.setStyle("-fx-fill:#FFFFFF");
            questionArea.setFont(font);
            TextField answerBox = new TextField();
            answerBox.setPrefWidth(300);
            answerBox.setFont(font);
            answerBox.setStyle("-fx-background-color:#394F3F;-fx-text-fill:#000000;");

            Button submit = new Button("Submit");
            submit.setFont(font);
            submit.setStyle("-fx-background-color:#2D5155;");
            submit.setOnAction(e->{
                String inputText = answerBox.getText();
                if(matches(inputText)){
                    spooky_hunt.updateScene(roundNum);
                }
            });

            VBox Everything = new VBox(questionArea,answerBox, submit);
            Everything.setAlignment(Pos.CENTER);
            answerBox.setMaxWidth(150);
            VBox.setVgrow(answerBox, Priority.NEVER);
            Everything.setSpacing(20);
            Everything.setMaxHeight(Region.USE_PREF_SIZE);
            Everything.setMaxWidth(Region.USE_PREF_SIZE);
            Everything.setStyle("-fx-background-color:#000000;-fx-border-radius:50px;-fx-border-color:black;-fx-border-width:2px;-fx-background-radius:50px");
            Everything.setPadding(new Insets(25, 20, 25, 20));


            VBox decoration = new VBox();
            BorderPane inner = new BorderPane();
            StackPane stack = new StackPane();

            switch(this.roundNum){
                //myers
                case 0:

                    BackgroundImage michael_background = new BackgroundImage(
                        new Image(getClass().getResource(michael_back).toExternalForm()),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100, 100, true, true, false, true)
                    );
                    stack.setBackground(new Background(michael_background));

                    color = "-fx-background-color:#0c2a2d;";
                    stack.getChildren().addAll(decoration,Everything);
                    StackPane.setAlignment(decoration, Pos.TOP_CENTER);
                    StackPane.setAlignment(Everything,Pos.BOTTOM_CENTER);
                    StackPane.setMargin(Everything, new Insets(0, 0, 50, 0));
                    break;
                case 1:

                    BackgroundImage salem_background = new BackgroundImage(
                        new Image(getClass().getResource(salem_backdrop).toExternalForm()),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100, 100, true, true, false, true)
                    );
                    stack.setBackground(new Background(salem_background));

                    color="-fx-background-color:#2fa71c";
                    stack.getChildren().addAll(decoration,Everything);
                    StackPane.setAlignment(decoration, Pos.TOP_CENTER);
                    StackPane.setAlignment(Everything,Pos.BOTTOM_CENTER);
                    StackPane.setMargin(Everything, new Insets(0, 0, 50, 0));
                    break;
                    //friday
                case 2:
                    BackgroundImage background = new BackgroundImage(
                        new Image(getClass().getResource(jason_backdrop).toExternalForm()),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100, 100, true, true, false, true)
                    );
                    stack.setBackground(new Background(background));
                    stack.getChildren().addAll(decoration,Everything);
                    StackPane.setAlignment(decoration, Pos.TOP_CENTER);
                    break;
                    //spikey
                case 3:
                    Image spikey_image = new Image(getClass().getResource(spikey_path).toExternalForm());
                    ImageView spikey_view = new ImageView(spikey_image);

                    BackgroundImage spikey_background = new BackgroundImage(
                        new Image(getClass().getResource(spikey_backdrop).toExternalForm()),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100, 100, true, true, false, true)
                    );
                    stack.setBackground(new Background(spikey_background));
                    
                    decoration.getChildren().add(spikey_view);
                    decoration.setAlignment(Pos.CENTER);
                    color = "-fx-background-color:#000000;";
                    stack.getChildren().addAll(decoration,Everything);
                    StackPane.setAlignment(decoration, Pos.TOP_CENTER);
                    StackPane.setAlignment(Everything,Pos.BOTTOM_CENTER);
                    StackPane.setMargin(decoration, new Insets(0, 0, 200, 0));
                    StackPane.setMargin(Everything, new Insets(0, 0, 20, 0));
                    Everything.setSpacing(2);
                    break;
                    //carrie
                case 4:
                    Image bloody_banner_image = new Image(getClass().getResource(bloody_banner_path).toExternalForm());
                    ImageView bloody_banner_view = new ImageView(bloody_banner_image);

                    BackgroundImage carrie_background = new BackgroundImage(
                        new Image(getClass().getResource(carrie_backdrop).toExternalForm()),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(100, 100, true, true, false, true)
                    );
                    stack.setBackground(new Background(carrie_background));

                    bloody_banner_view.setFitWidth(700);
                    bloody_banner_view.setFitHeight(100); 
                    bloody_banner_view.setPreserveRatio(false);
                    decoration.setAlignment(Pos.TOP_CENTER);
                    decoration.getChildren().add(bloody_banner_view);
                    color="-fx-background-color:#4D4247;";
                    stack.getChildren().addAll(decoration,Everything);
                    StackPane.setAlignment(decoration, Pos.TOP_CENTER);
                    break;
                default:
                    color="-fx-background-color:pink;";
                    break;
            }


            // inner.setTop(decoration);
            inner.setCenter(stack);
            inner.setStyle(color);

            // BorderPane.setAlignment(Everything,Pos.CENTER);
            
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
