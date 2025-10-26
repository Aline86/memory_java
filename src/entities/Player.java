package entities;

public class Player {
    private final String name;
    private int score;
    private String boardColor;

    public Player(String name, int score, String boardColor) {
        this.name = name;
        this.score = score;
        this.boardColor = boardColor;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBoardColor() {
        return boardColor;
    }

    public void setBoardColor(String boardColor) {
        this.boardColor = boardColor;
    }
}
