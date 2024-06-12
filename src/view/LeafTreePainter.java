package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;

public class LeafTreePainter extends TreePainter {
    private static final double LEAF_SIZE = 150;

    @Override
    protected Shape getTreeLeaf() {
        Circle leaf = new Circle(LEAF_SIZE / 2);

        leaf.setCenterX(LEAF_SIZE / 2);
        leaf.setCenterY(LEAF_SIZE / 2);

        leaf.setStroke(Color.BLACK);
        leaf.setStrokeWidth(BORDER_WIDTH);
        leaf.setStrokeType(StrokeType.INSIDE);
        return leaf;
    }
}
