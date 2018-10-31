package io.github.badgateway12.jee;

import java.util.*;

public class Storage implements Iterable<Integer> {

    private LinkedHashMap<Integer, Commit> commits;
    private Commit lastAdded;

    public Storage() {
        this.commits = new LinkedHashMap<>();
    }

    public Commit addCommit(int authorId, String message, Tree tree) {
        Commit current = new Commit(authorId, message, lastAdded, tree);
        commits.put(current.hashCode(), current);
        lastAdded = current;
        return current;
    }

    public Tree getTree(Integer hash) {
        return commits.get(hash).getTree();
    }

    public Commit getCommit(Integer hash) {
        return commits.get(hash);
    }

    public int size() {
        return commits.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return commits.keySet().iterator();
    }
}
