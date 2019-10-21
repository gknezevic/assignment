package com.roche.assignment.model;

public class ProductBuilder {

    private ProductBuilder() {}

    public static ProductBuilder AProductBuilder() {
        return new ProductBuilder();
    }

    public Product build() {
        return new Product();
    }
}
