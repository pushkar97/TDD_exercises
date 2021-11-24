package com.github.pushkar97.pointOfSale;

import java.util.Map;
import java.util.Optional;

public class ProductPortDummy implements IProductPort {

    private final Map<String, Double> productPrice = Map.of("12345", 7.25D, "23456", 12.50D);

    @Override
    public Optional<Double> getPriceFor(String id) throws IllegalArgumentException {
        if(id.isBlank()) throw new IllegalArgumentException("empty barcode");
        return Optional.ofNullable(productPrice.get(id));
    }
}
