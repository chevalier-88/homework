import java.util.Date;
import java.util.*;

public class Commit {
    private final int commitID;

    private final String authorName;
    private final Date date;
    private Commit parentCommit;
    private Tree parentTree;

    private static List<Commit> commitList;

    public Commit(String authorName) {
        commitList = new ArrayList();
        this.authorName = authorName;
        this.date = new Date();
        commitID = commitList.size();

        if (!commitList.isEmpty()){
            setParentCommit(commitList.get(commitID - 1));
        }
        commitList.add(this);
    }

    private void setParentCommit(Commit parentCommit) {
        this.parentCommit = parentCommit;
    }

    public Tree getParentTree() {
        return parentTree;
    }

    public Commit getParentCommit() {
        return parentCommit;
    }

    public void addTree(String name) {
        Tree tree = new Tree(name);
        tree.setParentCommit(this);
        this.parentTree = tree;
    }

    public int getCommitID() {
        return commitID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (getClass() != obj.getClass())) return false;
        Commit commit = (Commit) obj;
        return Objects.equals(commitID, commit.commitID) &&
                Objects.equals(date, commit.date) &&
                Objects.equals(authorName, commit.authorName) &&
                Objects.equals(parentCommit, commit.parentCommit) &&
                Objects.equals(parentTree, commit.parentTree);
    }
}
