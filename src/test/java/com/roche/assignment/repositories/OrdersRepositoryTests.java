package com.roche.assignment.repositories;

import com.roche.assignment.model.Orders;
import com.roche.assignment.model.OrdersBuilder;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static com.roche.assignment.TestObjects.validProductWithRandomSku;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrdersRepositoryTests {

    @Autowired
    private OrdersRepository ordersRepository;

    @BeforeEach
    public void clearDB() {
        ordersRepository.deleteAll();
    }

    @Test
    public void savingValidOrdersIsSuccessfulTest() throws RequiredFieldEmptyException {
        Orders orders = OrdersBuilder.AOrdersBuilder()
                .withEmail("fake@mail.com")
                .withProducts(Arrays.asList(validProductWithRandomSku(), validProductWithRandomSku(), validProductWithRandomSku()))
                .build();

        Orders savedOrders = ordersRepository.save(orders);

        assertNotNull(savedOrders);
        assertNotNull(savedOrders.getId());
    }

    @Test
    public void readingSavedOrdersIsSuccessfulTest() throws RequiredFieldEmptyException {
        Orders orders = OrdersBuilder.AOrdersBuilder()
                .withEmail("fake@mail.com")
                .withProducts(Arrays.asList(validProductWithRandomSku(), validProductWithRandomSku(), validProductWithRandomSku()))
                .build();

        Orders savedOrders = ordersRepository.save(orders);


        Optional<Orders> retrivedOrdersOpt = ordersRepository.findById(savedOrders.getId());
        assertTrue(retrivedOrdersOpt.isPresent());
        assertEquals(savedOrders.getId(), retrivedOrdersOpt.get().getId());
    }

}
