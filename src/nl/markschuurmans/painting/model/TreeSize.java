package nl.markschuurmans.painting.model;

import javafx.scene.paint.Color;

public enum TreeSize {
    S(Color.LIME),
    M(Color.LIMEGREEN),
    L(Color.LIGHTGREEN),
    XL(Color.GREEN),
    XXL(Color.DARKGREEN);

    private final Color color;

    TreeSize(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
