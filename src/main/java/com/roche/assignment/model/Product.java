package com.roche.assignment.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {

    private String sku;
    private String name;
    private float price;
    private LocalDateTime createdOn;

    Product(String name, float price) {
        this(UUID.randomUUID().toString(), name, price);
    }

    Product(String sku, String name, float price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.createdOn = LocalDateTime.now();
    }
}
