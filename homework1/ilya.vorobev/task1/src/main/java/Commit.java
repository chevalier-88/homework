import com.sun.istack.internal.Nullable;

import java.time.LocalDateTime;

public class Commit {
    private String _author;
    private LocalDateTime _dateTime;
    private Tree _tree;
    @Nullable
    private Commit _previous;

    public Commit(String author, Tree tree, Commit previous) {
        _author = author;
        _dateTime = LocalDateTime.now();
        _tree = tree;
        _previous = previous;
    }

    public Tree get_tree() {
        return _tree;
    }

    public void set_tree(Tree _tree) {
        this._tree = _tree;
    }

    public String get_author() {
        return _author;
    }

    public LocalDateTime get_dateTime() {
        return _dateTime;
    }

    public Commit get_previous() {
        return _previous;
    }

    @Override
    public String toString() {
        return "Author: " + _author
                + "\nDateTime: " + _dateTime.toString()
                + "\nContent: \n" + _tree.toString();
    }
}
