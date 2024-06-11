package nl.markschuurmans.painting.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import nl.markschuurmans.painting.controller.Controller;
import nl.markschuurmans.painting.model.TreeType;

public class PaintingScene extends Scene {
    private static final int INITIAL_WIDTH = 800;
    private static final int INITIAL_HEIGHT = 600;
    private final Controller controller;
    private final PaintingPane paintingPane;

    public PaintingScene(Controller controller) {
        super(new Pane());
        this.controller = controller;
        paintingPane = new PaintingPane(controller, INITIAL_WIDTH, INITIAL_HEIGHT);
        // Make the painting pane grow with the window
        VBox.setVgrow(paintingPane, Priority.ALWAYS);

        VBox root = new VBox(getMenuBar(), paintingPane);
        setRoot(root);

        // Refresh the painting when the window is resized
        widthProperty().addListener((observable, oldValue, newValue) -> paintingPane.renderWorld());
        heightProperty().addListener((observable, oldValue, newValue) -> paintingPane.renderWorld());
    }

    public void renderWorld() {
        paintingPane.renderWorld();
    }

    private MenuBar getMenuBar() {
        Menu fileMenu = new Menu("File");
        MenuItem loadPaintingMenuItem = new MenuItem("load painting...");
        MenuItem savePaintingAsMenuItem = new MenuItem("save painting as...");
        MenuItem exitMenuItem = new MenuItem("exit");
        fileMenu.getItems().addAll(loadPaintingMenuItem, savePaintingAsMenuItem, exitMenuItem);

        loadPaintingMenuItem.setOnAction(event -> controller.readWorldFromFile());
        savePaintingAsMenuItem.setOnAction(event -> controller.saveWorldToFile());
        exitMenuItem.setOnAction(event -> controller.exit());

        Menu treeMenu = new Menu("Tree");
        MenuItem addLeafTreeMenuItem = new MenuItem("add Leaf Tree");
        MenuItem addPineTreeMenuItem = new MenuItem("add Pine Tree");
        MenuItem add100TreesMenuItem = new MenuItem("add 100 Trees");
        MenuItem clearAllTreesMenuItem = new MenuItem("clear all Trees");
        treeMenu.getItems().addAll(addLeafTreeMenuItem, addPineTreeMenuItem, add100TreesMenuItem, clearAllTreesMenuItem);

        addLeafTreeMenuItem.setOnAction(event -> controller.addTree(TreeType.LEAF));
        addPineTreeMenuItem.setOnAction(event -> controller.addTree(TreeType.LEAF));
        add100TreesMenuItem.setOnAction(event -> controller.addRandomTrees(100));
        clearAllTreesMenuItem.setOnAction(event -> controller.clearTrees());

        Menu autographFontMenu = new Menu("Autograph font");
        RadioMenuItem greatVibesMenuItem = new RadioMenuItem("GreatVibes");
        RadioMenuItem handdnaMenuItem = new RadioMenuItem("handdna");
        RadioMenuItem leckerliOneMenuItem = new RadioMenuItem("LeckerliOne");

        ToggleGroup group = new ToggleGroup();
        greatVibesMenuItem.setToggleGroup(group);
        handdnaMenuItem.setToggleGroup(group);
        leckerliOneMenuItem.setToggleGroup(group);

        autographFontMenu.getItems().addAll(greatVibesMenuItem, handdnaMenuItem, leckerliOneMenuItem);

        greatVibesMenuItem.setOnAction(event -> paintingPane.refreshAuthorText("GreatVibes"));
        handdnaMenuItem.setOnAction(event -> paintingPane.refreshAuthorText("handdna"));
        leckerliOneMenuItem.setOnAction(event -> paintingPane.refreshAuthorText("LeckerliOne"));

        paintingPane.refreshAuthorText("LeckerliOne");
        greatVibesMenuItem.setSelected(true);

        Menu movieMenu = new Menu("Movie");
        CheckMenuItem playMenuItem = new CheckMenuItem("play");
        movieMenu.getItems().add(playMenuItem);

        playMenuItem.setOnAction(event -> controller.setPlaying(playMenuItem.isSelected()));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, treeMenu, autographFontMenu, movieMenu);
        return menuBar;
    }
}
