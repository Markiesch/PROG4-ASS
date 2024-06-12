package model;

public enum TreeSize {
    S(0.2),
    M(0.4),
    L(0.6),
    XL(0.8),
    XXL(1);

    private final double scale;

    TreeSize(double scale) {
        this.scale = scale;
    }

    public double getScale() {
        return scale;
    }
}
