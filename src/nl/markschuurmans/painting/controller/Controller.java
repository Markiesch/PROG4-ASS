package nl.markschuurmans.painting.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.markschuurmans.painting.model.Tree;
import nl.markschuurmans.painting.model.TreeSize;
import nl.markschuurmans.painting.model.TreeType;
import nl.markschuurmans.painting.model.World;
import nl.markschuurmans.painting.view.PaintingScene;

public class Controller extends Application {
    private Stage primaryStage;

    public void start(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        World world = new World();
        world.addTree(new Tree(TreeSize.L, TreeType.LEAF, 10, 50));
        world.addTree(new Tree(TreeSize.XL, TreeType.LEAF, 40, 50));

        setWorld(world);

        primaryStage.setTitle("Mark Schuurmans - Painting");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void setWorld(World world) {
        Scene scene = new PaintingScene(world);
        primaryStage.setScene(scene);
    }
}
