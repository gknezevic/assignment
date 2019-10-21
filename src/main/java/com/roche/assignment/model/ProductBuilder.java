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

    public ProductBuilder withSku(String sku) {
        this.skuOpt = Optional.ofNullable(sku);
        return this;
    }

    public ProductBuilder withName(String name) {
        this.nameOpt = Optional.ofNullable(name);
        return this;
    }

    public ProductBuilder withPrice(Float price) {
        this.priceOpt = Optional.ofNullable(price);
        return this;
    }
}
