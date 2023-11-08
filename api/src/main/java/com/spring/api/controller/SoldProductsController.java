package com.spring.api.controller;

import com.spring.api.model.SoldProducts;
import com.spring.api.service.SoldProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/sold-products")
public class SoldProductsController {
    private final SoldProductsService soldProductsService;

    @Autowired
    public SoldProductsController(SoldProductsService soldProductsService) {
        this.soldProductsService = soldProductsService;
    }

    @GetMapping
    public List<SoldProducts> getAllSoldProducts() {
        return soldProductsService.getAllSoldProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldProducts> getSoldProductsById(@PathVariable Long id) {
        SoldProducts soldProducts = soldProductsService.getSoldProductsById(id);
        return (soldProducts != null) ? ResponseEntity.ok(soldProducts) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SoldProducts createSoldProducts(@RequestBody SoldProducts soldProducts) {
        return soldProductsService.saveSoldProducts(soldProducts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoldProducts> updateSoldProducts(@PathVariable Long id,
                                                           @RequestBody SoldProducts updatedSoldProducts) {
        SoldProducts soldProducts = soldProductsService.updateSoldProducts(id, updatedSoldProducts);
        return (soldProducts != null) ? ResponseEntity.ok(soldProducts) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoldProducts(@PathVariable Long id) {
        soldProductsService.deleteSoldProducts(id);
        return ResponseEntity.noContent().build();
    }
}
