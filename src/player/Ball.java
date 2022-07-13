package player;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.BoundingBox;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.*;
import levels.*;
import static levels.BigBoss.hp;

public class Ball {

    int deltaY = -3;
    int deltaX = 3;
    int bossDeltaX = 8;
    public  static boolean gameOver = false;

    ImageView paddleX;
    ImageView ball; // we can change the picture
    Paddle paddle=new Paddle();

    public Ball () {
        ball = new ImageView("/image/ball.png");
        paddleX = new ImageView("/image/paddle.png");
    }

    public void draw(ImageView ball){
        this.ball=ball;
        ball.setCache(true);
        ball.setY(500);
        ball.setX(500);
        paddle.draw(paddleX);
}

  //Function Add is the movement of the ball and the movement of the paddle along with their collisions

     public void Add(blocks[] hit_me){
        //movement of paddle & addition;
        paddle.Add();
        Main.scenes[1].root.getChildren().add(ball);
        //movement of the ball & Boundaries
         Timeline timeline = new Timeline(new KeyFrame(Duration.millis(15), (evt1)->{
             ball.setX(ball.getX() + deltaX);
             ball.setY(ball.getY() + deltaY);

             BoundingBox bounds=new BoundingBox(0, 0, 1000, 600);

             final boolean atRightBorder = ball.getX() >= (bounds.getMaxX()-ball.getImage().getWidth()/2-7);
             final boolean atLeftBorder = ball.getX() <= (bounds.getMinX() + ball.getImage().getWidth()/2-12);
             final boolean atTopBorder = ball.getY() <= (bounds.getMinY() + ball.getImage().getWidth()/2-5);

             if (ball.getY() >= 600){
                 System.out.println("game over");
                 gameOver = true;

             }

             if (atRightBorder || atLeftBorder) {
                 deltaX *= -1;
                 }
                 if (atTopBorder) {
                 deltaY *= -1;
                 }

             if(ball.getBoundsInParent().intersects(paddleX.getLayoutBounds())) {
                 deltaY=-deltaY;
             }

//             powerUps.Add(ball, paddleX);

           for (int a = 0; a < blocks.numberOfBlocksActive; a++) {
               if(hit_me[a] != null){
                   if(ball.getBoundsInParent().intersects(hit_me[a].getBoundsInParent())) {
                       deltaX = -deltaX;

                       hit_me[a].setWidth(-1);
                       hit_me[a].setHeight(-1);
                       Main.itemsInScene--;
                   }
               }
           }
         }));
         //to keep the ball moving indefinitely
         timeline.setCycleCount(Animation.INDEFINITE);
         timeline.play();

     }

    public void Add(BigBoss bossBrick){
        //movement of paddle & addition;
        paddle.Add();
        Main.scenes[1].root.getChildren().add(ball);
        //movement of the ball & Boundaries
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(15), (evt1)->{
            ball.setX(ball.getX() + deltaX);
            ball.setY(ball.getY() + deltaY);

            bossBrick.setX(bossBrick.getX() + bossDeltaX);

            BoundingBox bounds=new BoundingBox(0, 0, 1000, 600);

            final boolean bossAtRightBorder = bossBrick.getX() >= (400);
            final boolean bossAtLeftBorder = bossBrick.getX() <= (-300);

            if (ball.getY() >= 600){
                System.out.println("game over");
                gameOver = true;

            }

            if(bossAtRightBorder || bossAtLeftBorder) {
                bossDeltaX *= -1;
            }

            final boolean atRightBorder = ball.getX() >= (bounds.getMaxX()-ball.getImage().getWidth()/2-7);
            final boolean atLeftBorder = ball.getX() <= (bounds.getMinX() + ball.getImage().getWidth()/2-12);
            final boolean atTopBorder = ball.getY() <= (bounds.getMinY() + ball.getImage().getWidth()/2-5);

            if (atRightBorder || atLeftBorder) {
                deltaX *= -1;
            }
            if (atTopBorder) {
                deltaY *= -1;
            }

            if(ball.getBoundsInParent().intersects(paddleX.getLayoutBounds())) {
                deltaY=-deltaY;
            }
            String s = String.valueOf(hp);
            Text hpCounter = new Text("Boss hp: "+s);
            if(ball.getBoundsInParent().intersects(bossBrick.getBoundsInParent())) {
                blocks whiteBG = new blocks(50, 30, 100, 30, Color.WHITE, "BG");
                Main.scenes[1].root.getChildren().add(whiteBG);
                Main.scenes[1].root.getChildren().add(hpCounter);
                hpCounter.setY(50);
                hpCounter.setX(50);
                hpCounter.setFill(Color.BLACK);
                deltaX =-deltaX;
                deltaY=-deltaY;
                bossDeltaX = -bossDeltaX;
                hp -= 4;
            }
            if (hp <= 0){
                hp = 0;
                bossBrick.setHeight(-1);
                bossBrick.setWidth(-1);
                bossBrick.isDestroyed = true;
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE); //to keep the ball moving indefinitely
        timeline.play();

    }
}