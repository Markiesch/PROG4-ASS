package nl.markschuurmans.painting.view;

import javafx.scene.layout.Pane;

public class PaintingPane extends Pane {
    public PaintingPane() {
        super();
    }

    public void addTree(TreePainter treePainter) {
        getChildren().add(treePainter.createTreePane());
    }
}
