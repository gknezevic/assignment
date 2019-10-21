package com.roche.assignment.services;

import com.roche.assignment.TestObjects;
import com.roche.assignment.model.Product;
import com.roche.assignment.model.exceptions.ProductNotFoundException;
import com.roche.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void clearDB() {
        productRepository.deleteAll();
    }

    @Test
    public void getSavedProductIsSuccessfulTest() throws ProductNotFoundException {
        Product testProduct = TestObjects.validProductWithSku();
        productRepository.saveWithCustomSku(testProduct);

        Product savedProduct = productService.getBySku(testProduct.getSku());

        assertNotNull(savedProduct);
        assertEquals(testProduct.getSku(), savedProduct.getSku());
    }

    @Test
    public void getNonExistingProductWillThrowExceptionTest() {
        assertThrows(ProductNotFoundException.class, () -> productService.getBySku("fake-sku"));
    }

    @Test
    public void updateSavedProductIsSuccessfulTest() throws ProductNotFoundException {
        Product testProduct = TestObjects.validProductWithSku();
        productService.save(testProduct);

        Product savedProduct = productService.getBySku(testProduct.getSku());
        savedProduct.setName("newName").setPrice(9.99f);
        productService.update(savedProduct);
        Product updatedProductOpt = productService.getBySku(testProduct.getSku());

        assertNotNull(updatedProductOpt);
        assertEquals(testProduct.getSku(), updatedProductOpt.getSku());

        assertNotEquals(testProduct.getName(), updatedProductOpt.getName());
        assertEquals(savedProduct.getName(), updatedProductOpt.getName());

        assertNotEquals(testProduct.getPrice(), updatedProductOpt.getPrice());
        assertEquals(savedProduct.getPrice(), updatedProductOpt.getPrice());
    }

    @Test
    public void updateNonExistingProductWillThrowExceptionTest() {
        Product notSavedProduct = TestObjects.validProductWithSku();
        assertThrows(ProductNotFoundException.class, () -> productService.update(notSavedProduct));
    }

}