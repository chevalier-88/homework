import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tree {
    private final String name;
    private Commit parentCommit;

    private List<Tree> treeList;
    private List<Blob> listOfBlobs;

    public Tree(String name) {
        this.name = name;
        listOfBlobs = new ArrayList<>();
        treeList = new ArrayList<>();
    }

    public void setParentCommit(Commit parentCommit) {
        this.parentCommit = parentCommit;
    }

    public void addTree(String name){
        treeList.add(new Tree(name));
    }

    public void addTree(Tree tree){
        treeList.add(tree);
    }

    public void addBlob(Blob blob){
        listOfBlobs.add(blob);
    }

    public List<Tree> getTreeList() {
        return treeList;
    }

    public List<Blob> getListOfBlobs() {
        return listOfBlobs;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (getClass() != obj.getClass())) return false;
        Tree tree = (Tree) obj;
        return Objects.equals(name, tree.name) &&
               Objects.equals(parentCommit, tree.parentCommit) &&
               Objects.equals(treeList, tree.treeList) &&
               Objects.equals(listOfBlobs, tree.listOfBlobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentCommit, treeList, listOfBlobs);
    }
}
