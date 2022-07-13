package main;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.Border;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class GameToggleButton extends ToggleButton {

    BorderWidths borderWidths = new BorderWidths(1);
    BorderStroke borderStroke = new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,null,borderWidths);
    Border border = new Border(borderStroke);
    private double width = 100;
    private double hight = 40;

    public GameToggleButton(String buttonText, double x, double y){
        super(buttonText);
        super.setTranslateX(x);
        super.setTranslateY(y);
        super.setBackground(null);
        super.setTextFill(Color.WHITE);
        super.setBorder(border);
        super.setPrefSize(width, hight);
        super.setOnMouseClicked(event -> {
            if (super.isSelected()) {
                super.setBackground(new Background(new BackgroundFill(Color.rgb(56,56,56),null,null)));
            }else {
                super.setBackground(null);
            }
        });
    }
}
