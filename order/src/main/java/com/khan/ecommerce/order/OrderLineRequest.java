package com.khan.ecommerce.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderLineRequest(
        Integer id,

        Integer orderId,

        Integer integer,

        double quantity) {
}
