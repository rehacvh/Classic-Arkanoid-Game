package main;

import javafx.scene.image.Image;

public class GameImage extends Image {

    public GameImage(String url, double requestedWidth, double requestedHeight){
        super(url,requestedWidth, requestedHeight, false, true,true);
    }
}
