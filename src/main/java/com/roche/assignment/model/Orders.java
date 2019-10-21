package com.roche.assignment.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Orders {

    @Id
    private int id;
    private String email;
    private Set<ProductRef> productRefs;
    private LocalDateTime createdOn;

    private Orders() {}

    Orders(List<Product> products, String email) {

    }

}
