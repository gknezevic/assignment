package com.roche.assignment.services;

import com.roche.assignment.model.Product;
import com.roche.assignment.model.exceptions.ProductNotFoundException;

public interface ProductService {

    Product getBySku(String sku) throws ProductNotFoundException;
    Iterable<Product> getAll();
    Product save(Product product);
    Product update(Product product) throws ProductNotFoundException;
    boolean delete(String sku) throws ProductNotFoundException;
}
