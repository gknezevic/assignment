package com.roche.assignment.model.exceptions;

public class ProductsAreDeletedException extends Exception {
    public ProductsAreDeletedException(String deletedProducts) {
        super("Following products are deleted: ".concat(deletedProducts));
    }
}
