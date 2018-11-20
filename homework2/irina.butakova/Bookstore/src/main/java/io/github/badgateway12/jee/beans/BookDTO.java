package io.github.badgateway12.jee.beans;

public interface BookDTO {
    String getId();
    String getTitle();
    String getAuthor();
    Publisher getPublisher();
    Category getCategory();
    int getEdition();
    double getPrice();
    int getBalance();
    int getReserve();
}
