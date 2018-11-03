import java.util.ArrayList;

public class Git {
    private ArrayList<Commit> commits;
    private Tree root;


    public Git(Tree root) {
        commits = new ArrayList<>();
        this.root = root;
    }

    public void commit(String message, String author) {
        if (commits.size() > 0)
            commits.add(new Commit(message, author, root, commits.get(commits.size() - 1)));
        else
            commits.add(new Commit(message, author, root, new Commit()));
    }


    public void printCommits() {
        commits.forEach(System.out::println);
    }

    public ArrayList<Commit> getCommits() {
        return commits;
    }
}
