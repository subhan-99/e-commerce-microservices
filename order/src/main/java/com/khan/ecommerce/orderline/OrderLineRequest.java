package com.khan.ecommerce.orderline;

public record OrderLineRequest(
        Integer id,

        Integer orderId,

        Integer integer,

        double quantity) {
}
