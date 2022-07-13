package main;


import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import levels.BigBoss;
import levels.blocks;
import mainMenu.*;
import player.Ball;

public class GameLoop extends AnimationTimer {

    private Stage stage;
    private GameScene[] scenes;

    private EventHandler<MouseEvent> mouseEventHandler;
    private MainMenuButtons mainMenuButtons;
    private GamePlay gamePlay;

    public GameLoop(Stage stage, GameScene[] scenes, MainMenuButtons mainMenuButtons, GamePlay gamePlay) {
        this.stage = stage;
        this.scenes = scenes;
        stage.setScene(scenes[0].scene);
        scenes[1].root.getChildren().remove(0, 1);
        scenes[1].scene.setFill(Color.BLACK);
        this.gamePlay = gamePlay;
        this.mainMenuButtons = mainMenuButtons;
        this.gamePlay = gamePlay;
    }

    @Override
    public void handle(long now) {

        mainMenuButtons.startGame.setOnMouseClicked(mouseEventHandler);
        mainMenuButtons.endGame.setOnMouseClicked(mouseEventHandler);


        if (stage.getScene() == scenes[1].scene) {
            stage.getScene().setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ESCAPE) {
                    stage.setScene(scenes[0].scene);
                }
            });
        }

        mouseEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getSource() == mainMenuButtons.startGame) {
                    stage.setScene(scenes[1].scene);
                } else if (event.getSource() == mainMenuButtons.endGame) {
                    GameLoop.this.stop();
                    stage.close();
                }
            }
        };
        if (stage.getScene() == scenes[1].scene){
            update();
        }
    }

    public void update() {
        boolean win = BigBoss.isDestroyed;
        boolean gameOver = Ball.gameOver;
        if (Main.itemsInScene == 0 && Main.level == 1) {
            System.out.println("level 1");
            blocks.numberOfBlocksActive = 0;
            scenes[1].root.getChildren().clear();
            gamePlay.level_1();
            Main.level = 2;
        } else if (Main.itemsInScene == 0 && Main.level == 2) {
            stage.setScene(scenes[1].scene);
            System.out.println("level 2");
            blocks.numberOfBlocksActive = 0;
            scenes[1].root.getChildren().clear();
            Main.level++;
            gamePlay.level_2();
        } else if (Main.itemsInScene == 0 && Main.level == 3) {
            System.out.println("level 3");
            blocks.numberOfBlocksActive = 0;
            scenes[1].root.getChildren().clear();
            Main.level++;
            gamePlay.level_3();

        } else if (Main.itemsInScene == 0 && Main.level == 4) {
            System.out.println("level boss");
            blocks.numberOfBlocksActive = 0;
            scenes[1].root.getChildren().clear();
            Main.level++;
            gamePlay.boss_level();
        }
        if (win) {
            stage.setScene(scenes[2].scene);
        }if(gameOver){
            stage.setScene(scenes[3].scene);
        }
    }
}
