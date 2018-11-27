package hillel.jee.bookstore.beans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/application-context.xml");

    static BookStore store = context.getBean(BookStore.class);

    private static AuthorShelfOfWorks checkAuthorShelf(String authorName) {
        AuthorShelfOfWorks shelf = store.getBookStore().get(authorName);
        if(shelf == null) {
            AuthorShelfOfWorks newShelf = context.getBean(AuthorShelfOfWorks.class, authorName);
            return newShelf;
        }
        return shelf;
    }

    public static void main(String[] args) {
        Book book1 = context.getBean(Book.class,"Edgar Allan Poe", "The Black Cat");
        Book book2 = context.getBean(Book.class,"Edgar Allan Poe", "The Golden Bug");
        Book book3 = context.getBean(Book.class,"William Shakespeare", "Richard, the Lion's Heart");
        Magazine mag1 = context.getBean(Magazine.class,"Men's Health", 1);
        Magazine mag2 = context.getBean(Magazine.class,"Men's Health", 2);
        Magazine mag3 = context.getBean(Magazine.class,"Men's Health", 3);

        store.addEditions(mag1, checkAuthorShelf(mag1.getAuthor()),100);
        store.addEditions(mag1, checkAuthorShelf(mag1.getAuthor()),100);
        store.addEditions(mag2, checkAuthorShelf(mag2.getAuthor()),150);
        store.addEditions(mag3, checkAuthorShelf(mag3.getAuthor()),10);
        store.addEditions(book1, checkAuthorShelf(book1.getAuthor()),10);
        store.addEditions(book2, checkAuthorShelf(book2.getAuthor()),15);
        store.addEditions(book3, checkAuthorShelf(book3.getAuthor()),1);

        store.getListOfAuthors().forEach(System.out::println);
        store.getListOfAuthorWorks("Edgar Allan Poe").forEach(System.out::println);

    }
}
