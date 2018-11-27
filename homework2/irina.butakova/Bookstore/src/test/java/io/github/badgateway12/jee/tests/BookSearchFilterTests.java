package io.github.badgateway12.jee.tests;

import io.github.badgateway12.jee.beans.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class BookSearchFilterTests {
    private Predicate<BookDTO> predicate;
    private Book book;
    private boolean expected;

    public BookSearchFilterTests(Predicate<BookDTO> predicate, Book book, boolean expected) {
        this.predicate = predicate;
        this.book = book;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: {0}.test({1}) = {2}")
    public static Collection<Object[]> data() {
        Book book = Book
                .info
                .title("Title1")
                .author("Author1")
                .publisher(Publisher.PUBLISHER_A)
                .category(Category.Tales)
                .edition(2)
                .price(250.55)
                .build();

        return Arrays.asList(new Object[][]{
                {BookSearchFilter.title("Title1"), book, true},
                {BookSearchFilter.title("Title2"), book, false},
                {BookSearchFilter.category(Category.Tales), book, true},
                {BookSearchFilter.category(Category.Programming), book, false},
                {BookSearchFilter.authorName("Author1"), book, true},
                {BookSearchFilter.authorName("Author2"), book, false},
                {BookSearchFilter.id(book.getId()), book, true},
                {BookSearchFilter.id("getId"), book, false}
        });
    }

    @Test
    public void testFilter() {
        assertEquals(expected, predicate.test(book));
    }
}


