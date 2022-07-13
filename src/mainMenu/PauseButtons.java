package mainMenu;

import javafx.scene.layout.Pane;
import main.GameButton;

public class PauseButtons {
    public GameButton Continue;
    public GameButton sound;
    public GameButton back;
    public PauseButtons (Pane root, double x, double y){
        Continue = new GameButton("sound", x, y);
        sound = new GameButton("sound", x, y + 50);
        back = new GameButton("back to main menu", x, y + 100);

        root.getChildren().add(Continue);
        root.getChildren().add(sound);
        root.getChildren().add(back);
    }
}
