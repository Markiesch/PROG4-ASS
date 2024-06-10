package nl.markschuurmans.painting.view;

import javafx.scene.layout.Pane;
import nl.markschuurmans.painting.model.Tree;
import nl.markschuurmans.painting.model.TreeSize;

public class LeafTreePainter extends TreePainter {
    @Override
    protected Pane createTreePane(Tree tree) {
        Pane treePane = new Pane();
        treePane.setPrefSize(10, 10);
        treePane.setStyle("-fx-background-color: brown; -fx-border-color: black; -fx-border-width: 1px; -fx-border-radius: 50%;");
        return treePane;
    }
}
