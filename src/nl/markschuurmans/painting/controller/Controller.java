package nl.markschuurmans.painting.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.markschuurmans.painting.model.Tree;
import nl.markschuurmans.painting.model.TreeSize;
import nl.markschuurmans.painting.model.TreeType;
import nl.markschuurmans.painting.model.World;
import nl.markschuurmans.painting.view.PaintingScene;

import java.io.File;

public class Controller extends Application {
    private Stage primaryStage;
    private World world;

    public void start(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        World world = new World();
        world.addTree(new Tree(TreeType.LEAF, TreeSize.L, 10, 80));
        world.addTree(new Tree(TreeType.LEAF, TreeSize.XL, 40, 80));

        setWorld(world);

        primaryStage.setTitle("Mark Schuurmans - Painting");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void setWorld(World world) {
        this.world = world;
        Scene scene = new PaintingScene(this, world);
        primaryStage.setScene(scene);
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
}
