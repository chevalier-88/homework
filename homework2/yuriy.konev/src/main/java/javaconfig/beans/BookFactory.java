package javaconfig.beans;

import javaconfig.objects.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BookFactory {

    private int batchSize;

    public BookFactory() {
        Properties properties = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("bookstore.properties")).getFile());
        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.batchSize = Integer.parseInt(properties.getProperty("batch.size"));
    }

    public Book[] makeBooks(String author, String title) {
        Book[] books = new Book[batchSize];
        for (int i = 0; i < batchSize; i++) {
            books[i] = new Book(author, title);
        }
        return books;
    }
}
