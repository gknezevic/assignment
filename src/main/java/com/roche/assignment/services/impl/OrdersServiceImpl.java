package com.roche.assignment.services.impl;

import com.roche.assignment.model.Orders;
import com.roche.assignment.model.Product;
import com.roche.assignment.repositories.OrdersRepository;
import com.roche.assignment.repositories.ProductRepository;
import com.roche.assignment.services.OrdersService;
import com.roche.assignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductService productService;

    @Override
    public Iterable<Orders> retriveOrders(LocalDateTime startDate, LocalDateTime endDate) {
        return ordersRepository.findAll();
    }

    @Override
    public Function<List<String>, Iterable<Product>> findAllBySku() {
        return skus -> productService.findAllBySku(skus);
    }

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }
}
