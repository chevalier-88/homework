package io.github.badgateway12.jee.tests;

import io.github.badgateway12.jee.beans.Book;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTests {
    private Book book;

    @Before
    public void setUp() {
        book = Book.info
                .title("Title")
                .author("Author")
                .publisher(io.github.badgateway12.jee.beans.Publisher.PUBLISHER_A)
                .category(io.github.badgateway12.jee.beans.Category.Tales)
                .edition(2)
                .price(250.55)
                .build();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testBalance_UnsufficientBalance_ThrowsException() {
        book.changeBalance(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReserve_UnsufficientReserve_ThrowsException() {
        book.reserve(-1);
    }

    @Test
    public void testBalance_SufficientBalance_ReturnsCorrectResult() {
        assertEquals(2, book.changeBalance(2).getBalance());
        assertEquals(0, book.changeBalance(-2).getBalance());
    }

    @Test
    public void testReserve_SufficientReserve_ReturnsCorrectResult() {
        assertEquals(2, book.changeBalance(2).reserve(2).getReserve());
        assertEquals(0, book.reserve(-2).getReserve());
    }
}

