package javaconfig;

import javaconfig.beans.BookFactory;
import javaconfig.beans.BookStore;
import javaconfig.beans.ShowShelf;
import javaconfig.beans.Storage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javaconfig.objects.Customer;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("javaconfig.beans");

        BookStore bookStore = context.getBean(BookStore.class);
        ShowShelf showShelf = bookStore.getShowShelf();
        Storage storage = showShelf.getStorage();
        BookFactory bookFactory = storage.getBookFactory();

        storage.addBooks(bookFactory.makeBooks("Владимир Савченко", "Открытие себя"));
        storage.addBooks(bookFactory.makeBooks("Дэн Симмонс", "Террор"));
        storage.addBooks(bookFactory.makeBooks("Айзек Азимов", "Двухсотлетний человек"));
        storage.addBooks(bookFactory.makeBooks("Дэн Симмонс", "Гиперион"));
        storage.addBooks(bookFactory.makeBooks("Айзек Азимов", "И пала ночь"));
        storage.addBooks(bookFactory.makeBooks("Станислав Лем", "Футурологический конгресс"));
        storage.addBooks(bookFactory.makeBooks("Иван Ефремов", "Час быка"));

        showShelf.fillFromStorage();

        Customer customer1 = new Customer("Ivan");
        Customer customer2 = new Customer("Nikita");

        bookStore.order(customer1, "Незнайка на Луне");

        for (int i = 0; i < 11; i++) {
            bookStore.order(customer1, "Террор");
            bookStore.order(customer2, "Открытие себя", "Владимир Савченко");
        }

        System.out.println(customer1.getBooks());
        System.out.println(customer2.getBooks());
    }
}
