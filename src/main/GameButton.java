package main;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameButton extends Button {

    BorderWidths borderWidths = new BorderWidths(1);
    BorderStroke borderStroke = new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID,null,borderWidths);
    Border border = new Border(borderStroke);
    private double width = 100;
    private double hight = 40;
    private double UP_MAX = 15;

    public GameButton(String buttonText, double x, double y){
        super(buttonText);
        super.setTranslateX(x);
        super.setTranslateY(y);
        super.setBackground(null);
        super.setTextFill(Color.WHITE);
        super.setBorder(border);
        super.setPrefSize(width, hight);
        super.setFont(Font.font("Tahoma"));
        if (super.getText().length() >= UP_MAX){
            super.setPrefSize(width + 50,hight);
        }
        super.setEventHandler(MouseEvent.MOUSE_ENTERED, MouseEvent -> {
            if (super.getText().length() >= UP_MAX){
                super.setPrefSize(width + 50,30);
            }else {
                super.setPrefSize(width,30);
            }
        });
        super.setEventHandler(MouseEvent.MOUSE_EXITED, MouseEvent -> {
            if (super.getText().length() >= UP_MAX){
                super.setPrefSize(width + 50,hight);
            }else {
                super.setPrefSize(width, hight);
            }
        });
    }
}
