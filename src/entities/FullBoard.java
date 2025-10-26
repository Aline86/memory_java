package entities;

import javafx.scene.image.ImageView;

import java.util.HashMap;

public class FullBoard {

    public static HashMap<Tile, ImageView>  tiles;


    public static HashMap<Tile, ImageView> getTiles() {
        return tiles;
    }

    public void setTiles(HashMap<Tile, ImageView> tiles) {
        FullBoard.tiles = tiles;
    }
}
