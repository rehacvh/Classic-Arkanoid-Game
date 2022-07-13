package main;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import levels.BigBoss;
import levels.blocks;
import player.Collisions;

public class GamePlay {

    Pane root;
    Collisions collision;
    BigBoss bb;
    double width = 65;
    double Height = 35;

   public GamePlay (Pane root) {
       this.root = root;
       collision = new Collisions(root);
   }

    public void level_1(){
        Main.level = 0;
        Color c = Color.LIGHTSKYBLUE;
        blocks[] brick = new blocks[100];

        try {
            collision.Collision(brick);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        blocks.numberOfBlocksActive = 0;
        for (int i = 0; i<3; i++) {
            for (int j = 0;j<3; j++) {
                brick[blocks.numberOfBlocksActive] = new blocks(200 + i * 130, 150 + j * 90, width, Height, c, "brick");
                //adding the bricks to the scene;
                root.getChildren().add(brick[blocks.numberOfBlocksActive]);
                Main.itemsInScene++;
                blocks.numberOfBlocksActive++;
            }
        }


    }

    public void level_2() {
        blocks[] brick = new blocks[100];
        try {
            collision.Collision(brick);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        blocks.numberOfBlocksActive = 0;
        int grid_size = 4;
        for (int i = 0; i<grid_size; i++) {
            if(i<((grid_size/2)+1)){
                for (int j = 0; j < i; j++) {
                    brick[blocks.numberOfBlocksActive] = new blocks(200 + i * 55, 150 + j * 30, width, Height, Color.CADETBLUE, "brick");
                    //adding the bricks to the scene;
                    root.getChildren().add(brick[blocks.numberOfBlocksActive]);
                    Main.itemsInScene++;
                    blocks.numberOfBlocksActive++;
                }
            }else{
                for (int j = (grid_size-1)-i; j >= 0 ; j--) {
                    brick[blocks.numberOfBlocksActive] = new blocks(200 + i * 55, 150 + j * 30, width, Height, Color.PALEVIOLETRED, "brick");
                    //adding the bricks to the scene;
                    root.getChildren().add(brick[blocks.numberOfBlocksActive]);
                    Main.itemsInScene++;
                    blocks.numberOfBlocksActive++;
                }
            }

        }
    }

    public void level_3(){

        blocks[] brick = new blocks[1000];
        try {
            collision.Collision(brick);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        blocks.numberOfBlocksActive = 0;
        //it only works with odd numbers;
        int grid_size = 2;
        for (int i = 0; i<grid_size; i++) {
            if(i<((grid_size/2)+1)){
                for (int j = 0; j <= i; j++) {
                    brick[blocks.numberOfBlocksActive] = new blocks(200 + i * 130, 150 + j * 90, width, Height, Color.CADETBLUE,"brick");
                    //adding the bricks to the scene;
                    root.getChildren().add(brick[blocks.numberOfBlocksActive]);
                    Main.itemsInScene++;
                    blocks.numberOfBlocksActive++;
                }
            }else{
                for (int j = (grid_size-1)-i; j >= 0 ; j--) {
                    brick[blocks.numberOfBlocksActive] = new blocks(200 + i * 130, 150 + j * 90, width, Height, Color.BLUEVIOLET, "brick");
                    //adding the bricks to the scene;
                    root.getChildren().add(brick[blocks.numberOfBlocksActive]);
                    Main.itemsInScene++;
                    blocks.numberOfBlocksActive++;
                }
            }
        }
        for (int i = 0; i < grid_size; i++) {
            if(i<((grid_size/2)+1)){
                int x = grid_size-i;
                for (int j = grid_size; j >= x; j--) {
                    brick[blocks.numberOfBlocksActive] = new blocks(200 + i * 130, 150 + j * 90, width, Height, Color.CADETBLUE, "brick");
                    //adding the bricks to the scene;
                    root.getChildren().add(brick[blocks.numberOfBlocksActive]);
                    Main.itemsInScene++;
                    blocks.numberOfBlocksActive++;
                }
            }
            else{
                for (int j = grid_size; j>i; j--) {
                    brick[blocks.numberOfBlocksActive] = new blocks(200 + i * 130, 150 + j * 90, width, Height, Color.CADETBLUE, "brick");
                    //adding the bricks to the scene;
                    root.getChildren().add(brick[blocks.numberOfBlocksActive]);
                    Main.itemsInScene++;
                    blocks.numberOfBlocksActive++;
                }
            }
        }
    }

    public void boss_level(){
        bb = new BigBoss(300, 100, 300, 150, Color.BLUEVIOLET, "boss", 20);
        try {
            collision.Collision(bb);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        blocks.numberOfBlocksActive = 0;
        root.getChildren().add(bb);
        blocks.numberOfBlocksActive = 1;
        Main.itemsInScene = 1;

    }

    public void Display(String param){
        Text loading1 = new Text(param);
        loading1.setFill(Color.BLACK);
        loading1.setFont(new Font(50));
        loading1.setX(500);
        loading1.setY(300);
        root.getChildren().add(loading1);

    }

}
