package annotationconfig.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static final AtomicInteger counter = new AtomicInteger(1);
    private Integer id;
    private String name;
    private List<Book> books;

    public Customer(String name) {
        id = counter.getAndIncrement();
        this.name = name;
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "xmlconfig.objects.Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
