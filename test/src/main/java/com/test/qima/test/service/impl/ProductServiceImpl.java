package com.test.qima.test.service.impl;


import com.test.qima.test.domain.Category;
import com.test.qima.test.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.test.qima.test.repository.CategoryRepository;
import com.test.qima.test.repository.ProductRepository;
import com.test.qima.test.service.ProductService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product create(Product product, List<Long> categoryIds) {
        product.setCreationDate(LocalDateTime.now());

        Set<Category> categories = loadCategoriesByIds(categoryIds);
        product.setCategories(categories);

        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product, List<Long> categoryIds) {
        Product productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantityInStock(product.getQuantityInStock());

        if (categoryIds != null && !categoryIds.isEmpty()) {
            Set<Category> categories = loadCategoriesByIds(categoryIds);
            productEntity.setCategories(categories);
        }

        return productRepository.save(productEntity);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    private Set<Category> loadCategoriesByIds(List<Long> categoryIds) {
        if (categoryIds == null || categoryIds.isEmpty()) {
            return new HashSet<>();
        }
        List<Category> foundCategories = categoryRepository.findAllById(categoryIds);
        return new HashSet<>(foundCategories);
    }
}