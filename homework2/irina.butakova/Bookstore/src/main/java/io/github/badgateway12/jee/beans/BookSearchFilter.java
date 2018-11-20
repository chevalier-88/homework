package io.github.badgateway12.jee.beans;

import java.util.function.Predicate;

public class BookSearchFilter {

    public static Predicate<BookDTO> authorName(String name) {
        return book -> book.getAuthor().equalsIgnoreCase(name);
    }

    public static Predicate<BookDTO> title(String phrase) {
        return book -> book.getTitle().contains(phrase);
    }

    public static Predicate<BookDTO> category(Category category) {
        return book -> book.getCategory() == category;
    }

    public static Predicate<BookDTO> id(String id) {
        return book -> book.getId().equals(id);
    }
}
