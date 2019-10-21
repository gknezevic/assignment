package com.roche.assignment.repositories;

import com.roche.assignment.model.Product;
import com.roche.assignment.model.exceptions.ProductSavingException;

public interface ProductRepositoryExtension {

    Product saveWithCustomSku(Product product) throws ProductSavingException;
}
