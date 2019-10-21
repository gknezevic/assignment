package com.roche.assignment.services.impl;

import com.roche.assignment.model.Product;
import com.roche.assignment.model.exceptions.ProductNotFoundException;
import com.roche.assignment.repositories.ProductRepository;
import com.roche.assignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getBySku(String sku) throws ProductNotFoundException {
        return productRepository.findById(sku).orElseThrow(() -> new ProductNotFoundException(sku));
    }

    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.saveWithCustomSku(product);
    }

    @Override
    public Product update(Product product) throws ProductNotFoundException {
        if (productRepository.existsById(product.getSku())) {
            return productRepository.save(product);
        }
        throw new ProductNotFoundException(product.getSku());
    }

    @Override
    public boolean delete(String sku) throws ProductNotFoundException {
        return productRepository
                .findById(sku)
                .map(product -> product.deleteProduct())
                .map(product -> productRepository.save(product))
                .map(product -> product.isDeleted())
                .orElseThrow(() -> new ProductNotFoundException(sku));
    }
}
