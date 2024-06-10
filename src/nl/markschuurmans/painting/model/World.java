package nl.markschuurmans.painting.model;

import java.util.ArrayList;
import java.util.List;

public class World {
    private final List<Tree> trees;

    public World() {
        trees = new ArrayList<>();
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    public void moveTrees() {
        for (Tree tree : trees) {
            tree.move();
        }
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public void clearTrees() {
        trees.clear();
    }
}
