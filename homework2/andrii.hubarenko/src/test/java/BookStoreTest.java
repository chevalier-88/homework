import hillel.jee.bookstore.beans.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:/test-context.xml")
public class BookStoreTest {

    @Autowired
    ApplicationContext context;

    private AuthorShelfOfWorks checkAuthorShelf(String name, BookStore bookStore) {
        AuthorShelfOfWorks authorShelfOfWorks = bookStore.getBookStore().get(name);
        if(authorShelfOfWorks != null) {
            return authorShelfOfWorks;
        }
        return context.getBean(AuthorShelfOfWorks.class, name);
    }

    @Test
    public void createStoreTest(){
        BookStore bookStore = context.getBean(BookStore.class);
    }

    @Test
    public void createBookTest(){
        PrintEdition book = context.getBean(Book.class,"Edgar Allan Poe", "The Black Cat");
    }

    @Test
    public void createMagazineTest(){
        PrintEdition mag = context.getBean(Magazine.class,"Men's Health", 1);
    }

    @Test
    public void addMagazineTest(){
        BookStore bookStore = context.getBean(BookStore.class);

        Magazine mag1 = context.getBean(Magazine.class,"Men's Health", 1);
        Magazine mag2 = context.getBean(Magazine.class,"Men's Health", 2);
        Magazine mag3 = context.getBean(Magazine.class,"Men's Health", 3);

        bookStore.addEditions(mag1, checkAuthorShelf(mag1.getAuthor(), bookStore),10);
        bookStore.addEditions(mag2, checkAuthorShelf(mag2.getAuthor(), bookStore),15);
        bookStore.addEditions(mag3, checkAuthorShelf(mag3.getAuthor(), bookStore),1);
    }

    @Test
    public void addBookTest(){
        BookStore bookStore = context.getBean(BookStore.class);

        Book book1 = context.getBean(Book.class,"Edgar Allan Poe", "The Black Cat");
        Book book2 = context.getBean(Book.class,"Edgar Allan Poe", "The Golden Bug");
        Book book3 = context.getBean(Book.class,"William Shakespeare", "Richard, the Lion's Heart");

        bookStore.addEditions(book1, checkAuthorShelf(book1.getAuthor(), bookStore),10);
        bookStore.addEditions(book2, checkAuthorShelf(book2.getAuthor(), bookStore),15);
        bookStore.addEditions(book3, checkAuthorShelf(book3.getAuthor(), bookStore),1);
    }

    @Test
    public void getListOfAuthorsTest(){
        BookStore bookStore = context.getBean(BookStore.class);

        Book book1 = context.getBean(Book.class,"Edgar Allan Poe", "The Black Cat");
        Book book2 = context.getBean(Book.class,"Edgar Allan Poe", "The Golden Bug");
        Book book3 = context.getBean(Book.class,"William Shakespeare", "Richard, the Lion's Heart");
        Magazine mag1 = context.getBean(Magazine.class,"Men's Health", 1);
        Magazine mag2 = context.getBean(Magazine.class,"Men's Health", 2);
        Magazine mag3 = context.getBean(Magazine.class,"Men's Health", 3);

        bookStore.addEditions(mag1, checkAuthorShelf(mag1.getAuthor(), bookStore),100);
        bookStore.addEditions(mag2, checkAuthorShelf(mag2.getAuthor(), bookStore),150);
        bookStore.addEditions(mag3, checkAuthorShelf(mag3.getAuthor(), bookStore),10);
        bookStore.addEditions(book1, checkAuthorShelf(book1.getAuthor(), bookStore),10);
        bookStore.addEditions(book2, checkAuthorShelf(book2.getAuthor(), bookStore),15);
        bookStore.addEditions(book3, checkAuthorShelf(book3.getAuthor(), bookStore),1);

        List<String> expected = new ArrayList<>();
        expected.add("Men's Health");
        expected.add("Edgar Allan Poe");
        expected.add("William Shakespeare");
        List<String> actual = new ArrayList<>();
        actual.addAll(bookStore.getListOfAuthors());

        Assert.assertEquals(expected, actual);

        bookStore.getListOfAuthors().forEach(System.out::println);
    }

    @Test
    public void getListOfAuthorWorksTest(){
        BookStore bookStore = context.getBean(BookStore.class);

        Book book1 = context.getBean(Book.class,"Edgar Allan Poe", "The Black Cat");
        Book book2 = context.getBean(Book.class,"Edgar Allan Poe", "The Golden Bug");

        bookStore.addEditions(book1, checkAuthorShelf(book1.getAuthor(), bookStore),10);
        bookStore.addEditions(book2, checkAuthorShelf(book2.getAuthor(), bookStore),15);

        List<String> expected = new ArrayList<>();
        expected.add("The Golden Bug");
        expected.add("The Black Cat");
        List<String> actual = new ArrayList<>();
        actual.addAll(bookStore.getListOfAuthorWorks("Edgar Allan Poe"));

        Assert.assertEquals(expected, actual);

        bookStore.getListOfAuthorWorks("Edgar Allan Poe").forEach(System.out::println);
    }

    @Test
    public void getListOfMagazineTest(){
        BookStore bookStore = context.getBean(BookStore.class);

        Magazine mag1 = context.getBean(Magazine.class,"Men's Health", 1);
        Magazine mag2 = context.getBean(Magazine.class,"Men's Health", 2);
        Magazine mag3 = context.getBean(Magazine.class,"Men's Health", 3);

        bookStore.addEditions(mag1, checkAuthorShelf(mag1.getAuthor(), bookStore),100);
        bookStore.addEditions(mag2, checkAuthorShelf(mag2.getAuthor(), bookStore),150);
        bookStore.addEditions(mag3, checkAuthorShelf(mag3.getAuthor(), bookStore),10);

        List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        List<String> actual = new ArrayList<>();
        actual.addAll(bookStore.getListOfAuthorWorks("Men's Health"));

        Assert.assertEquals(expected, actual);

        bookStore.getListOfAuthorWorks("Men's Health").forEach(System.out::println);
    }

    @Test
    public void getAmountOfBooksTest(){
        BookStore bookStore = context.getBean(BookStore.class);

        Book book1 = context.getBean(Book.class,"Edgar Allan Poe", "The Black Cat");
        Book book2 = context.getBean(Book.class,"Edgar Allan Poe", "The Golden Bug");
        Book book3 = context.getBean(Book.class,"William Shakespeare", "Richard, the Lion's Heart");
        Magazine mag1 = context.getBean(Magazine.class,"Men's Health", 3);

        bookStore.addEditions(book1, checkAuthorShelf(book1.getAuthor(), bookStore),10);
        bookStore.addEditions(book2, checkAuthorShelf(book2.getAuthor(), bookStore),15);
        bookStore.addEditions(book3, checkAuthorShelf(book3.getAuthor(), bookStore),1);
        bookStore.addEditions(mag1, checkAuthorShelf(mag1.getAuthor(), bookStore),100);


        Assert.assertEquals(10, bookStore.getAmountOfEditions("Edgar Allan Poe", "The Black Cat"));
        Assert.assertEquals(15, bookStore.getAmountOfEditions("Edgar Allan Poe", "The Golden Bug"));
        Assert.assertEquals(1, bookStore.getAmountOfEditions("William Shakespeare", "Richard, the Lion's Heart"));
        Assert.assertEquals(100, bookStore.getAmountOfEditions("Men's Health", "3"));
    }

    @Test
    public void wholeSaleBookTest(){
        BookStore bookStore = context.getBean(BookStore.class);

        Book book1 = context.getBean(Book.class,"Edgar Allan Poe", "The Black Cat");
        Book book2 = context.getBean(Book.class,"Edgar Allan Poe", "The Golden Bug");
        Book book3 = context.getBean(Book.class,"William Shakespeare", "Richard, the Lion's Heart");
        Magazine mag1 = context.getBean(Magazine.class,"Men's Health", 3);

        bookStore.addEditions(book1, checkAuthorShelf(book1.getAuthor(), bookStore),10);
        bookStore.addEditions(book2, checkAuthorShelf(book2.getAuthor(), bookStore),15);
        bookStore.addEditions(book3, checkAuthorShelf(book3.getAuthor(), bookStore),1);
        bookStore.addEditions(mag1, checkAuthorShelf(mag1.getAuthor(), bookStore),100);

        Assert.assertEquals(10, bookStore.getAmountOfEditions("Edgar Allan Poe", "The Black Cat"));

        bookStore.wholeSaleBook("Edgar Allan Poe", "The Black Cat", 8);

        Assert.assertEquals(2, bookStore.getAmountOfEditions("Edgar Allan Poe", "The Black Cat"));

        bookStore.wholeSaleBook("Edgar Allan Poe", "The Black Cat", 8);

        Assert.assertEquals(100, bookStore.getAmountOfEditions("Men's Health", "3"));

        bookStore.wholeSaleBook("Men's Health", "3", 54);

        Assert.assertEquals(46, bookStore.getAmountOfEditions("Men's Health", "3"));
    }

    @Test
    public void sellSingleBookTest(){
        BookStore bookStore = context.getBean(BookStore.class);

        Book book3 = context.getBean(Book.class,"William Shakespeare", "Richard, the Lion's Heart");

        bookStore.addEditions(book3, checkAuthorShelf(book3.getAuthor(), bookStore),1);
        Assert.assertEquals(1, bookStore.getAmountOfEditions("William Shakespeare", "Richard, the Lion's Heart"));

        bookStore.sellSingleEdition("William Shakespeare", "Richard, the Lion's Heart");
        Assert.assertEquals(0, bookStore.getAmountOfEditions("William Shakespeare", "Richard, the Lion's Heart"));
    }

}
