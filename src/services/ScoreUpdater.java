package services;

import entities.Tile;
import javafx.scene.image.ImageView;

import java.util.*;


public class ScoreUpdater {
    HashMap<Tile, ImageView> tileListe ;
    Scores scores;
    private AddElementToPaneCreator elementCreatorService;

    public ScoreUpdater(Scores scores, int playerInList) {
        this.scores = scores;
        this.scores.setPlayer(this.scores.getPlayers().get(playerInList));

    }

    public void setScore(boolean pairFound) {
        if(pairFound) {
            this.setFacesTurned();
        }

        this.setTotalAttempts();
    }
    private void setFacesTurned(){
        int faceRetournees = Integer.parseInt(this.scores.getFaceRetournees().get());
        this.scores.setFaceRetournees(faceRetournees + 1);
    }
    private void setTotalAttempts(){
        int integerTentative = Integer.parseInt(this.scores.getTentatives().get());
        this.scores.setTentatives(integerTentative + 1);
    }

}
