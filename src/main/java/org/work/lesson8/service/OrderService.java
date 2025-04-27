package org.work.lesson8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.work.lesson8.Entity.Cart;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final ProductService productService;

    public Integer amountOrder(Cart cart) {
        return cart.getCart().entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .mapToInt((entry) -> productService.totalCost(entry.getKey(), entry.getValue()))
                .sum();
    }

    public void formAnOrder(Cart cart) {
        List<String> order = new ArrayList<>();
        cart.getCart().forEach((k, v) -> {
            if (k != null) {
                String string = " название товара = " + k.getTitle()
                        + "  цена = " + k.getCost()
                        + "  количество = " + v
                        + "  общая цена = " + productService.totalCost(k, v) + "\n";
                order.add(string);
            }
        });
        order.add("Общая стоимость заказа " + amountOrder(cart));
        System.out.println(order);
    }
}
