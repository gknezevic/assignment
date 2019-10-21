package com.roche.assignment.model.builders;

import com.roche.assignment.model.Product;
import com.roche.assignment.model.ProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class ProductBuilderTests {

    @Test
    public void creatingProductWithAllFieldsIsSuccessfulTest() {
        Product product = ProductBuilder.AProductBuilder()
                .withSku("xyz-123-rst")
                .withName("Shoes")
                .withPrice(13.5f)
                .build();
        Assertions.assertNotNull(product);
    }

    @Test
    public void creatingProductWithoutSkuIsSuccessfulTest() {
        Product product = ProductBuilder.AProductBuilder()
                .withName("Shoes")
                .withPrice(13.5f)
                .build();
        Assertions.assertNotNull(product);
    }

    @Test
    public void creatingProductWithoutNameWillFailTest() {
        ProductBuilder productBuilder = ProductBuilder.AProductBuilder()
                .withSku("xyz-123-rst")
                .withPrice(13.5f);

        Assertions.assertThrows(NoSuchElementException.class, () -> productBuilder.build());
    }

    @Test
    public void creatingProductWithoutPriceWillFailTest() {
        ProductBuilder productBuilder = ProductBuilder.AProductBuilder()
                .withSku("xyz-123-rst")
                .withName("Shoes");

        Assertions.assertThrows(NoSuchElementException.class, () -> productBuilder.build());
    }
}
