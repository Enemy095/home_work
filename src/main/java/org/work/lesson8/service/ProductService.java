package org.work.lesson8.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.work.lesson8.Entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products;

    @PostConstruct
    public void products() {
        Product p1 = new Product("Хлеб", 45);
        Product p2 = new Product("Булочка", 35);
        Product p3 = new Product("Мороженое", 60);
        Product p4 = new Product("Масло", 180);
        Product p5 = new Product("Мука", 150);
        Product p6 = new Product("Сок", 130);
        Product p7 = new Product("Кефир", 130);
        Product p8 = new Product("Сметана", 150);
        Product p9 = new Product("Мясо", 500);
        Product p10 = new Product("Чай", 300);

        products = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
    }

    public void printAll() {
        products.forEach(System.out::println);
    }

    public Product findByTitle(String title) {
        return products.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public Integer totalCost(Product product, Integer quality) {
        return product.getCost() * quality;
    }


}
