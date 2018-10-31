package io.github.badgateway12.jee;

import java.util.Date;
import java.util.Objects;

public class Commit {

    private final Date date;
    private final int authorId;
    private final String message;
    private final Tree tree;
    private final Commit previous;

    public Commit(int authorId, String message, Commit previous, Tree tree) {
        date = new Date();
        this.authorId = authorId;
        this.message = message;
        this.tree = tree;
        this.previous = previous;
    }

    public Date getDate() { return date; }
    public int getAuthorId() { return authorId; }
    public String getMessage() { return message; }
    public Tree getTree() { return tree; }
    public Commit getPrevious() { return previous; }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Commit other = (Commit) obj;
        return  Objects.equals(date, other.date) &&
                Objects.equals(message, other.message) &&
                Objects.equals(tree, other.tree) &&
                authorId == other.authorId ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, message, tree, authorId);
    }
}

