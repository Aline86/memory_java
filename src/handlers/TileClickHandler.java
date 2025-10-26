package handlers;

import entities.Tile;
import enums.GameState;
import services.ScoreUpdater;
import services.Scores;

import java.util.*;

import static enums.GameState.*;

public class TileClickHandler {
    GameFinishedHandler gameFinishedHandler;
    Scores scores;
    ActionOnClickHandler actionService = new ActionOnClickHandler();
    ArrayList<Tile> tmpClickedTiles;
    public TileClickHandler(Scores scores) {

        this.scores = scores;
        this.actionService = new ActionOnClickHandler();
        this.tmpClickedTiles = new ArrayList<>();
    }


    public GameState clickHandler(Tile tile) {


        this.addToTmpClickedTiles(tile);
        if(tmpClickedTiles.size() < 2) {

            return WAITING_PAIR;
        } else if (tmpClickedTiles.size() == 2) {
            if(checkEntries()) {
                this.tmpClickedTiles.clear();

                return PAIR_FOUND;
            }
            if(this.scores.checkIfFinished()) {
                scores.setTentatives(0);
                scores.setFaceRetournees(0);

                return FINISHED;

            }

        }

        return PAIR_NOT_FOUND;


    }
    public void addToTmpClickedTiles(Tile tile) {

        tmpClickedTiles.add(tile);
    }

    public boolean checkEntries() {
        List<String> urls = tmpClickedTiles.stream()
                .map(Tile::getUrl)
                .toList();

        return urls.size() != new HashSet<>(urls).size();


    }

    public ArrayList<Tile> getTmpClickedTiles() {
        return tmpClickedTiles;
    }


}
