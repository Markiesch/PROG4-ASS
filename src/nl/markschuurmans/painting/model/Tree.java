package nl.markschuurmans.painting.model;

public class Tree {
    private final TreeSize size;
    private final TreeType type;
    private final double relX;
    private final double relY;

    public Tree(TreeSize size, TreeType type, double relX, double relY) {
        this.size = size;
        this.type = type;
        this.relX = relX;
        this.relY = relY;
    }

    public void move() {}

    public TreeSize getSize() {
        return size;
    }

    public TreeType getType() {
        return type;
    }

    public double getRelX() {
        return relX;
    }

    public double getRelY() {
        return relY;
    }

    public double getFinalScale() {
        System.out.println(0.018 * getRelY() - 0.8);
        return getSize().getScale() * (0.018 * getRelY() - 0.8);
    }
}
