package player;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.*;

public class Paddle {

    Pane root;
    ImageView paddle;

    public Paddle () {
        paddle = new ImageView("/image/paddle.png");
    }

    public void draw(ImageView paddle){

        this.paddle = paddle;
        paddle.setCache(true);
        paddle.setY(600-paddle.getImage().getHeight());
        paddle.setX((1000-paddle.getImage().getWidth())/2);

    }
    public void Add(){

        Main.scenes[1].root.getChildren().add(paddle);
        Main.scenes[1].root.setOnMouseMoved(e -> {
            if(e.getX() > 1000-paddle.getImage().getWidth()) {
                paddle.setX((1000-paddle.getImage().getWidth()));
            }else{
                paddle.setX(e.getX());
            }
        });

    }}

//paddle.setX(e.getX())