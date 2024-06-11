package controller;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Tree;
import model.TreeSize;
import model.TreeType;
import model.World;
import view.PaintingScene;

import java.io.File;
import java.net.URL;

public class Controller extends Application {
    private WorldUpdater worldUpdater;
    private PaintingScene scene;
    private Stage primaryStage;
    private World world;
    private boolean isPlaying = false;

    public void start(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        scene = new PaintingScene(this);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Mark Schuurmans - Painting");
        primaryStage.show();

        // Center the window
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((bounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((bounds.getHeight() - primaryStage.getHeight()) / 2);

        worldUpdater = new WorldUpdater(this);

        getWorld().addTree(new Tree(TreeType.LEAF, TreeSize.L, 50, 100));
    }

    public World getWorld() {
        if (world == null) {
            world = new World();
        }

        return world;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void setWorld(World world) {
        this.world = world;
        scene.renderWorld();
    }

    public void saveWorldToFile() {
        FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showSaveDialog(primaryStage);

        FileIO fileIO = new FileIO();
        fileIO.writeFile(file, world);
    }

    public void readWorldFromFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Painting files", "*.painting"));

        URL url = getClass().getResource("../resources/paintings");
        if (url != null) {
            fileChooser.setInitialDirectory(new File(url.getPath()));
        }

        File file = fileChooser.showOpenDialog(primaryStage);

        FileIO fileIO = new FileIO();
        World world = fileIO.readFile(file);

        if (world != null) {
            setWorld(world);
        }
    }

    public void addTree(TreeType treeType) {
        TreeSize size = TreeSize.values()[(int) (Math.random() * TreeSize.values().length)];
        int x = (int) (Math.random() * 100);
        int y = (int) (Math.random() * 50 + 50);

        world.addTree(new Tree(treeType, size, x, y));
        scene.renderWorld();
    }

    public void addRandomTrees(int amount) {
        for (int i = 0; i < amount; i++) {
            TreeType treeType = TreeType.values()[(int) (Math.random() * TreeType.values().length)];
            addTree(treeType);
        }
    }

    public void clearTrees() {
        world.clearTrees();
        scene.renderWorld();
    }

    @Override
    public void stop() {
        worldUpdater.stop();
    }

    public void exit() {
        primaryStage.close();
    }
}
