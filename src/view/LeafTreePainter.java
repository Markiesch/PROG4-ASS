package view;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import model.Tree;

public class LeafTreePainter extends TreePainter {
    private static final double LEAF_SIZE = 150;

    @Override
    protected Node getTreeLeaf(Tree tree) {
        Circle leaf = new Circle(LEAF_SIZE / 2);

        leaf.setCenterX(LEAF_SIZE / 2);
        leaf.setCenterY(LEAF_SIZE / 2);

        leaf.setFill(tree.getSize().getColor());
        leaf.setStroke(Color.BLACK);
        leaf.setStrokeWidth(BORDER_WIDTH);
        leaf.setStrokeType(StrokeType.INSIDE);
        return leaf;
    }
}
