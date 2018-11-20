package javaconfig.beans;

import javaconfig.objects.Book;
import javaconfig.objects.Customer;

public class BookStore {
    private ShowShelf showShelf;

    public BookStore(ShowShelf showShelf) {
        this.showShelf = showShelf;
    }

    public Book order(Customer customer, String title) {
        Book book = showShelf.issueBook(title);
        if (available(book))
            customer.addBook(book);
        return book;
    }

    public Book order(Customer customer, String title, String author) {
        Book book = showShelf.issueBook(title, author);
        if (available(book))
            customer.addBook(book);
        return book;
    }

    private boolean available(Book book) {
        if (book == null)
            System.out.println("Not found.");
        return book != null;
    }

    public ShowShelf getShowShelf() {
        return showShelf;
    }
}
