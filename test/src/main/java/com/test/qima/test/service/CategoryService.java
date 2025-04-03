package com.test.qima.test.service;

import com.test.qima.test.domain.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category category);
    Category update(Long id, Category category);
    Category findById(Long id);
    List<Category> findAll();
    void deleteById(Long id);
}