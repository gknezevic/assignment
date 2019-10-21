package com.roche.assignment.repositories;

import com.roche.assignment.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String>, ProductRepositoryExtension {
}
