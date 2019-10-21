package com.roche.assignment;

import com.roche.assignment.model.Product;
import com.roche.assignment.model.ProductBuilder;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;

public class TestObjects {

    public static Product validProductWithSku() {
        try {
            return ProductBuilder.AProductBuilder()
                    .withSku("xyz-123-rst")
                    .withName("Shoes")
                    .withPrice(19.99f)
                    .build();
        } catch (RequiredFieldEmptyException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Product validProductWithRandomSku() {
        try {
            return ProductBuilder.AProductBuilder()
                    .withName("Shoes")
                    .withPrice(19.99f)
                    .build();
        } catch (RequiredFieldEmptyException e) {
            e.printStackTrace();
            return null;
        }
    }
}
