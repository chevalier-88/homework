package com.gmail.vladimir.chevalier.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Commit {

    private String authorCommit;
    private Date dateCommit;
    private Commit prevCommit;
    private Tree tree;

    public Commit(String authorCommit, Tree tree) {
        this.authorCommit = authorCommit;
        this.dateCommit = new Date();
        this.prevCommit = null;
        this.tree = tree;


    }

    public Commit(String authorCommit, Date dateCommit, Commit prevCommit, Tree tree) {
        this.authorCommit = authorCommit;
        this.dateCommit = dateCommit;
        this.prevCommit = prevCommit;
        this.tree = tree;
    }


    public String getAuthorCommit() {
        return authorCommit;
    }

    public void setAuthorCommit(String authorCommit) {
        this.authorCommit = authorCommit;
    }

    public Date getDateCommit() {
        return dateCommit;
    }

    public void setDateCommit(Date dateCommit) {
        this.dateCommit = dateCommit;
    }

    public Commit getPrevCommit() {
        return prevCommit;
    }

    public void setPrevCommit(Commit prevCommit) {
        this.prevCommit = prevCommit;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commit commit = (Commit) o;
        return Objects.equals(authorCommit, commit.authorCommit) &&
                Objects.equals(dateCommit, commit.dateCommit) &&
                Objects.equals(prevCommit, commit.prevCommit) &&
                Objects.equals(tree, commit.tree);
    }

    @Override
    public int hashCode() {

        return Objects.hash(authorCommit, dateCommit, prevCommit, tree);
    }

    @Override
    public String toString() {
        return "Commit{" +
                "authorCommit='" + authorCommit + '\'' +
                ", dateCommit=" + dateCommit +
                ", prevCommit=" + prevCommit +
                ", tree=" + tree +
                '}';
    }
}
