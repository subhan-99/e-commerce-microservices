package com.khan.ecommerce.product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Integer productID,

        String name,

        String description,

        BigDecimal price,

        double quantity
) {
}
