package com.roche.assignment.model.builders;

import com.roche.assignment.model.Orders;
import com.roche.assignment.model.OrdersBuilder;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static com.roche.assignment.TestObjects.validProductWithRandomSku;
import static com.roche.assignment.TestObjects.validProductWithSku;
import static org.junit.jupiter.api.Assertions.*;

public class OrdersBuilderTests {

    @Test
    public void creatingOrdersWithAllFieldsIsSuccessfulTest() throws RequiredFieldEmptyException {
        Orders orders = OrdersBuilder.AOrdersBuilder()
                .withEmail("fake@mail.com")
                .withProducts(Arrays.asList(validProductWithSku()))
                .build();
        assertNotNull(orders);
    }

    @Test
    public void creatingOrdersWithoutEmailWillThrowExceptionTest() {
        OrdersBuilder ordersBuilder = OrdersBuilder.AOrdersBuilder()
                .withProducts(Arrays.asList(validProductWithSku()));
        assertThrows(RequiredFieldEmptyException.class, () -> ordersBuilder.build());
    }

    @Test
    public void creatingOrdersWithoutProductsWillThrowExceptionTest() {
        OrdersBuilder ordersBuilder = OrdersBuilder.AOrdersBuilder()
                .withEmail("fake@mail.com");
        assertThrows(RequiredFieldEmptyException.class, () -> ordersBuilder.build());
    }

    @Test
    public void creatingOrdersWithEmptyProductsListWillThrowExceptionTest() {
        OrdersBuilder ordersBuilder = OrdersBuilder.AOrdersBuilder()
                .withEmail("fake@mail.com")
                .withProducts(new ArrayList<>());
        assertThrows(RequiredFieldEmptyException.class, () -> ordersBuilder.build());
    }

    @Test
    public void creatingOrdersWillFillProductRefsTest() throws RequiredFieldEmptyException {
        Orders orders = OrdersBuilder.AOrdersBuilder()
                .withEmail("fake@mail.com")
                .withProducts(Arrays.asList(validProductWithRandomSku(), validProductWithRandomSku(), validProductWithRandomSku()))
                .build();

        assertTrue(orders.getProductRefs().size() == 3);
    }

    @Test
    public void totalProductPriceIsCalculatedInOrdersTest() throws RequiredFieldEmptyException {
        Orders orders = OrdersBuilder.AOrdersBuilder()
                .withEmail("fake@mail.com")
                .withProducts(Arrays.asList(
                        validProductWithRandomSku().setPrice(1f),
                        validProductWithRandomSku().setPrice(2.5f),
                        validProductWithRandomSku().setPrice(0.5f)))
                .build();

        assertEquals(4f, orders.getTotalPrice());
    }

}
