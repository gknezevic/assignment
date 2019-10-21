package com.roche.assignment.model;

import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS_TO_PRODUCTS")
public class ProductRef {

    private String product;
    private float price;

    public ProductRef(String product, float price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public float getPrice() {
        return price;
    }
}
