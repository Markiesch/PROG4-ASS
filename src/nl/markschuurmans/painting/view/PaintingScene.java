package nl.markschuurmans.painting.view;

import javafx.scene.Scene;
import nl.markschuurmans.painting.model.World;

public class PaintingScene extends Scene {
    public PaintingScene(World world) {
        super(new PaintingPane(world, 800, 600));
    }
}
