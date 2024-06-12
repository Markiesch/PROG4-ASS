package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class World {
    private final List<Tree> trees;

    public World() {
        trees = new ArrayList<>();
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    public void moveTrees() {
        trees.forEach(Tree::move);
    }

    public List<Tree> getTrees() {
        return trees.stream().sorted(Comparator.comparingDouble(Tree::getRelY)).collect(Collectors.toList());
    }

    public void clearTrees() {
        trees.clear();
    }
}
