package main;

import javafx.scene.Group;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameSlider extends Slider {

    private Text sliderText;
    double value;

    public GameSlider (Pane root, String Text, double x, double y){
        sliderText = new Text(x, y, Text);

        root.getChildren().add(sliderText);

        sliderText.setFill(Color.WHITE);
        sliderText.setFont(new Font(20));
        super.setTranslateX(x);
        super.setTranslateY(y + 10);
        super.setMin(0);
        super.setMax(100);
        super.setValue(100);
        value = super.getValue();
    }
}
