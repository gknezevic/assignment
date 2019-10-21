package com.roche.assignment.repositories;

import com.roche.assignment.TestObjects;
import com.roche.assignment.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void clearDB() {
        productRepository.deleteAll();
    }

    @Test
    public void savingValidProductIsSuccessful() {
        Product testProduct = TestObjects.validProductWithSku();
        Product savedProduct = productRepository.saveWithCustomSku(testProduct);
        Assertions.assertNotNull(savedProduct);
        Assertions.assertEquals(testProduct.getSku(), savedProduct.getSku());
    }

    @Test
    public void readingSavedProductIsSuccessful() {
        Product testProduct = TestObjects.validProductWithSku();
        productRepository.saveWithCustomSku(testProduct);
        Optional<Product> savedProductOpt = productRepository.findById(testProduct.getSku());
        Assertions.assertTrue(savedProductOpt.isPresent());
        Assertions.assertEquals(testProduct.getSku(), savedProductOpt.get().getSku());
    }
}
