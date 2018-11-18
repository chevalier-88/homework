package ua.pp.darknsoft.models;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Book> lib = new ArrayList<>();

    public Buyer() {
    }

    public Buyer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getLib() {
        return lib;
    }

    public void setLib(List<Book> lib) {
        this.lib = lib;
    }

    public boolean buyBook(Book book) {
        if (book != null) {
            getLib().add(book);
        } else {
            return false;
        }
        return true;
    }
}
