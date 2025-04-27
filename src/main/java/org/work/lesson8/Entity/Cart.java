package org.work.lesson8.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Component
@Scope("prototype")
public class Cart {
    private Map<Product, Integer> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        cart.put(product, quantity);
    }
}
