package com.test.qima.test.service;


import com.test.qima.test.domain.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product, List<Long> categoryIds);
    Product update(Long id, Product product, List<Long> categoryIds);
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
}