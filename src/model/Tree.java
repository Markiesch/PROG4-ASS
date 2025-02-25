package model;

import javafx.scene.paint.Color;

public class Tree {
    private final TreeType type;
    private final TreeSize size;
    private double relX;
    private double relY;

    public Tree(TreeType type, TreeSize size, double relX, double relY) {
        this.type = type;
        this.size = size;
        this.relX = relX;
        this.relY = relY;
    }

    public void move() {
        setRelX(getRelX() + 0.25 * getRelYProcent());
        if (getRelX() > 125) setRelX(-10);
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

    public void setRelY(double relY) {
        this.relY = relY;
    }

    private double getRelYProcent() {
        return 0.018 * getRelY() - 0.8;
    }

    public double getFinalScale() {
        return getSize().getScale() * getRelYProcent();
    }

    public Color getColor() {
        return getType().getColor(getSize());
    }
}
