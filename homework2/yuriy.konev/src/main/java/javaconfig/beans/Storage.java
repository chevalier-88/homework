package javaconfig.beans;

import javaconfig.objects.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Storage {
    private List<Book> books;
    private BookFactory bookFactory;

    public Storage(BookFactory bookFactory) {
        this.books = new ArrayList<>();
        this.bookFactory = bookFactory;
    }

    public Book issueBook(Book book) {

        for (Book b : books) {
            if (b.equals(book)) {
                books.remove(book);
                return b;
            }
        }

        System.out.printf("%S sold out. Order the making of 10 new books.\n", book);
        addBooks(bookFactory.makeBooks(book.getAuthor(), book.getTitle()));
        return issueBook(book);
    }

    public void addBooks(Book... books) {
        this.books.addAll(Arrays.asList(books));
    }

//    public void addBooks(List<Book> books) {
//        this.books.addAll(books);
//    }

    public List<Book> getBooks() {
        return books;
    }

    public BookFactory getBookFactory() {
        return bookFactory;
    }
}
