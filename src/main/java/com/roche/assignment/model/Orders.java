package com.roche.assignment.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Orders {

    @Id
    private Integer id;
    private String email;
    private Set<ProductRef> productRefs;
    private LocalDateTime createdOn;

    private Orders() {}

    Orders(List<Product> products, String email) {
        this.productRefs = products.stream().map(product -> new ProductRef(product.getSku(), product.getPrice())).collect(Collectors.toSet());
        this.email = email;
        this.createdOn = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Set<ProductRef> getProductRefs() {
        return productRefs;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public float getTotalPrice() {
        return productRefs.stream()
                .map(productRef -> productRef.getPrice())
                .reduce(0f, (x, y) -> x + y);
    }
}
