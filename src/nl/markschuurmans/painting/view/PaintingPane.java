package nl.markschuurmans.painting.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import nl.markschuurmans.painting.controller.Controller;
import nl.markschuurmans.painting.model.Tree;
import nl.markschuurmans.painting.model.TreeType;

import java.io.InputStream;

public class PaintingPane extends StackPane {
    private static final byte AUTHOR_TEXT_SIZE = 40;

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
        refreshAuthorText();

        BorderPane vAlignment = new BorderPane();
        hAlignment.setRight(vAlignment);
        vAlignment.setBottom(authorText);
        getChildren().addAll(contentPane, hAlignment);

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

    public void refreshAuthorText() {
        InputStream fontStream = getClass().getResourceAsStream("../resources/fonts/GreatVibes.ttf");
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
