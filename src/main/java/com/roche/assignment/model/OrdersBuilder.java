package com.roche.assignment.model;

import com.roche.assignment.model.dto.OrdersDto;
import com.roche.assignment.model.exceptions.InvalidArgumentException;
import com.roche.assignment.model.exceptions.ProductNotFoundException;
import com.roche.assignment.model.exceptions.ProductsAreDeletedException;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrdersBuilder {

    private Optional<String> emailOpt = Optional.empty();
    private Optional<List<Product>> productsOpt = Optional.empty();

    private OrdersBuilder() {}

    public static OrdersBuilder AOrdersBuilder() {
        return new OrdersBuilder();
    }

    public static Orders OrdersFrom(OrdersDto ordersDto, Function<List<String>, Iterable<Product>> getProducts) throws RequiredFieldEmptyException, ProductsAreDeletedException, ProductNotFoundException, InvalidArgumentException {
        Iterable<Product> products = getProducts.apply(ordersDto.getSkuList());
        List<Product> productList = validateOrderedProducts(ordersDto.getSkuList(), products);
        return AOrdersBuilder().withProducts(productList).withEmail(ordersDto.getEmail()).build();
    }

    private static List<Product> validateOrderedProducts(List<String> skuList, Iterable<Product> products) throws ProductsAreDeletedException, ProductNotFoundException {
        List<Product> productList = new ArrayList<>(skuList.size());
        List<Product> deletedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.isDeleted()) {
                deletedProducts.add(product);
            } else {
                productList.add(product);
            }
        }

        if (deletedProducts.size() > 0) {
            throw new ProductsAreDeletedException(String.join(", ", deletedProducts.stream().map(product -> product.getSku()).collect(Collectors.toList())));
        }

        if (productList.size() < skuList.size()) {
            skuList.removeAll(productList.stream().map(product -> product.getSku()).collect(Collectors.toList()));
            throw new ProductNotFoundException(String.join(", ", skuList));
        }

        return productList;
    }

    public Orders build() throws RequiredFieldEmptyException, InvalidArgumentException {
        validation();
        return new Orders(productsOpt.get(), emailOpt.get());
    }

    private void validation() throws RequiredFieldEmptyException, InvalidArgumentException {
        emailOpt.orElseThrow(() -> new RequiredFieldEmptyException("Email"));
        if (!productsOpt.isPresent() || productsOpt.get().isEmpty()) {
            throw new RequiredFieldEmptyException("Products");
        }
        if (emailOpt.get().trim().length() == 0) throw new InvalidArgumentException("Email cannot be empty");
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
