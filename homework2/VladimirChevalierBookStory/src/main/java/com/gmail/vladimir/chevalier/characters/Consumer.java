package com.gmail.vladimir.chevalier.characters;

import com.gmail.vladimir.chevalier.products.Book;
import com.gmail.vladimir.chevalier.products.BookShelf;
import com.gmail.vladimir.chevalier.products.Magazine;

public class Consumer {
    private String nameConsumer;

    public Book buyBook(String name, BookShelf shelf) {
        Book result = shelf.getBookByName(name);
        shelf.removeBook(result);
        return result;
    }

    public Magazine buyMagazine(String name, BookShelf shelf) {
        Magazine result = shelf.getMagazineByName(name);
        shelf.removeMagazine(result);
        return result;
    }

    public String getNameConsumer() {
        return nameConsumer;
    }

    public void setNameConsumer(String nameConsumer) {
        this.nameConsumer = nameConsumer;
    }
}
