package annotationconfig.beans;

import annotationconfig.objects.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ShowShelf {
    private final List<Book> books;
    private final Storage storage;

    @Autowired
    public ShowShelf(Storage storage) {
        this.books = new ArrayList<>();
        this.storage = storage;
    }

    public void fillFromStorage() {
        Set<Book> uniqueBooks = new HashSet<>(storage.getBooks());
        uniqueBooks.forEach(uniqueBook -> storage.getBooks().remove(uniqueBook));
        books.addAll(uniqueBooks);
    }

    public Book issueBook(String title) {
        Book book = books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);
        return issueFromShowShelf(book);
    }

    public Book issueBook(String title, String author) {
        Book book = books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title) && b.getAuthor().equalsIgnoreCase(author))
                .findFirst().orElse(null);
        return issueFromShowShelf(book);
    }

    private Book issueFromShowShelf(Book book) {
        if (book != null) {
            books.remove(book);
            Book bookFromStorage = storage.issueBook(book);
            books.add(bookFromStorage);
        }
        return book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Storage getStorage() {
        return storage;
    }
}
