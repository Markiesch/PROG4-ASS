package nl.markschuurmans.painting.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.markschuurmans.painting.view.PaintingPane;
import nl.markschuurmans.painting.view.PaintingScene;

public class Controller extends Application {
    public void start(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new PaintingScene(new PaintingPane());
        primaryStage.setScene(scene);

        primaryStage.setTitle("Mark Schuurmans - Painting");
        primaryStage.setWidth(800);
        primaryStage.setWidth(600);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
