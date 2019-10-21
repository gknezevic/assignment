package com.roche.assignment.model.dto;

import java.util.List;

public class OrdersDto {

    private String email;
    private List<String> skuList;

    public String getEmail() {
        return email;
    }

    public List<String> getSkuList() {
        return skuList;
    }
}
