package com.spring.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
