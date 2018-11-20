package io.github.badgateway12.jee.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Book book1 = Book.info
                .title("Title1")
                .author("Author1")
                .publisher(Publisher.PUBLISHER_A)
                .category(Category.Tales)
                .edition(3)
                .price(200.55)
                .build();

        Book book2 = Book.info
                .title("Title2")
                .author("Author1")
                .publisher(Publisher.PUBLISHER_A)
                .category(Category.Tales)
                .edition(2)
                .price(250.55)
                .build();
        BookDAO dao = (BookDAO) context.getBean("dao");
        Cart cart = (Cart) context.getBean("cart");

        dao.changeBalance(book1, 2);
        dao.changeBalance(book2, 1);
        dao.getAll().forEach(System.out::println);

        cart.add(book1.getId());
        cart.add(book2.getId());
        System.out.println(cart.getTotalPositions());
        System.out.println(cart.getTotalSum());

    }
}
