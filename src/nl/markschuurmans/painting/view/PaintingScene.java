package nl.markschuurmans.painting.view;

import javafx.scene.Scene;

public class PaintingScene extends Scene {

    public PaintingScene(PaintingPane paintingPane) {
        super(paintingPane);

        paintingPane.setPrefSize(800, 600);
    }
}
