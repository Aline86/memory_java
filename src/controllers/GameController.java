package controllers;


import entities.FullBoard;
import entities.Tile;
import handlers.ActionOnClickHandler;
import handlers.GameFinishedHandler;
import handlers.TileClickHandler;
import javafx.scene.image.ImageView;
import manager.StageManager;
import services.*;
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
    private ScoreUpdater scoreUpdater;
    private TileClickHandler handler;
    ActionOnClickHandler actionService;
    HashMap<Tile, ImageView> tmpClickedTiles ;
    GameFinishedHandler gameClickFinishedHandler;
    RightPanel rightPanel;
    Header header;
    TilesUI tilesUI;
    FullBoard tiles;

    public GameController(int playerInList, Scores scores, StageManager stageManager, FullBoard tiles) {
        this.playerInList = playerInList;
        this.scores = scores;
        this.tiles = tiles;
        scores.setPlayer(scores.getPlayers().get(playerInList));
        //elementCreatorService = new AddElementToPaneCreator(scores);
        this.stageManager = stageManager;
        actionService = new ActionOnClickHandler();
        gameClickFinishedHandler = new GameFinishedHandler(this.stageManager);
        this.handler = new TileClickHandler(scores);
        this.tilesUI = new TilesUI();
        this.scoreUpdater = new ScoreUpdater(scores, playerInList);

        this.initClicOnPicture();
    }



    public void initClicOnPicture() {
        for (Map.Entry<Tile, ImageView> entry : tiles.getTiles().entrySet()) {
            Tile tile = entry.getKey();
            ImageView imageView = entry.getValue();
            imageView.setOnMouseClicked(event -> {
                this.actionService.executeAction(TILE_CLICK, imageView);
                tiles.getTiles().get(tile).setDisable(true);
                ArrayList<Tile> tilesPair = this.handler.getTmpClickedTiles();
                switch (this.handler.clickHandler(tile)) {
                    case FINISHED:
                        gameClickFinishedHandler.onGameFinished(playerInList, scores);
                        break;
                    case PAIR_NOT_FOUND:
                        this.tilesUI.animateTiles(tiles.getTiles(), tilesPair);
                        this.handler.getTmpClickedTiles().clear();
                        this.scoreUpdater.setScore(false);

                        break;
                    case WAITING_PAIR:
                        this.tilesUI.waitForSecondTile(tiles.getTiles(), tilesPair);
                        break;
                    default:
                        this.tilesUI.setFoundTiles(tiles.getTiles(), tilesPair);
                        this.scoreUpdater.setScore(true);
                        this.handler.getTmpClickedTiles().clear();
                        break;
                }

            });
        }
    }





}

