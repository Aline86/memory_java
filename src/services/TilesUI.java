package services;

import entities.Tile;
import handlers.TileClickHandler;
import javafx.scene.image.ImageView;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;

public class TilesUI {
    private void removeDisableTiles(HashMap<Tile, ImageView> tiles, Tile picture) {
        if(!picture.isFound()) {
            tiles.get(picture).setDisable(false);
        }
    }
    public void animateTiles(HashMap<Tile, ImageView> tiles, ArrayList<Tile> tilesPair) {
        for(Tile picture : tilesPair) {
            Utils.fadeInWithDelay(tiles.get(picture), 0, 0.5);

            this.removeDisableTiles(tiles, picture);
        }
    }
    public void waitForSecondTile(HashMap<Tile, ImageView> tiles, ArrayList<Tile> tilesPair) {
        for(Tile picture : tilesPair) {
            tiles.get(picture).setOpacity(1);
        }
    }
    public void setFoundTiles(HashMap<Tile, ImageView> tiles, ArrayList<Tile> tilesPair) {
        for (Tile picture : tilesPair) {
            picture.setFound(true);
            tiles.get(picture).setDisable(true);
            tiles.get(picture).setOpacity(1);

        }
    }

}
