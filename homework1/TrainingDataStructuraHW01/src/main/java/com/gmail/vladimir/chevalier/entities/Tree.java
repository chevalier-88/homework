package com.gmail.vladimir.chevalier.entities;

import java.util.Objects;

public class Tree {
    private int treeID;
    private Tree otherTree;
    private Blob blob;

    public Tree(int treeID, Tree otherTree, Blob blob) {
        this.treeID = treeID;
        this.otherTree = otherTree;
        this.blob = blob;
    }

    public int getTreeID() {
        return treeID;
    }

    public void setTreeID(int treeID) {
        this.treeID = treeID;
    }

    public Tree getOtherTree() {
        return otherTree;
    }

    public void setOtherTree(Tree otherTree) {
        this.otherTree = otherTree;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return treeID == tree.treeID &&
                Objects.equals(otherTree, tree.otherTree) &&
                Objects.equals(blob, tree.blob);
    }

    @Override
    public int hashCode() {

        return Objects.hash(treeID, otherTree, blob);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "treeID=" + treeID +
                ", otherTree=" + otherTree +
                ", blob=" + blob +
                '}';
    }
}
