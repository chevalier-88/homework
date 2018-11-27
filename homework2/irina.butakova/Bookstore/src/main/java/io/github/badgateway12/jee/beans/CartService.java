package io.github.badgateway12.jee.beans;

import java.util.Collection;
import java.util.function.Predicate;

public interface CartService {
    BookDTO reserve(String id, int count);
    BookDTO getBookInfo(String id);
    Collection<BookDTO> getAll();
    Collection<BookDTO> filter(Predicate<BookDTO> criteria);
}
