package com.roche.assignment.model;

import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;

import java.util.List;
import java.util.Optional;

public class OrdersBuilder {

    private Optional<String> emailOpt = Optional.empty();
    private Optional<List<Product>> productsOpt = Optional.empty();

    private OrdersBuilder() {}

    public static OrdersBuilder AOrdersBuilder() {
        return new OrdersBuilder();
    }

    public Orders build() throws RequiredFieldEmptyException {
        validation();
        return new Orders(productsOpt.get(), emailOpt.get());
    }

    private void validation() throws RequiredFieldEmptyException {
        emailOpt.orElseThrow(() -> new RequiredFieldEmptyException("Email"));
        if (!productsOpt.isPresent() || productsOpt.get().isEmpty()) {
            throw new RequiredFieldEmptyException("Products");
        }
    }

    public OrdersBuilder withEmail(String email) {
        this.emailOpt = Optional.ofNullable(email);
        return this;
    }

    public OrdersBuilder withProducts(List<Product> products) {
        this.productsOpt = Optional.ofNullable(products);
        return this;
    }

}
