package com.roche.assignment.model;

import com.roche.assignment.model.dto.ProductDto;
import com.roche.assignment.model.exceptions.InvalidArgumentException;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;

import java.util.Optional;

public class ProductBuilder {

    private Optional<String> skuOpt = Optional.empty();
    private Optional<String> nameOpt = Optional.empty();
    private Optional<Float> priceOpt = Optional.empty();

    private ProductBuilder() {}

    public static ProductBuilder AProductBuilder() {
        return new ProductBuilder();
    }

    public static Product ProductFrom(ProductDto productDto) throws RequiredFieldEmptyException, InvalidArgumentException {
        if (productDto == null) throw new RequiredFieldEmptyException("Name and Price");
        return AProductBuilder()
                .withSku(productDto.getSku())
                .withName(productDto.getName())
                .withPrice(productDto.getPrice())
                .build();
    }

    public Product build() throws RequiredFieldEmptyException, InvalidArgumentException {
        validation();
        return skuOpt
                .map(sku -> new Product(sku, nameOpt.get(), priceOpt.get()))
                .orElse(new Product(nameOpt.get(), priceOpt.get()));
    }

    private void validation() throws RequiredFieldEmptyException, InvalidArgumentException {
        nameOpt.orElseThrow(() -> new RequiredFieldEmptyException("Name"));
        if (nameOpt.get().trim().length() == 0) throw new InvalidArgumentException("Name cannot be empty");

        priceOpt.orElseThrow(() -> new RequiredFieldEmptyException("Price"));
        if (priceOpt.get() <= 0f) throw new InvalidArgumentException("Price must be larger then 0");

        if (skuOpt.isPresent() && skuOpt.get().trim().length() == 0) {
            throw new InvalidArgumentException("SKU cannot be empty string");
        }
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
