package xmlconfig;

import xmlconfig.beans.BookStore;
import xmlconfig.beans.BookFactory;
import xmlconfig.beans.ShowShelf;
import xmlconfig.beans.Storage;
import xmlconfig.objects.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        BookStore bookStore = context.getBean(BookStore.class);
        BookFactory bookFactory = context.getBean(BookFactory.class);
        Storage storage = context.getBean(Storage.class);
        ShowShelf showShelf = context.getBean(ShowShelf.class);

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
