package io.github.badgateway12.jee.beans;

import com.google.common.base.Preconditions;

import java.util.Objects;
import java.util.UUID;

public class Book implements BookDTO {
    private final UUID id;
    private final String title;
    private final String author;
    private final Publisher publisher;
    private final Category category;
    private final int edition;
    private double price;
    private int balance;
    private int reserve;

    private Book(Builder builder) {
        id = UUID.randomUUID();
        author = builder.author;
        publisher = builder.publisher;
        category = builder.category;
        title = builder.title;
        edition = builder.edition;
        price = builder.price;
    }

    @Override
    public String getId()
    {
        return id.toString();
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public String getAuthor()
    {
        return author;
    }

    @Override
    public Publisher getPublisher()
    {
        return publisher;
    }

    @Override
    public Category getCategory()
    {
        return category;
    }

    @Override
    public int getEdition()
    {
        return edition;
    }

    @Override
    public double getPrice()
    {
        return price;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int getReserve() {
        return reserve;
    }

    public Book changeBalance(int count) {
        checkBalanceSufficiency(count);
        balance += count;
        return this;
    }

    public Book reserve(int count) {
        checkReserveSufficiency(count);
        reserve += count;
        return this;
    }

    private void checkBalanceSufficiency(int count) {
        if(count < 0 && balance + count < 0) {
            throw new IllegalArgumentException("Not enough books.");
        }
    }

    private void checkReserveSufficiency(int count) {
        if (count > 0 && balance - reserve < count) {
            throw new IllegalArgumentException("Not enough books.");
        } else if (count < 0 && reserve + count < 0) {
            throw new IllegalArgumentException("Not enough books.");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "getId='" + id + '\'' + ", " +
                "getPrice=" + price + ", " +
                "getTitle='" + title + '\'' + ", " +
                "getAuthor=" + author + ", " +
                "getPublisher=" + publisher.toString() + ", " +
                "getCategory=" + category.toString() + ", " +
                "getEdition=" + edition + ", " +
                "add=" + balance + ", " +
                "getReserve=" + reserve + '}';
    }

    public static TitleBuilder info = new Builder();

    public static class Builder implements TitleBuilder, AuthorBuilder, PublisherBuilder, CategoryBilder, EditionBuilder, PriceBuilder, Build {
        private String title;
        private String author;
        private Publisher publisher;
        private Category category;
        private int edition;
        private double price;

        public AuthorBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PublisherBuilder author(String author) {
            this.author = author;
            return this;
        }

        public CategoryBilder publisher(Publisher publisher) {
            this.publisher = publisher;
            return this;
        }

        public EditionBuilder category(Category  category) {
            this.category = category;
            return this;
        }

        public PriceBuilder edition(int edition) {
            this.edition = edition;
            return this;
        }

        public Build price(double price) {
            this.price = price;
            return this;
        }

        public Book build() {
            Preconditions.checkNotNull(title, "Title should not be an empty string");
            Preconditions.checkArgument(title.trim().length() > 0, "Title should not be an empty string");
            Preconditions.checkNotNull(author, "Author should not be null");
            Preconditions.checkArgument(author.trim().length() > 0, "Author should not be an empty string");
            Preconditions.checkNotNull(publisher, "Publisher is mandatory field");
            Preconditions.checkNotNull(category, "getCategory is mandatory field");
            Preconditions.checkArgument(price > 0, "Price can not be a negative value");
            return new Book(this);
        }
    }

    public interface TitleBuilder {
        AuthorBuilder title(String title);
    }

    public interface AuthorBuilder {
        PublisherBuilder author(String name);
    }

    public interface PublisherBuilder {
        CategoryBilder publisher(Publisher publisher);
    }

    public interface CategoryBilder {
        EditionBuilder category(Category category);
    }

    public interface EditionBuilder {
        PriceBuilder edition(int edition);
    }

    public interface PriceBuilder {
        Build price(double price);
    }

    public interface Build {
        Book build();
    }
}
