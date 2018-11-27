package com.gmail.vladimir.chevalier.characters;


import com.gmail.vladimir.chevalier.products.Book;
import com.gmail.vladimir.chevalier.products.BookShelf;


public class Administrator implements Employee {

    private String adminName;
    private BookShelf bookShelf;

    public Book getBookInfo(String name) {

        Book bookResult = null;

        if (bookShelf != null) {
            bookResult = bookShelf.getBookByName(name);
        }
        return bookResult;
    }

    @Override
    public Book takeBook(String name) {

        Book bookResult = null;

        if (bookShelf != null) {
            bookResult = bookShelf.getBookByName(name);
            bookShelf.removeBook(bookResult);
        }
        return bookResult;
    }

    @Override
    public void putBook(Book book) {
        bookShelf.addBook(book);
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public BookShelf getBookShelf() {
        return bookShelf;
    }

    public void setBookShelf(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

}
