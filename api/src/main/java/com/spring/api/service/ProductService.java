package com.spring.api.service;

import com.spring.api.model.Category;
import com.spring.api.model.Product;
import com.spring.api.repository.CategoryRepository;
import com.spring.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProductWithCategory(Product product, Category category) {
        categoryRepository.save(category);
        product.setCategory(category);

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updateProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
