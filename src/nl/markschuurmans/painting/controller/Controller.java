package nl.markschuurmans.painting.controller;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.markschuurmans.painting.model.Tree;
import nl.markschuurmans.painting.model.TreeSize;
import nl.markschuurmans.painting.model.TreeType;
import nl.markschuurmans.painting.model.World;
import nl.markschuurmans.painting.view.PaintingScene;

import java.io.File;

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

        world = new World();
        world.addTree(new Tree(TreeType.LEAF, TreeSize.L, 10, 80));
        world.addTree(new Tree(TreeType.LEAF, TreeSize.XL, 40, 80));

        primaryStage.setTitle("Mark Schuurmans - Painting");
        primaryStage.setResizable(false);
        primaryStage.show();

        scene = new PaintingScene(this);
        primaryStage.setScene(scene);
        scene.renderWorld();

        worldUpdater = new WorldUpdater(this);
    }

    public World getWorld() {
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

        File file = fileChooser.showOpenDialog(primaryStage);

        FileIO fileIO = new FileIO();
        World world = fileIO.readFile(file);

        setWorld(world);
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

    public void exit() {
        primaryStage.close();
    }

    @Override
    public void stop() {
        worldUpdater.stop();
    }
}
