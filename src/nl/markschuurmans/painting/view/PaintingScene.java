package nl.markschuurmans.painting.view;

import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nl.markschuurmans.painting.controller.Controller;
import nl.markschuurmans.painting.model.World;

public class PaintingScene extends Scene {
    public PaintingScene(Controller controller, World world) {
        super(new Pane());


        Menu fileMenu = new Menu("File");
        MenuItem loadPaintingMenuItem = new MenuItem("load painting...");
        MenuItem savePaintingAsMenuItem = new MenuItem("save painting as...");
        MenuItem exitMenuItem = new MenuItem("exit");
        fileMenu.getItems().addAll(loadPaintingMenuItem, savePaintingAsMenuItem, exitMenuItem);

        loadPaintingMenuItem.setOnAction(event -> { controller.readWorldFromFile(); });
        savePaintingAsMenuItem.setOnAction(event -> { controller.saveWorldToFile(); });

        Menu treeMenu = new Menu("Tree");
        MenuItem addLeafTreeMenuItem = new MenuItem("add Leaf Tree");
        MenuItem addPineTreeMenuItem = new MenuItem("add Pine Tree");
        MenuItem add100TreesMenuItem = new MenuItem("add 100 Trees");
        MenuItem clearAllTreesMenuItem = new MenuItem("clear all Trees");
        treeMenu.getItems().addAll(addLeafTreeMenuItem, addPineTreeMenuItem, add100TreesMenuItem, clearAllTreesMenuItem);

        Menu movieMenu = new Menu("Movie");
        CheckMenuItem playMenuItem = new CheckMenuItem("play");
        movieMenu.getItems().add(playMenuItem);

        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().addAll(fileMenu, treeMenu, movieMenu);

        VBox root = new VBox(menuBar, new PaintingPane(world, 800, 600));
        setRoot(root);
    }
}
