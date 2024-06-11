package view;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import model.Tree;

public abstract class TreePainter {
    private static final double TREE_HEIGHT = 200;
    protected static final double BORDER_WIDTH = 3;
    protected static final double STEM_WIDTH = 20;
    protected static final double STEM_OFFSET = 20;

    /**
     * Create a pane containing the tree.
     * @param tree The tree to paint
     * @return The pane containing the tree
     */
    protected abstract Node getTreeLeaf(Tree tree);

    /**
     * Create a pane containing the tree, scaled and positioned according to the tree's properties.
     *
     * @param bounds The bounds of the canvas
     * @param tree The tree to paint
     * @return The pane containing the tree
     */
    public Pane createTree(Bounds bounds, Tree tree) {
        Pane treePane = new Pane();

        Node treeLeaf = getTreeLeaf(tree);
        treePane.getChildren().addAll(
                getStem(treeLeaf.getLayoutBounds().getHeight(), treeLeaf.getLayoutBounds().getWidth()),
                treeLeaf
        );

        double scale = tree.getFinalScale();
        treePane.setScaleX(scale);
        treePane.setScaleY(scale);

        // Make sure the layout rendered before we calculate the height
        treePane.layout();

        double actualWidth = treePane.getBoundsInLocal().getWidth() * scale;
        double boxWidth = treePane.getBoundsInLocal().getWidth();
        treePane.setLayoutX((bounds.getWidth() * (tree.getRelX() / 100)) - (boxWidth + (actualWidth - boxWidth) / 2));

        double actualHeight = treePane.getBoundsInLocal().getHeight() * scale;
        double boxHeight = treePane.getBoundsInLocal().getHeight();
        treePane.setLayoutY((bounds.getHeight() * (tree.getRelY() / 100)) - (boxHeight + (actualHeight - boxHeight) / 2));

        return treePane;
    }

    protected Rectangle getStem(double leafHeight, double leafWidth) {
        Rectangle stem = new Rectangle(STEM_WIDTH, TREE_HEIGHT - leafHeight + STEM_OFFSET);
        stem.setStroke(Color.BLACK);
        stem.setStrokeWidth(BORDER_WIDTH);
        stem.setFill(Color.BROWN);

        stem.setLayoutX(leafWidth / 2 - STEM_WIDTH / 2);
        stem.setLayoutY(leafHeight - STEM_OFFSET);
        return stem;
    }
}
