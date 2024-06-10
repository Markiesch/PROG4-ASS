package nl.markschuurmans.painting.model;

import javafx.scene.paint.Color;

public enum TreeSize {
    S(Color.LIME, 0.2),
    M(Color.LIMEGREEN, 0.4),
    L(Color.LIGHTGREEN, 0.6),
    XL(Color.GREEN, 0.8),
    XXL(Color.DARKGREEN, 1);

    private final Color color;
    private final double scale;

    TreeSize(Color color, double scale) {
        this.color = color;
        this.scale = scale;
    }

    public Color getColor() {
        return color;
    }

    public double getScale() {
        return scale;
    }
}
