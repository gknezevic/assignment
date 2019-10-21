package com.roche.assignment.controller;

import com.roche.assignment.model.OrdersBuilder;
import com.roche.assignment.model.dto.OrdersDto;
import com.roche.assignment.model.exceptions.ProductNotFoundException;
import com.roche.assignment.model.exceptions.ProductsAreDeletedException;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;
import com.roche.assignment.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity getOrders(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime startDate,
                                    @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime endDate) {
        return ResponseEntity.ok(ordersService.retriveOrders(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity placeOrders(@RequestBody OrdersDto ordersDto) throws RequiredFieldEmptyException, ProductsAreDeletedException, ProductNotFoundException {
        return ResponseEntity.ok(ordersService.save(OrdersBuilder.OrdersFrom(ordersDto, ordersService.findAllBySku())));
    }

}
