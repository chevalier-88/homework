package ua.pp.darknsoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.pp.darknsoft.models.Book;
import ua.pp.darknsoft.service.BookStoreService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Book book = applicationContext.getBean("book", Book.class);
        System.out.println(book);

        ApplicationContext app2 = new AnnotationConfigApplicationContext("ua.pp.darknsoft");
        BookStoreService bookStoreService = app2.getBean("bookStoreServiceImpl", BookStoreService.class);

        bookStoreService.printAllBuyers();

        System.out.println(bookStoreService.byuBook(null));
        System.out.println(bookStoreService.byuBook(book));

    }
}
