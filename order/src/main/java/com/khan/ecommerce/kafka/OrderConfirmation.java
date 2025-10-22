package com.khan.ecommerce.kafka;

import com.khan.ecommerce.customer.CustomerResponse;
import com.khan.ecommerce.order.PaymentMethod;
import com.khan.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,

        BigDecimal totalAmount,

        PaymentMethod paymentMethod,

        CustomerResponse customer,

        List<PurchaseResponse> products

) {
}
