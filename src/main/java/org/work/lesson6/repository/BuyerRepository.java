package org.work.lesson6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.work.lesson6.entity.Buyer;
import org.work.lesson6.entity.Product;

import java.util.List;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    List<Buyer> findPersonsByProductTitle(String productTitle);

    void buy(Buyer buyer, Product product);

    void removeBuyer(Buyer buyer);
}
