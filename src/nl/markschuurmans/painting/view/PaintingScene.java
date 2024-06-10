package nl.markschuurmans.painting.view;

import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nl.markschuurmans.painting.controller.Controller;
import nl.markschuurmans.painting.model.TreeType;

public class PaintingScene extends Scene {
    private final PaintingPane paintingPane;

    public PaintingScene(Controller controller) {
        super(new Pane());

        paintingPane = new PaintingPane(controller, 800, 600);

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

        Menu movieMenu = new Menu("Movie");
        CheckMenuItem playMenuItem = new CheckMenuItem("play");
        movieMenu.getItems().add(playMenuItem);

        playMenuItem.setOnAction(event -> controller.setPlaying(playMenuItem.isSelected()));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, treeMenu, movieMenu);

        VBox root = new VBox(menuBar, paintingPane);
        setRoot(root);
    }

    public void renderWorld() {
        paintingPane.renderWorld();
    }
}
