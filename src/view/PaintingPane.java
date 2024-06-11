package view;

import controller.Controller;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Tree;
import model.TreeType;

import java.io.InputStream;
import java.util.List;

public class PaintingPane extends StackPane {
    private static final byte AUTHOR_TEXT_SIZE = 20;

    private final Pane contentPane;
    private final Controller controller;
    private final Text authorText;

    public PaintingPane(Controller controller, double width, double height) {
        super();
        this.controller = controller;

        setPrefSize(width, height);

        createBackgroundPane();

        contentPane = new Pane();

        BorderPane hAlignment = new BorderPane();
        hAlignment.setPadding(new Insets(20));

        authorText = new Text("Mark Schuurmans");
        authorText.setTextAlignment(TextAlignment.RIGHT);


        authorText.setTextOrigin(VPos.BOTTOM);

        BorderPane vAlignment = new BorderPane();
        hAlignment.setRight(vAlignment);
        vAlignment.setBottom(authorText);
        getChildren().addAll(contentPane, hAlignment);

        hAlignment.setMouseTransparent(true);

        Platform.runLater(this::renderWorld);
    }

    public void renderWorld() {
        contentPane.getChildren().clear();

        List<Tree> trees = controller.getWorld().getTrees();
        for (int i = 0; i < trees.size(); i++) {
            Tree tree = trees.get(i);
            TreePainter treePainter = tree.getType() == TreeType.LEAF ? new LeafTreePainter() : new PineTreePainter();
            Pane treePane = treePainter.createTree(this.getLayoutBounds(), tree);

            contentPane.getChildren().add(treePane);

            final int index = i;
            treePane.setOnDragDetected(event -> {
                Dragboard db = treePane.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(Integer.toString(index));
                db.setContent(content);
                event.consume();
            });
        }

        contentPane.setOnDragOver(event -> {
            if (event.getGestureSource() != contentPane && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        contentPane.setOnDragDropped(event -> {
            int index = Integer.parseInt(event.getDragboard().getString());
            Tree targetTree = trees.get(index);
            targetTree.setRelY(Math.max(50, event.getY() / contentPane.getHeight() * 100));

            targetTree.setRelX(event.getX() / contentPane.getWidth() * 100);
            renderWorld();

            event.setDropCompleted(true);
            event.consume();
        });
    }

    public void refreshAuthorText(String font) {
        InputStream fontStream = getClass().getResourceAsStream("../resources/fonts/" + font + ".ttf");
        authorText.setFont(Font.loadFont(fontStream, AUTHOR_TEXT_SIZE));
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
