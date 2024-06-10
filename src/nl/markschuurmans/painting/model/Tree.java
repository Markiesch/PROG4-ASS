package nl.markschuurmans.painting.model;

public class Tree {
    private final TreeType type;
    private final TreeSize size;
    private double relX;
    private final double relY;

    public Tree(TreeType type, TreeSize size, double relX, double relY) {
        this.type = type;
        this.size = size;
        this.relX = relX;
        this.relY = relY;
    }

    public void move() {
        setRelX(getRelX() + 0.001 * getRelY());
    }

    public TreeType getType() {
        return type;
    }

    public TreeSize getSize() {
        return size;
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

    public double getFinalScale() {
        return getSize().getScale() * (0.018 * getRelY() - 0.8);
    }
}
