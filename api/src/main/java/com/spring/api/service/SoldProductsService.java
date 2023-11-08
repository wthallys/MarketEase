package com.spring.api.service;

import com.spring.api.model.SoldProducts;
import com.spring.api.repository.SoldProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoldProductsService {
    private final SoldProductsRepository soldProductsRepository;

    @Autowired
    public SoldProductsService(SoldProductsRepository soldProductsRepository) {
        this.soldProductsRepository = soldProductsRepository;
    }

    public List<SoldProducts> getAllSoldProducts() {
        return soldProductsRepository.findAll();
    }

    public SoldProducts getSoldProductsById(Long id) {
        return soldProductsRepository.findById(id).orElse(null);
    }

    public SoldProducts saveSoldProducts(SoldProducts soldProducts) {
        return soldProductsRepository.save(soldProducts);
    }

    public SoldProducts updateSoldProducts(Long id, SoldProducts updatedSoldProducts) {
        Optional<SoldProducts> existingSoldProducts = soldProductsRepository.findById(id);
        if (existingSoldProducts.isPresent()) {
            SoldProducts soldProducts = existingSoldProducts.get();
            soldProducts.setQuantity(updatedSoldProducts.getQuantity());
            return soldProductsRepository.save(soldProducts);
        } else {
            return null;
        }
    }

    public void deleteSoldProducts(Long id) {
        soldProductsRepository.deleteById(id);
    }
}
