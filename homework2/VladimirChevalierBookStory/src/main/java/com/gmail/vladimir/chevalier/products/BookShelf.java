package com.gmail.vladimir.chevalier.products;

import java.util.List;

public class BookShelf {

    private List<Book> books;
    private List<Magazine> magazines;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<Magazine> magazines) {
        this.magazines = magazines;
    }

    public Book getBookByName(String name) {
        //TODO
        throw new UnsupportedOperationException();
    }

    public Magazine getMagazineByName(String name) {
        //TODO
        throw new UnsupportedOperationException();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public void removeBook(Book bookResult) {
        books.remove(bookResult);
    }

    public void removeMagazine(Magazine bookResult) {
        magazines.remove(bookResult);
    }
}
