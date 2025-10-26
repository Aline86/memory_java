package entities;

public class Tile {
    private String url;
    private TilePosition position;
    private boolean found;

    public Tile(String url, TilePosition position) {
        this.url = url;
        this.position = position;
        this.found = false;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TilePosition getPosition() {
        return position;
    }

    public void setPosition(TilePosition position) {
        this.position = position;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }
}
