package com.gmail.vladimir.chevalier.characters;


import com.gmail.vladimir.chevalier.products.Book;

public interface Employee {
    Book takeBook(String name);

    void putBook(Book book);

}
