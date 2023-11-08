package com.spring.api.repository;

import com.spring.api.model.PurchaseStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseStatementRepository extends JpaRepository<PurchaseStatement, Long> {
}
