package com.roche.assignment.repositories;

import com.roche.assignment.model.Product;

public interface ProductRepositoryExtension {

    Product saveWithCustomSku(Product product);
}
