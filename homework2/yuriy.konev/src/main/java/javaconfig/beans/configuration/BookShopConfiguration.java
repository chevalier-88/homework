package javaconfig.beans.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javaconfig.beans.BookFactory;
import javaconfig.beans.BookStore;
import javaconfig.beans.ShowShelf;
import javaconfig.beans.Storage;

@Configuration
public class BookShopConfiguration {
    @Bean
    public BookStore bookStore(ShowShelf showShelf) {
        return new BookStore(showShelf);
    }

    @Bean
    public ShowShelf showShelf() {
        return new ShowShelf(storage());
    }

    @Bean
    public Storage storage() {
        return new Storage(bookFactory());
    }

    @Bean
    public BookFactory bookFactory() {
        return new BookFactory();
    }

}
