package levels;

import javafx.scene.paint.Color;

public class BigBoss extends blocks{

    public static int hp;
    public static boolean isDestroyed = false;

    public BigBoss (double x, double y, double w, double h, Color color, String type, int hp){
        super(x, y, w, h, color, type);
        setTranslateX(x);
        setTranslateY(y);
        this.hp = hp;
    }

    public void moveLeft(){
        setTranslateX(getTranslateX()+10);
    }
    public void moveRight(){
        setTranslateX(getTranslateX()-10);
    }

    @Override
    public String toString() {
        return  "Boss hp: " + hp ;
    }
}
