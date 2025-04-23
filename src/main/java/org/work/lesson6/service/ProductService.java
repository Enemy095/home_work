package org.work.lesson6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.work.lesson6.entity.Buyer;
import org.work.lesson6.entity.Product;
import org.work.lesson6.repository.ProductRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public void showProductsByPerson(Buyer buyer) {
        System.out.println(productRepository.showProductsByPerson(buyer));
    }

    public void deleteProduct(Product product) {
        productRepository.deleteProduct(product);
    }

    public void saveAll(List<Product> products) {
        productRepository.saveAll(products);
    }
}
