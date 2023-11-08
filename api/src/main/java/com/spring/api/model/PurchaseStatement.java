package com.spring.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PurchaseStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "saleId")
    private Sale sale;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    private Double debt;
    private Double amountPaid;
}
