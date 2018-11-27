package io.github.badgateway12.jee.beans;

import com.google.common.base.Preconditions;

import java.util.*;
import java.util.stream.IntStream;

public class Cart {
    private final CartService service;
    private final Map<String, Integer> order;

    public Cart(CartService service) {
        this.service = service;
        order = new HashMap<>();
    }

    public void add(String id) {
        Preconditions.checkNotNull(id, "Id can not be null");
        service.reserve(id, 1);
        order.merge(id, 1, (oldValue, newValue) -> oldValue + newValue);
    }

    public void remove(String id) {
        Preconditions.checkNotNull(id, "Id can not be null");
        Preconditions.checkNotNull(order.getOrDefault(id, null), "There is no book" + id + " in the cart");
        Preconditions.checkArgument(order.get(id) - 1 >= 0, "Not enough books in the cart");
        service.reserve(id, -1);
        order.merge(id, 1, (oldValue, newValue) -> oldValue - newValue);
        order.remove(id, 0);
    }

    public void empty() {
         order.forEach((id, count) -> service.reserve(id, count * -1));
         order.clear();
    }

    public double getTotalSum() {
        return order
                .entrySet()
                .stream()
                .mapToDouble(orderItem -> service.getBookInfo(orderItem.getKey()).getPrice() * orderItem.getValue())
                .sum();
    }

    public int getTotalPositions() {
        return order.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart{");
        order.forEach((id, count) -> sb.append(service.getBookInfo(id).getTitle()).append("=").append(count).append(";"));
        sb.append("}");
        sb. append("\n");
        sb.append("Total: ");
        sb.append(getTotalSum());
        sb. append("\n");
        return sb.toString();
    }
}


