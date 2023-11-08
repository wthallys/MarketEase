package com.spring.api.service;

import com.spring.api.model.Sale;
import com.spring.api.model.SaleType;
import com.spring.api.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public List<Sale> getSalesByType(SaleType type) {
        return saleRepository.findByType(type);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
