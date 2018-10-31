package io.github.badgateway12.jee;

import java.util.ArrayList;
import java.util.Objects;

public class Tree  {
    private final String name;
    private ArrayList<Blob> blobs;
    private ArrayList<Tree> trees;
    private int blobCount;

    public int size() {
        return blobCount;
    }

    public Tree(String name) {
        this.name = name;
        this.blobs = new ArrayList<>();
        this.trees = new ArrayList<>();
    }

    public Tree add(Blob blob) {
        blobs.add(blob);
        blobCount++;
        return this;
    }

    public Tree add(Tree tree) {
        trees.add(tree);
        blobCount += tree.size();
        return this;
    }

    public Tree remove(Blob blob) {
        blobs.remove(blob);
        blobCount--;
        return this;
    }

    public Tree remove(Tree tree) {
        trees.remove(tree);
        blobCount -= tree.size();
        return this;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Tree tree = (Tree) other;
        return  Objects.equals(name, tree.name) &&
                Objects.equals(blobs, tree.blobs) &&
                Objects.equals(trees, tree.trees) &&
                blobCount == tree.blobCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, blobs, trees, blobCount);
    }
}

