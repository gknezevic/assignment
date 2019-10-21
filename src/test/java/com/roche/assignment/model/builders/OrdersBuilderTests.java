package com.roche.assignment.model.builders;

import com.roche.assignment.model.Orders;
import com.roche.assignment.model.OrdersBuilder;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.roche.assignment.TestObjects.validProductWithSku;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrdersBuilderTests {

    @Test
    public void creatingOrdersWithAllFieldsIsSuccessfulTest() throws RequiredFieldEmptyException {
        Orders orders = OrdersBuilder.AOrdersBuilder()
                .withEmail("fake@mail.com")
                .withProducts(Arrays.asList(validProductWithSku()))
                .build();
        assertNotNull(orders);
    }

}
