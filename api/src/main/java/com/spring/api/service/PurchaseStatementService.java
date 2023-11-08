package com.spring.api.service;

import com.spring.api.model.PurchaseStatement;
import com.spring.api.repository.PurchaseStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseStatementService {
    private final PurchaseStatementRepository purchaseStatementRepository;

    @Autowired
    public PurchaseStatementService(PurchaseStatementRepository purchaseStatementRepository) {
        this.purchaseStatementRepository = purchaseStatementRepository;
    }

    public List<PurchaseStatement> getAllPurchaseStatements() {
        return purchaseStatementRepository.findAll();
    }

    public PurchaseStatement getPurchaseStatementById(Long id) {
        return purchaseStatementRepository.findById(id).orElse(null);
    }

    public PurchaseStatement savePurchaseStatement(PurchaseStatement purchaseStatement) {
        return purchaseStatementRepository.save(purchaseStatement);
    }

    public PurchaseStatement updatePurchaseStatement(Long id, PurchaseStatement updatedPurchaseStatement) {
        Optional<PurchaseStatement> existingPurchaseStatement = purchaseStatementRepository.findById(id);
        if (existingPurchaseStatement.isPresent()) {
            PurchaseStatement purchaseStatement = existingPurchaseStatement.get();
            purchaseStatement.setDebt(updatedPurchaseStatement.getDebt());
            purchaseStatement.setAmountPaid(updatedPurchaseStatement.getAmountPaid());
            return purchaseStatementRepository.save(purchaseStatement);
        } else {
            return null;
        }
    }

    public void deletePurchaseStatement(Long id) {
        purchaseStatementRepository.deleteById(id);
    }
}
