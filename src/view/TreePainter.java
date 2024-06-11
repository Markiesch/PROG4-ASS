package view;

import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import model.Tree;

public abstract class TreePainter {
    /**
     * Create a pane containing the tree.
     * @param tree The tree to paint
     * @return The pane containing the tree
     */
    protected abstract Pane createTreePane(Tree tree);

    /**
     * Create a pane containing the tree, scaled and positioned according to the tree's properties.
     *
     * @param bounds The bounds of the canvas
     * @param tree The tree to paint
     * @return The pane containing the tree
     */
    public Pane createTree(Bounds bounds, Tree tree) {
        Pane treePane = createTreePane(tree);

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
}
