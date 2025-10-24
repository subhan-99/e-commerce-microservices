package com.khan.ecommerce.payment;

import com.khan.ecommerce.customer.CustomerResponse;
import com.khan.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record paymentRequest(
        BigDecimal amount,

        PaymentMethod paymentMethod,

        Integer orderID,

        String orderReference,

        CustomerResponse customer
) {
}
