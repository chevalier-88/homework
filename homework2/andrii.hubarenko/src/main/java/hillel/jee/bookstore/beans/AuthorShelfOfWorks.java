package hillel.jee.bookstore.beans;;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * {@link AuthorShelfOfWorks} is a container for storing of many print editions of one author
 */
public class AuthorShelfOfWorks {
    private Map<String, PrintEdition> shelf = new HashMap<>();
    private String authorName;

    public AuthorShelfOfWorks(String authorName) {
        this.authorName = authorName;
    }

    public Map<String, PrintEdition> getShelf() {
        return shelf;
    }

    @Override
    public String toString() {
        return "AuthorShelfOfWorks{" +
                "shelf=" + shelf +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorShelfOfWorks that = (AuthorShelfOfWorks) o;
        return Objects.equals(shelf, that.shelf) &&
                Objects.equals(authorName, that.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shelf, authorName);
    }
}
