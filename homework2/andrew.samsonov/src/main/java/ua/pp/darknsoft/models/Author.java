package ua.pp.darknsoft.models;

import java.util.Objects;

public class Author {
    private Long id;
    private String firstNAme;
    private String lastName;

    public Author() {
    }

    public Author(Long id, String firstNAme, String lastName) {
        this.id = id;
        this.firstNAme = firstNAme;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(firstNAme, author.firstNAme) &&
                Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstNAme, lastName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstNAme='" + firstNAme + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
