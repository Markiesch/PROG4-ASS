package view;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Tree;

public class LeafTreePainter extends TreePainter {
    private static final double BORDER_WIDTH = 3;
    private static final double STEM_WIDTH = 20;
    private static final double STEM_OFFSET = 10;
    private static final double LEAF_SIZE = 150;
    private static final double STEM_HEIGHT = 50 + STEM_OFFSET;

    @Override
    protected Pane createTreePane(Tree tree) {
        Pane treePane = new Pane();

        treePane.getChildren().addAll(
                getStem(),
                getLeaf(tree)
        );
        return treePane;
    }

    private static Pane getLeaf(Tree tree) {
        Pane leaf = new Pane();
        leaf.setPrefSize(LEAF_SIZE, LEAF_SIZE);
        leaf.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK,
                                BorderStrokeStyle.SOLID,
                                new CornerRadii(50, true),
                                new BorderWidths(BORDER_WIDTH)
                        )
                )
        );

        leaf.setBackground(new Background(new BackgroundFill(tree.getSize().getColor(), new CornerRadii(50, true), null)));
        return leaf;
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
                                new BorderWidths(3)
                        )
                )
        );

        stem.setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, null)));

        stem.setLayoutX(LEAF_SIZE / 2 - STEM_WIDTH / 2);
        stem.setLayoutY(LEAF_SIZE - STEM_OFFSET);
        return stem;
    }
}
