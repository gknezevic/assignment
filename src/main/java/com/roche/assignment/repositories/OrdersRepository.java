package com.roche.assignment.repositories;

import com.roche.assignment.model.Orders;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    @Query("select * from orders where created_on >= :startDate AND created_on < :endDate")
    List<Orders> retriveOrders(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
