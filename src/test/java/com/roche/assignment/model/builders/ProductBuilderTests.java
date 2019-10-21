package com.roche.assignment.model.builders;

import com.roche.assignment.model.Product;
import com.roche.assignment.model.ProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductBuilderTests {

    @Test
    public void creatingProductWithAllFieldsIsSuccessful() {
        Product product = ProductBuilder.AProductBuilder().build();
        Assertions.assertNotNull(product);
    }
}
