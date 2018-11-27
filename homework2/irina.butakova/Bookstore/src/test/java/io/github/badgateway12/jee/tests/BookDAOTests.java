package io.github.badgateway12.jee.tests;

import io.github.badgateway12.jee.beans.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class BookDAOTests {
    private BookDAO dao;
    private Book book1;
    private Book book2;

    public BookDAOTests() {
        book1 = Book.info
                .title("Title1")
                .author("Author1")
                .publisher(Publisher.PUBLISHER_A)
                .category(Category.Tales)
                .edition(2)
                .price(250.55)
                .build();

        book2 = Book.info
                .title("Title2")
                .author("Author1")
                .publisher(Publisher.PUBLISHER_A)
                .category(Category.Tales)
                .edition(2)
                .price(200.55)
                .build();
    }

    @Before
    public void setUP() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        dao = (BookDAO) context.getBean("dao");
    }

    @Test(expected = NullPointerException.class)
    public void testChangeBalance_NullId_ThrowsException() {
        dao.changeBalance(null, 1);
    }

    @Test
    public void testChangeBalance_ReturnsCoorectResult() {
        dao.changeBalance(book1, 2);
        assertEquals(1, dao.getAll().size());
        dao.changeBalance(book2, 1);
        assertEquals(2, dao.getAll().size());
    }

    @Test(expected = NullPointerException.class)
    public void testReserve_NullId_ThrowsException() {
        dao.reserve(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testReserve_InvalidId_ThrowsException() {
        dao.reserve("getId", 1);
    }

    @Test(expected = NullPointerException.class)
    public void testGetBookInfo_NullId_ThrowsException() {
        dao.getBookInfo(null);
    }

    @Test(expected = NullPointerException.class)
    public void testGetBookInfo_InvalidId_ThrowsException() {
        dao.getBookInfo("id");
    }

    @Test
    public void testGetAll_ReturnsTheWholeCollection() {
        dao.changeBalance(book1, 1);
        dao.changeBalance(book2, 1);
        assertEquals(2, dao.getAll().size());
    }
}




