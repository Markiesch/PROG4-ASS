package nl.markschuurmans.painting.view;

import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import nl.markschuurmans.painting.controller.Controller;
import nl.markschuurmans.painting.model.Tree;
import nl.markschuurmans.painting.model.TreeType;

public class PaintingPane extends StackPane {
    private final Pane contentPane;
    private final Controller controller;

    public PaintingPane(Controller controller, double width, double height) {
        super();
        this.controller = controller;

        setPrefSize(width, height);

        contentPane = new Pane();
        createBackgroundPane();
        getChildren().add(contentPane);

        Platform.runLater(this::renderWorld);
    }

    public void renderWorld() {
        contentPane.getChildren().clear();

        for (Tree tree : controller.getWorld().getTrees()) {
            TreePainter treePainter = tree.getType() == TreeType.LEAF ? new LeafTreePainter() : new PineTreePainter();
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

        skyPane.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, null, null)));
        groundPane.setBackground(new Background(new BackgroundFill(Color.SANDYBROWN, null, null)));

        backgroundPane.getChildren().addAll(skyPane, groundPane);
        getChildren().add(backgroundPane);
    }
}
