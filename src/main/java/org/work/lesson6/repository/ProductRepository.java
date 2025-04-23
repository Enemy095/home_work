package org.work.lesson6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.work.lesson6.entity.Buyer;
import org.work.lesson6.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product showProductsByPerson(Buyer buyer);

    void deleteProduct(Product product);
}
