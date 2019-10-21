package com.roche.assignment.model.exceptions;

public class ProductSavingException extends Exception {
    public ProductSavingException(String sku) {
        super(String.format("Error while saving product with SKU [%s].", sku));
    }
}
