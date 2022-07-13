package main;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class GameScene {

    public Pane root = new Pane();
    public Scene scene;
    public GameImage background;
    public ImageView backgroundView;

    public GameScene(double width, double hight, Color piantFill){
        scene = new Scene(root, width, hight, piantFill);
        //scene.getStylesheets().add(styleSheet);
        background = new GameImage("Image/arkanoid.gif", width, hight);
        backgroundView = new ImageView(background);
        root.getChildren().add(backgroundView);
    }
}
