package controller;

import javafx.application.Platform;

public class WorldUpdater implements Runnable {
    private final Controller controller;
    private final Thread thread;

    public WorldUpdater(Controller controller) {
        this.controller = controller;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 / 24);

            if (!controller.isPlaying()) {
                run();
                return;
            }
            controller.getWorld().moveTrees();
            Platform.runLater(() -> controller.setWorld(controller.getWorld()));
            run();
        } catch (InterruptedException ignored) {
        }
    }

    public void stop() {
        thread.interrupt();
    }
}
