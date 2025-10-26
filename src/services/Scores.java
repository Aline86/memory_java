package services;

import entities.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class Scores {

    private StringProperty faceRetournees;
    private StringProperty tentatives;
    private Player player;

    private List<Player> players;

    public Scores(int faceRetournees, int tentatives) {
        this.faceRetournees = new SimpleStringProperty(Integer.toString(faceRetournees));
        this.tentatives = new SimpleStringProperty(Integer.toString(tentatives));
        this.players = new ArrayList<Player>();
    }

    public StringProperty getTentatives() {
        return tentatives;
    }

    public void setTentatives(int tentatives) {
        this.tentatives.set(Integer.toString(tentatives));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
    public boolean checkIfFinished() {
        return Integer.parseInt(getFaceRetournees().getValue()) == 8;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public StringProperty getFaceRetournees() {
        return faceRetournees;
    }

    public StringProperty faceRetourneesProperty() {
        return faceRetournees;
    }

    public void setFaceRetournees(int faceRetournees) {
        this.faceRetournees.set(Integer.toString(faceRetournees));
    }
}
