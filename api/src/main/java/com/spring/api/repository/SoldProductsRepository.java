package com.spring.api.repository;

import com.spring.api.model.SoldProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldProductsRepository extends JpaRepository<SoldProducts, Long> {
}
