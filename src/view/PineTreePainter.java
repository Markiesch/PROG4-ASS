package view;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import model.Tree;

public class PineTreePainter extends TreePainter {
    private static final double BORDER_WIDTH = 3;
    private static final double STEM_WIDTH = 20;
    private static final double STEM_OFFSET = 50;
    private static final double LEAF_HEIGHT = 180;
    private static final double LEAF_WIDTH = 120;
    private static final double STEM_HEIGHT = 20 + STEM_OFFSET;

    @Override
    protected Pane createTreePane(Tree tree) {
        Pane treePane = new Pane();

        treePane.getChildren().addAll(
                getStem(),
                getLeaf(tree)
        );
        return treePane;
    }

    private static Path getLeaf(Tree tree) {
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
        path.setFill(tree.getSize().getColor());

        return path;
    }

    private static Pane getStem() {
        Pane stem = new Pane();
        stem.setPrefSize(STEM_WIDTH, STEM_HEIGHT);
        stem.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                new BorderWidths(BORDER_WIDTH)
                        )
                )
        );

        stem.setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, null)));

        stem.setLayoutX(LEAF_WIDTH / 2 - STEM_WIDTH / 2);
        stem.setLayoutY(LEAF_HEIGHT - STEM_OFFSET);
        return stem;
    }
}
