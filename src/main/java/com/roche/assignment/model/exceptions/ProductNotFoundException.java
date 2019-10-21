package com.roche.assignment.model.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String sku) {
        super(String.format("Product with SKU [%s] not found!", sku));
    }
}
