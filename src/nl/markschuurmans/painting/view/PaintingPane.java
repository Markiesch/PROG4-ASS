package nl.markschuurmans.painting.view;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import nl.markschuurmans.painting.model.Tree;
import nl.markschuurmans.painting.model.TreeSize;
import nl.markschuurmans.painting.model.TreeType;

public class PaintingPane extends StackPane {
    private final Pane contentPane;

    public PaintingPane() {
        super();


        contentPane = new Pane();
        createBackgroundPane();
        getChildren().add(contentPane);
        addTree(new LeafTreePainter());
    }

    public void addTree(TreePainter treePainter) {
        Tree tree = new Tree(
                TreeSize.L,
                TreeType.LEAF,
                50,
                10
        );

        Pane treePane = treePainter.createTreePane(tree);

        contentPane.getChildren().add(treePane);
    }

    private void createBackgroundPane() {
        Pane backgroundPane = new VBox();

        Pane skyPane = new Pane();
        Pane groundPane = new Pane();

        // Make panes 50% height
        VBox.setVgrow(skyPane, Priority.ALWAYS);
        VBox.setVgrow(groundPane, Priority.ALWAYS);

        skyPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        groundPane.setBackground(new Background(new BackgroundFill(Color.GOLD, null, null)));

        backgroundPane.getChildren().addAll(skyPane, groundPane);
        getChildren().add(backgroundPane);
    }
}
