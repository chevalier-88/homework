package ua.pp.darknsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.pp.darknsoft.models.Book;
import ua.pp.darknsoft.models.Buyer;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    @Autowired
    Buyer buyer;
    @Autowired
    Buyer buyer1;

    @Override
    public void printAllBuyers() {
        System.out.println(buyer.getId() + ": " + buyer.getFirstName());
        System.out.println(buyer1.getId() + ": " + buyer1.getFirstName());
    }

    @Override
    public String byuBook(Book book) {

        if (buyer.buyBook(book))
            return "The book - " + book + "was bought";
        return buyer.getFirstName() + " hasn't bought this book";
    }
}
