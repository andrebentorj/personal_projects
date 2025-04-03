package com.test.qima.test.service.impl;


import com.test.qima.test.domain.Category;
import com.test.qima.test.domain.Product;
import org.springframework.stereotype.Service;
import com.test.qima.test.repository.CategoryRepository;
import com.test.qima.test.repository.ProductRepository;
import com.test.qima.test.service.ProductService;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product create(Product product, List<Long> categoryIds) {
        // Se quisermos definir a data de criação agora
        product.setCreationDate(LocalDateTime.now());

        // Carregar as categorias pelo ID
        Set<Category> categories = loadCategoriesByIds(categoryIds);
        product.setCategories(categories);

        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product, List<Long> categoryIds) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setQuantityInStock(product.getQuantityInStock());

        // Se quiser atualizar a data ao editar, ficaria a critério do negócio
        // existing.setCreationDate(LocalDateTime.now()); // Normalmente não se atualiza data de criação

        // Atualizar categorias
        if (categoryIds != null && !categoryIds.isEmpty()) {
            Set<Category> categories = loadCategoriesByIds(categoryIds);
            existing.setCategories(categories);
        }

        return productRepository.save(existing);
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

    // Método utilitário para carregar categorias
    private Set<Category> loadCategoriesByIds(List<Long> categoryIds) {
        if (categoryIds == null || categoryIds.isEmpty()) {
            return new HashSet<>();
        }
        List<Category> foundCategories = categoryRepository.findAllById(categoryIds);
        return new HashSet<>(foundCategories);
    }
}