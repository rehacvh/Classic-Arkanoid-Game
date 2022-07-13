package mainMenu;

import javafx.scene.layout.Pane;
import main.GameButton;

public class MainMenuButtons {
    public GameButton startGame;
    public GameButton endGame;

    public MainMenuButtons(Pane root, double x, double y){

        startGame = new GameButton("Start Game", x, y);
        endGame = new GameButton("Quit", x, y + 50);

        root.getChildren().add(startGame);
        root.getChildren().add(endGame);
    }
}
