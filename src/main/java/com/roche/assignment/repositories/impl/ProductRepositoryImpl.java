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

    /**
     *  This method is used instead of @see {@link org.springframework.data.repository.CrudRepository#save(Object)}
     *  because Spring Data JDBC will try performing Update instead of Insert if Id has non-null value.
     *  Issue is reported: https://jira.spring.io/browse/DATAJDBC-269
     *
     * @param product New {@link Product} to be persisted
     * @return Persisted entity
     */
    @Override
    public Product saveWithCustomSku(Product product) {
        return template.insert(product);
    }
}
