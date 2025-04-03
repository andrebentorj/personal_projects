package com.test.qima.test.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRequest {
    @NotBlank
    private String name;
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private BigDecimal quantityInStock;
    private List<Long> categoryIds;
}