package controller;

import model.Tree;
import model.TreeSize;
import model.TreeType;
import model.World;

import java.io.*;

public class FileIO {

    public World readFile(File file) {
        World world = new World();

        try (FileReader fileReader = new FileReader(file)) {

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;

                Tree tree = new Tree(
                        TreeType.valueOf(line.split(":")[0].toUpperCase()),
                        TreeSize.valueOf(line.split(":")[1].toUpperCase()),
                        Integer.parseInt(line.split(":")[2]),
                        Integer.parseInt(line.split(":")[3])
                );
                world.addTree(tree);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return world;
    }

    public void writeFile(File file, World world) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (Tree tree : world.getTrees()) {
                fileWriter.write(
                        tree.getType().toString().toLowerCase() + ":" +
                                tree.getSize().toString().toLowerCase() + ":" +
                                (int)tree.getRelX() + ":" +
                                (int)tree.getRelY() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
