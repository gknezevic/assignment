package com.roche.assignment.repositories;

import com.roche.assignment.TestObjects;
import com.roche.assignment.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void savingValidProductIsSuccessful() {
        Product testProduct = TestObjects.validProduct();
        Product savedProduct = productRepository.save(testProduct);
        Assertions.assertNotNull(savedProduct);
        Assertions.assertEquals(testProduct.getSku(), savedProduct.getSku());
    }
}
