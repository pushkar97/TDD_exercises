package com.github.pushkar97.pointOfSale;

import java.util.List;

public class Checkout {
    private final char CURRENCY = '$';
    IProductPort productPort;

    public Checkout(IProductPort productPort) {
        this.productPort = productPort;
    }

    public String getPrice(String productId) {
        if (productId.isBlank()) return "Error: empty barcode";
        return productPort
                .getPriceFor(productId)
                .map(price -> String.format("%c%.2f", CURRENCY, price))
                .orElse("Error: barcode not found");
    }

    public String calculateTotal(List<String> productIds) {
        if (productIds.isEmpty()) return CURRENCY + "00.00";
        double total = productIds
                .stream()
                .map(productId -> productPort.getPriceFor(productId))
                .mapToDouble(price -> price.orElse(0D))
                .sum();
        return String.format("%c%.2f", CURRENCY, total);
    }
}
