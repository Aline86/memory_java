package controllers;


import entities.Tile;
import gamelauncher.prompts.ParametersApp;
import handlers.ActionOnClickHandler;
import handlers.GameFinishedHandler;
import handlers.TileClickHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import manager.StageManager;
import services.*;
import utils.Utils;
import views.Header;
import views.RightPanel;

import java.util.*;

import static enums.Actions.TILE_CLICK;

public class GameController {
    private AddElementToPaneCreator elementCreatorService;
    private ComboCreator comboCreatorService;
    private Scores scores;
    private int playerInList;
    private StageManager stageManager;
    private ScoreUpdater board;
    private TileClickHandler handler;
    ActionOnClickHandler actionService;
    HashMap<Tile, ImageView> tmpClickedTiles ;
    GameFinishedHandler gameClickFinishedHandler;
    RightPanel rightPanel;
    Header header;
    TilesUI tilesUI;

    public GameController(int playerInList, Scores scores, StageManager stageManager) {
        this.playerInList = playerInList;
        this.scores = scores;
        scores.setPlayer(scores.getPlayers().get(playerInList));
        elementCreatorService = new AddElementToPaneCreator(scores);
        this.stageManager = stageManager;
        actionService = new ActionOnClickHandler();
        gameClickFinishedHandler = new GameFinishedHandler(this.stageManager);
        this.handler = new TileClickHandler(scores);
        this.tilesUI = new TilesUI();
        this.board = new ScoreUpdater(scores, playerInList);
        this.rightPanel = new RightPanel(elementCreatorService, scores);
        this.header = new Header(elementCreatorService);
    }

    private TilePane createBodyTilesBoard() {
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

        this.initClicOnPicture(shuffled);

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

    public void initClicOnPicture(HashMap<Tile, ImageView> tiles) {
        for (Map.Entry<Tile, ImageView> entry : tiles.entrySet()) {
            Tile tile = entry.getKey();
            ImageView imageView = entry.getValue();
            imageView.setOnMouseClicked(event -> {
                this.actionService.executeAction(TILE_CLICK, imageView);
                tiles.get(tile).setDisable(true);
                ArrayList<Tile> tilesPair = this.handler.getTmpClickedTiles();
                switch (this.handler.clickHandler(tile)) {
                    case FINISHED:
                        gameClickFinishedHandler.onGameFinished(playerInList, scores);
                        break;
                    case PAIR_NOT_FOUND:
                        this.tilesUI.animateTiles(tiles, tilesPair);
                        this.handler.getTmpClickedTiles().clear();
                        this.board.setScore(false);

                        break;
                    case WAITING_PAIR:
                        this.tilesUI.waitForSecondTile(tiles, tilesPair);
                        break;
                    default:
                        this.tilesUI.setFoundTiles(tiles, tilesPair);
                        this.board.setScore(true);
                        this.handler.getTmpClickedTiles().clear();
                        break;
                }

            });
        }
    }



    public Parent createContent() {
        VBox pane = new VBox();

        // Header
        Pane header = this.header.createHeader();
        header.setPrefSize(1200, 25);
        header.setMaxSize(1200, 25);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.getChildren().add(header);

        // Body
        HBox bodyContainer = new HBox();
        bodyContainer.setMaxWidth(1200);

        TilePane board = createBodyTilesBoard();
        board.setAlignment(Pos.BOTTOM_LEFT);
        bodyContainer.getChildren().add(board);

        VBox rightPanel = this.rightPanel.createRightPanel(pane);
        rightPanel.setPrefSize(400, 800);

        bodyContainer.getChildren().add(rightPanel);

        pane.getChildren().add(bodyContainer);


        return pane;
    }

}

