package nl.markschuurmans.painting.view;

import javafx.scene.layout.Pane;
import nl.markschuurmans.painting.model.Tree;

public abstract class TreePainter {
    protected abstract Pane createTreePane(Tree tree);

    public Pane createTree(Tree tree) {


        return createTreePane(tree);
    }
}
