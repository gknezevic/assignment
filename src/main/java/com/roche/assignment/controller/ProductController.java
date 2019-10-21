package com.roche.assignment.controller;

import com.roche.assignment.model.dto.ProductDto;
import com.roche.assignment.model.exceptions.ProductNotFoundException;
import com.roche.assignment.model.exceptions.ProductSavingException;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;
import com.roche.assignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.roche.assignment.model.ProductBuilder.ProductFrom;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{sku}")
    public ResponseEntity getProduct(@PathVariable String sku) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.getBySku(sku));
    }

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto) throws RequiredFieldEmptyException, ProductSavingException {
        return ResponseEntity.ok(productService.save(ProductFrom(productDto)));
    }
}
