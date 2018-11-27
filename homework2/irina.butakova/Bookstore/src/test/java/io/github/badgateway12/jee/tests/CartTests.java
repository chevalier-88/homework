package io.github.badgateway12.jee.tests;

import io.github.badgateway12.jee.beans.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class CartTests {
    private Book book1;
    private Book book2;
    private BookDAO dao;
    private Cart cart;

    public CartTests() {
        book1 = Book
                .info
                .title("Title1")
                .author("Author1")
                .publisher(Publisher.PUBLISHER_A)
                .category(Category.Tales)
                .edition(2)
                .price(255.55)
                .build();

        book2 = Book
                .info
                .title("Title2")
                .author("Author1")
                .publisher(Publisher.PUBLISHER_A)
                .category(Category.Tales)
                .edition(2)
                .price(200.55)
                .build();
    }

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        dao = (BookDAO) context.getBean("dao");
        dao.changeBalance(book1, 2);
        dao.changeBalance(book2, 1);
        cart = (Cart) context.getBean("cart");
    }

    @Test(expected = NullPointerException.class)
    public void testAdd__NullId_ThrowsException() {
        cart.add(null);
    }

    @Test
    public void testAdd_UpdatesItemCountAndOrderSum() {
        cart.add(book1.getId());
        cart.add(book2.getId());
        cart.add(book1.getId());
        assertEquals(2, cart.getTotalPositions());
        assertEquals(book1.getPrice() * 2 + book2.getPrice(), cart.getTotalSum(), 0.001);
    }

    @Test(expected = NullPointerException.class)
    public void testRemove__UnsufficientBalance_ThrowsException() {
        cart.remove(book1.getId());
    }

    @Test(expected = NullPointerException.class)
    public void testRemove__InvalidId_ThrowsException() {
        cart.remove("getId");
    }

    @Test(expected = NullPointerException.class)
    public void testRemove__NullId_ThrowsException() {
        cart.remove(null);
    }

    @Test
    public void testRemove_SufficientBalance_UpdatesItemCountAndOrderSum() {
        cart.add(book1.getId());
        cart.add(book1.getId());
        cart.add(book2.getId());
        cart.remove(book1.getId());
        assertEquals(2, cart.getTotalPositions());
        assertEquals(book1.getPrice() + book2.getPrice(), cart.getTotalSum(), 0.001);
    }

    @Test
    public void testEmpty_ReturnsZeroItemCountAndOrderSum() {
        cart.add(book1.getId());
        cart.add(book1.getId());
        cart.add(book2.getId());
        cart.empty();
        assertEquals(0, cart.getTotalPositions());
        assertEquals(0, cart.getTotalSum(), 0.001);
    }
}


