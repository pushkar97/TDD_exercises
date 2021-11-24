package com.github.pushkar97.pointOfSale;

import java.util.Optional;

public interface IProductPort {
    Optional<Double> getPriceFor(String id) throws IllegalArgumentException;
}
