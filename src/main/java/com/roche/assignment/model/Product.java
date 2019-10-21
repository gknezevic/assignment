package com.roche.assignment.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {

    @Id
    private String sku;
    private String name;
    private float price;
    private LocalDateTime createdOn;

    private Product() {}

    Product(String name, float price) {
        this(UUID.randomUUID().toString(), name, price);
    }

    Product(String sku, String name, float price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.createdOn = LocalDateTime.now();
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setPrice(float price) {
        this.price = price;
        return this;
    }
}
