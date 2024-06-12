package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class PineTreePainter extends TreePainter {
    private static final double LEAF_HEIGHT = 180;
    private static final double LEAF_WIDTH = 120;

    @Override
    protected Shape getTreeLeaf() {
        Path path = new Path();

        path.getElements().addAll(
                new MoveTo(LEAF_WIDTH / 2, 0),
                new LineTo(0, LEAF_HEIGHT - 20),
                new QuadCurveTo(LEAF_WIDTH / 2, LEAF_HEIGHT, LEAF_WIDTH, LEAF_HEIGHT - 20),
                new ClosePath()
        );

        path.setStroke(Color.BLACK);
        path.setStrokeWidth(BORDER_WIDTH);
        path.setStrokeType(StrokeType.INSIDE);

        return path;
    }
}
