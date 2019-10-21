package com.roche.assignment.services;

import com.roche.assignment.model.Orders;
import com.roche.assignment.model.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

public interface OrdersService {

    Iterable<Orders> retriveOrders(LocalDateTime startDate, LocalDateTime endDate);

    Function<List<String>, Iterable<Product>> findAllBySku();

    Orders save(Orders ordersFrom);
}
