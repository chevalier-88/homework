import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Tree implements Serializable {
    private String name;
    private ArrayList<Tree> trees;
    private ArrayList<Blob> blobs;
    private boolean changed;


    public Tree(String name) {
        this.name = name;
        trees = new ArrayList<>();
        blobs = new ArrayList<>();
    }

    public Tree add(Tree tree) {
        trees.add(tree);
        return tree;
    }

    public Blob add(Blob blob) {
        blobs.add(blob);
        return blob;
    }

    public boolean remove(Tree tree) {
        trees.remove(tree);
        return true;
    }

    public boolean remove(Blob blob) {
        blobs.remove(blob);
        return true;
    }

    public void setIndexLabel(Tree tree, boolean isChanged) {
        tree.setChanged(isChanged);
        tree.getBlobs().forEach(blob -> blob.setChanged(isChanged));
        if (tree.getTrees().isEmpty())
            return;
        for (int i = 0; i < tree.getTrees().size(); i++)
            setIndexLabel(tree.getTrees().get(i), isChanged);
    }

    public String showTree() {
        return getString(this, "") + "\n";
    }

    private String getString(Tree tree, String tab) {

        StringBuilder builder = new StringBuilder();
        tab += "\t";

        if (tree.getTrees().isEmpty()) {
            return tree + printBlobs(tree, tab);
        }

        for (int i = 0, size = tree.getTrees().size(); i < size; i++) {
            builder
                    .append("\n")
                    .append(tab)
                    .append(getString(tree.getTrees().get(i), tab));
        }

        builder.append(printBlobs(tree, tab));
        return tree + builder.toString();
    }

    private String printBlobs(Tree tree, String tab) {
        StringBuilder builder = new StringBuilder();
        tree.getBlobs().forEach(
                b -> builder
                        .append("\n")
                        .append(tab)
                        .append(b)
        );
        return builder.toString();
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Tree> getTrees() {
        return trees;
    }

    public ArrayList<Blob> getBlobs() {
        return blobs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Objects.equals(name, tree.name) &&
                Objects.equals(trees, tree.trees) &&
                Objects.equals(blobs, tree.blobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, trees, blobs);
    }

    @Override
    public String toString() {
        return name + (isChanged() ? " *" : "");
    }
}
