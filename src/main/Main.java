package main;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import mainMenu.*;

public class Main extends Application{
    static double width = 1000;
    static double hight = 600;
    double buttonX = 50;
    double buttonY = 150;

    //GameScenes
    public static GameScene gamePlayScene = new GameScene(width, hight, Color.BLACK);

    public static GameScene []scenes = new GameScene[4];



    public static int itemsInScene = 0;
    public static int level = 1;


    @Override
    public void start(Stage stage) {

        stage.setTitle("Class Arkanoid Game");

        scenes[0] = new GameScene(width, hight, Color.BLACK);
        scenes[1] = gamePlayScene;
        scenes[2] = new GameScene(width, hight, Color.BLACK);
        scenes[3] = new GameScene(width, hight, Color.BLACK);


        displayText("you win!", scenes[2].root);
        displayText("Game over", scenes[3].root);

        //GameButtons
        MainMenuButtons mainMenuButtons = new MainMenuButtons(scenes[0].root,buttonX,buttonY);
        GamePlay gamePlay = new GamePlay(scenes[1].root);

        System.out.println(scenes[1].scene.getFill().toString());

        GameLoop gameLoop = new GameLoop(stage, scenes, mainMenuButtons, gamePlay);

        gameLoop.start();
        stage.show();
    }

    public static void main(String []args){
        Application.launch(args);
    }

    public void displayText(String text, Pane root){
        Text loading1 = new Text(text);
        loading1.setFill(Color.BLACK);
        loading1.setFont(new Font(100));
        loading1.setX(250);
        loading1.setY(300);
        root.getChildren().clear();
        root.getChildren().add(loading1);

    }
}
