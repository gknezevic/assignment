package com.roche.assignment.model;

import java.util.Optional;

public class ProductBuilder {

    private Optional<String> skuOpt = Optional.empty();
    private Optional<String> nameOpt = Optional.empty();
    private Optional<Float> priceOpt = Optional.empty();

    private ProductBuilder() {}

    public static ProductBuilder AProductBuilder() {
        return new ProductBuilder();
    }

    public Product build() {
        return skuOpt
                .map(sku -> new Product(sku, nameOpt.get(), priceOpt.get()))
                .orElse(new Product(nameOpt.get(), priceOpt.get()));
    }
}
