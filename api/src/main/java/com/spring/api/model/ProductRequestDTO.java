package com.spring.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private Product product;
    private Category category;
}
