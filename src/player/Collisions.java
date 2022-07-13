package player;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import levels.BigBoss;
import levels.blocks;

public class Collisions{

    ImageView ballX;
    ImageView paddleX;
    Paddle paddle;
    Ball ball;

    public Collisions (Pane root) {
        paddle = new Paddle();
        ball = new Ball();
        ballX = new ImageView("/image/ball.png");
        paddleX = new ImageView("/image/paddle.png");
    }

    public void Collision(blocks[] hit_me){
        paddle.draw(paddleX);
        ball.draw(ballX);
        ball.Add(hit_me);
    }
    public void Collision(BigBoss boss){
        paddle.draw(paddleX);
        ball.draw(ballX);
        ball.Add(boss);
    }
}

