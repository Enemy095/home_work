package org.work.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.work.lesson8.Entity.Cart;
import org.work.lesson8.service.OrderService;
import org.work.lesson8.service.ProductService;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        OrderService orderService = context.getBean(OrderService.class);
        ProductService productService = context.getBean(ProductService.class);
        Cart cart1 = context.getBean(Cart.class);
        orderService.formAnOrder(fillBasket(cart1, productService));

    }

    public static Cart fillBasket(Cart cart, ProductService productService) {
        cart.addProduct(productService.findByTitle("Молоко"), 4);
        cart.addProduct(productService.findByTitle("Чай"), 5);
        cart.addProduct(productService.findByTitle("Масло"), 5);
        return cart;
    }
}
