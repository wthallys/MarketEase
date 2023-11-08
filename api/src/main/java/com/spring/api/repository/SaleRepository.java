package com.spring.api.repository;

import com.spring.api.model.Sale;
import com.spring.api.model.SaleType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByType(SaleType type);
}
