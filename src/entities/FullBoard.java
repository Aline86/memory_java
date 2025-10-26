package entities;

import javafx.scene.image.ImageView;

import java.util.HashMap;

public class FullBoard {

    public HashMap<Tile, ImageView>  tiles;


    public HashMap<Tile, ImageView> getTiles() {
        return tiles;
    }

    public void setTiles(HashMap<Tile, ImageView> tiles) {
        this.tiles = tiles;
    }
}
