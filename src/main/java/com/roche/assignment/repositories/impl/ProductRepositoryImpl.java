package com.roche.assignment.repositories.impl;

import com.roche.assignment.model.Product;
import com.roche.assignment.repositories.ProductRepositoryExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryExtension {

    @Autowired
    private JdbcAggregateTemplate template;

    @Override
    public Product saveWithCustomSku(Product product) {
        return template.insert(product);
    }
}
