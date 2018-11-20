package annotationconfig.objects;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Book {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private Integer id;
    private String author;
    private String title;

    public Book(String author, String title) {
        id = counter.getAndIncrement();
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }


    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{'" + title + "' author '" + author + "' id=" + id + "}";
    }
}
