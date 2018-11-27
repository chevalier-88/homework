package hillel.jee.bookstore.beans;

import java.util.Objects;

/**
 * {@link PrintEdition} is a super class for other specific type of edition? like a book or a magazine.
 */
public class PrintEdition {
    private String author;
    private String editionName;
    private long price;
    private int count;

    public PrintEdition(String author, String editionName) {
        this.author = author;
        this.editionName = editionName;
    }

    public String getAuthor() {
        return author;
    }

    public String getEditionName() {
        return editionName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count += count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintEdition that = (PrintEdition) o;
        return price == that.price &&
                count == that.count &&
                Objects.equals(author, that.author) &&
                Objects.equals(editionName, that.editionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, editionName, price, count);
    }

    @Override
    public String toString() {
        return "PrintEdition{" +
                "author='" + author + '\'' +
                ", editionName='" + editionName + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
