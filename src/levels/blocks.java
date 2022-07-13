package levels;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class blocks extends Rectangle {
    public String type;
    public static int numberOfBlocksActive;

    public blocks(double x, double y, double w, double h, Color color, String type){
        super(w, h, color);
        setTranslateX(x);
        setTranslateY(y);
        this.type = type;
    }

}
