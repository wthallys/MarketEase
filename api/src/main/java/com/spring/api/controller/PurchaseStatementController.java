package com.spring.api.controller;

import com.spring.api.model.PurchaseStatement;
import com.spring.api.service.PurchaseStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/purchase-statement")
public class PurchaseStatementController {
    private final PurchaseStatementService purchaseStatementService;

    @Autowired
    public PurchaseStatementController(PurchaseStatementService purchaseStatementService) {
        this.purchaseStatementService = purchaseStatementService;
    }

    @GetMapping
    public List<PurchaseStatement> getAllPurchaseStatements() {
        return purchaseStatementService.getAllPurchaseStatements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseStatement> getPurchaseStatementById(@PathVariable Long id) {
        PurchaseStatement purchaseStatement = purchaseStatementService.getPurchaseStatementById(id);
        return (purchaseStatement != null) ? ResponseEntity.ok(purchaseStatement) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseStatement createPurchaseStatement(@RequestBody PurchaseStatement purchaseStatement) {
        return purchaseStatementService.savePurchaseStatement(purchaseStatement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseStatement> updatePurchaseStatement(@PathVariable Long id,
                                                                     @RequestBody PurchaseStatement updatedPurchaseStatement) {
        PurchaseStatement purchaseStatement = purchaseStatementService.updatePurchaseStatement(id, updatedPurchaseStatement);
        return (purchaseStatement != null) ? ResponseEntity.ok(purchaseStatement) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseStatement(@PathVariable Long id) {
        purchaseStatementService.deletePurchaseStatement(id);
        return ResponseEntity.noContent().build();
    }
}
