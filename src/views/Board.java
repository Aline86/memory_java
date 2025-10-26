package views;

import entities.FullBoard;
import entities.Tile;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import services.AddElementToPaneCreator;
import utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Board {
    private AddElementToPaneCreator elementCreatorService;
    FullBoard fullBoard;
    public Board(AddElementToPaneCreator elementCreatorService) {
        this.elementCreatorService = elementCreatorService;
        this.fullBoard = new FullBoard();
    }

    public TilePane createBodyTilesBoard() {
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(4);
        tilePane.setPrefRows(4);
        tilePane.setMaxSize(800, 800);
        tilePane.setTileAlignment( Pos.BOTTOM_LEFT );

        HashMap<Tile, ImageView> shuffled = new HashMap<>();
        List<Tile> tiles = this.initBoard();
        for(Tile tile : tiles) {
            ImageView imageView = elementCreatorService.addTileToPane(tilePane,  tile);
            shuffled.put(tile, imageView);

        }

        this.fullBoard.setTiles(shuffled);

        return tilePane;
    }
    public List<Tile> initBoard() {
        List<Tile> tiles = new ArrayList<>();
        List<String> urls = Utils.getImageUrls();
        List<String> slice = new ArrayList<>(urls.subList(0, 8));
        List<String> urls_avec_dupplicats = new ArrayList<>();
        urls_avec_dupplicats.addAll(slice);
        urls_avec_dupplicats.addAll(slice);
        int count = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                Tile tile = Utils.createTile(urls_avec_dupplicats, count, i, j);
                tiles.add(tile);
                count++;
            }
        }
        Collections.shuffle(tiles);

        return tiles;

    }
}
