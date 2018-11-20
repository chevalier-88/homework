package xmlconfig.beans;

import xmlconfig.objects.Book;

public class BookFactory {

    private int batchSize;

    public BookFactory(int batchSize) {
        this.batchSize = batchSize;
    }

    public Book[] makeBooks(String author, String title) {
        Book[] books = new Book[batchSize];
        for (int i = 0; i < batchSize; i++) {
            books[i] = new Book(author, title);
        }
        return books;
    }
}
