package com.roche.assignment.model.exceptions;

public class RequiredFieldEmptyException extends Exception {
    public RequiredFieldEmptyException(String fieldName) {
        super(String.format("Required field [%s] is empty!", fieldName));
    }
}
