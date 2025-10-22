package com.khan.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.POST;

public record PurchaseRequest(

        @NotNull(message = "Product is mandatory")
        Integer productId,

        @Positive(message = "Quantity is mandatory")
        double quantity
) {
}
