package com.roche.assignment.repositories;

import com.roche.assignment.TestObjects;
import com.roche.assignment.model.Product;
import com.roche.assignment.model.exceptions.ProductSavingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void clearDB() {
        productRepository.deleteAll();
    }

    @Test
    public void savingValidProductIsSuccessfulTest() throws ProductSavingException {
        Product testProduct = TestObjects.validProductWithSku();
        Product savedProduct = productRepository.saveWithCustomSku(testProduct);
        assertNotNull(savedProduct);
        assertEquals(testProduct.getSku(), savedProduct.getSku());
    }

    @Test
    public void readingSavedProductIsSuccessfulTest() throws ProductSavingException {
        Product testProduct = TestObjects.validProductWithSku();
        productRepository.saveWithCustomSku(testProduct);
        Optional<Product> savedProductOpt = productRepository.findById(testProduct.getSku());
        assertTrue(savedProductOpt.isPresent());
        assertEquals(testProduct.getSku(), savedProductOpt.get().getSku());
    }

    @Test
    public void updateSavedProductIsSuccessfulTest() throws ProductSavingException {
        Product testProduct = TestObjects.validProductWithSku();
        productRepository.saveWithCustomSku(testProduct);

        Product savedProduct = productRepository.findById(testProduct.getSku()).get();
        savedProduct.setName("newName").setPrice(9.99f);
        productRepository.save(savedProduct);
        Optional<Product> updatedProductOpt = productRepository.findById(testProduct.getSku());

        assertTrue(updatedProductOpt.isPresent());
        assertEquals(testProduct.getSku(), updatedProductOpt.get().getSku());

        assertNotEquals(testProduct.getName(), updatedProductOpt.get().getName());
        assertEquals(savedProduct.getName(), updatedProductOpt.get().getName());

        assertNotEquals(testProduct.getPrice(), updatedProductOpt.get().getPrice());
        assertEquals(savedProduct.getPrice(), updatedProductOpt.get().getPrice());
    }
}
