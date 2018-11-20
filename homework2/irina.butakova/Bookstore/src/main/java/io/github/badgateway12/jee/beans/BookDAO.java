package io.github.badgateway12.jee.beans;

import com.google.common.base.Preconditions;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookDAO implements CartService {
    private Map<String, Book> dao;

    public BookDAO() {
        dao = new HashMap<>();
    }

    public void changeBalance(Book book, int count) {
        Preconditions.checkNotNull(book, "Book can not be null");
        book.changeBalance(count);
        dao.putIfAbsent(book.getId(), book);
    }

    @Override
    public BookDTO reserve(String id, int count) {
        Preconditions.checkNotNull(id, "Id can not be null");
        Preconditions.checkNotNull(dao.getOrDefault(id, null), "Book " + id + " can not be found");
        return dao.get(id).reserve(count);
    }

    @Override
    public BookDTO getBookInfo(String id) {
        Preconditions.checkNotNull(id, "Id can not be null");
        Preconditions.checkNotNull(dao.getOrDefault(id, null), "Book " + id + " can not be found");
        return dao.get(id);
    }

    @Override
    public Collection<BookDTO> getAll() {
        return new ArrayList<>(dao.values());
    }

    @Override
    public Collection<BookDTO> filter(Predicate<BookDTO> criteria) {
        return dao
                .values()
                .stream()
                .filter(criteria::test)
                .collect(Collectors.toList());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Books {");
        dao.forEach((id, book) -> sb.append(book.toString()).append(";").append("\n"));
        sb.append("}");
        return sb.toString();
    }
}
