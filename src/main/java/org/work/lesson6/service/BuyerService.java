package org.work.lesson6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.work.lesson6.entity.Buyer;
import org.work.lesson6.entity.Product;
import org.work.lesson6.repository.BuyerRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    public List<Buyer> findPersonsByProductTitle(String productTitle) {
        return buyerRepository.findPersonsByProductTitle(productTitle);
    }

    public void buy(Buyer buyer, Product product) {
        buyerRepository.buy(buyer, product);
    }

    public void removeBuyer(Buyer buyer) {
        buyerRepository.removeBuyer(buyer);
    }

    public void saveAll(List<Buyer> buyers) {
        buyerRepository.saveAll(buyers);
    }
}
