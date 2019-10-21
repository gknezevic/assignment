package com.roche.assignment.model.builders;

import com.roche.assignment.model.Product;
import com.roche.assignment.model.ProductBuilder;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductBuilderTests {

    @Test
    public void creatingProductWithAllFieldsIsSuccessfulTest() throws RequiredFieldEmptyException {
        Product product = ProductBuilder.AProductBuilder()
                .withSku("xyz-123-rst")
                .withName("Shoes")
                .withPrice(13.5f)
                .build();
        assertNotNull(product);
    }

    @Test
    public void creatingProductWithoutSkuIsSuccessfulTest() throws RequiredFieldEmptyException {
        Product product = ProductBuilder.AProductBuilder()
                .withName("Shoes")
                .withPrice(13.5f)
                .build();
        assertNotNull(product);
    }

    @Test
    public void creatingProductWithoutSkuWillSetSkuTest() throws RequiredFieldEmptyException {
        Product product = ProductBuilder.AProductBuilder()
                .withName("Shoes")
                .withPrice(13.5f)
                .build();
        assertNotNull(product.getSku());
    }

    @Test
    public void creatingProductWithoutNameWillFailTest() {
        ProductBuilder productBuilder = ProductBuilder.AProductBuilder()
                .withSku("xyz-123-rst")
                .withPrice(13.5f);

        assertThrows(RequiredFieldEmptyException.class, () -> productBuilder.build());
    }

    @Test
    public void creatingProductWithoutPriceWillFailTest() {
        ProductBuilder productBuilder = ProductBuilder.AProductBuilder()
                .withSku("xyz-123-rst")
                .withName("Shoes");

        assertThrows(RequiredFieldEmptyException.class, () -> productBuilder.build());
    }

    @Test
    public void creatingProductWillSetCreatedDateTest() throws RequiredFieldEmptyException {
        Product product = ProductBuilder.AProductBuilder()
                .withName("Shoes")
                .withPrice(13.5f)
                .build();
        assertNotNull(product.getCreatedOn());
    }

    @Test
    public void createdProductWillHaveDeletedFlagSetToFalseTest() throws RequiredFieldEmptyException {
        Product product = ProductBuilder.AProductBuilder()
                .withName("Shoes")
                .withPrice(13.5f)
                .build();
        assertFalse(product.isDeleted());
    }
}
