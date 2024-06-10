package nl.markschuurmans.painting.view;

import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import nl.markschuurmans.painting.model.Tree;
import nl.markschuurmans.painting.model.World;

public class PaintingPane extends StackPane {
    private final Pane contentPane;

    public PaintingPane(World world, double width, double height) {
        super();

        setPrefSize(width, height);

        contentPane = new Pane();
        createBackgroundPane();
        getChildren().add(contentPane);


        Platform.runLater(() -> {
            renderWorld(world);
        });
    }

    public void renderWorld(World world) {
        contentPane.getChildren().clear();

        for (Tree tree : world.getTrees()) {
            TreePainter treePainter = new LeafTreePainter();
            Pane treePane = treePainter.createTree(this.getLayoutBounds(), tree);
            contentPane.getChildren().add(treePane);
        }
    }

    private void createBackgroundPane() {
        Pane backgroundPane = new VBox();

        Pane skyPane = new Pane();
        Pane groundPane = new Pane();

        VBox.setVgrow(skyPane, Priority.ALWAYS);
        VBox.setVgrow(groundPane, Priority.ALWAYS);

        skyPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        groundPane.setBackground(new Background(new BackgroundFill(Color.GOLD, null, null)));

        backgroundPane.getChildren().addAll(skyPane, groundPane);
        getChildren().add(backgroundPane);
    }
}
