package nl.markschuurmans.painting.model;

public class Tree {
    private TreeSize size;
    private TreeType type;
    private double relX;
    private double relY;

    public void move() {}

    public TreeSize getSize() {
        return size;
    }

    public void setSize(TreeSize size) {
        this.size = size;
    }

    public TreeType getType() {
        return type;
    }

    public void setType(TreeType type) {
        this.type = type;
    }

    public double getRelX() {
        return relX;
    }

    public void setRelX(double relX) {
        this.relX = relX;
    }

    public double getRelY() {
        return relY;
    }

    public void setRelY(double relY) {
        this.relY = relY;
    }

}
