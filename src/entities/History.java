package entities;

import java.text.DateFormat;

public class History {
    private DateFormat datetime;
    private String name;
    private int score;

    public History(String name, DateFormat datetime, int score) {
        this.name = name;
        this.datetime = datetime;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public DateFormat getDatetime() {
        return datetime;
    }

    public void setDatetime(DateFormat datetime) {
        this.datetime = datetime;
    }
}
