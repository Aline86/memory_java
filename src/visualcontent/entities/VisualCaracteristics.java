package visualcontent.entities;

public class VisualCaracteristics {
    private int marginLeft;
    private int marginRight;
    private int width;
    private int height;
    private ElementPosition position;

    public VisualCaracteristics(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public VisualCaracteristics(int width, int height, int marginLeft, int marginRight) {
        this(width, height);
        this.marginRight = marginRight;
        this.marginLeft = marginLeft;

    }
    public VisualCaracteristics(int width, int height, int marginLeft, int marginRight, ElementPosition position) {
        this(width, height, marginLeft, marginRight);
        this.position = position;
        this.marginRight = marginRight;
        this.marginLeft = marginLeft;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public ElementPosition getPosition() {
        return position;
    }

    public void setPosition(ElementPosition position) {
        this.position = position;
    }
}
