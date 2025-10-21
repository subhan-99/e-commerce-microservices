package com.khan.ecommerce.order;

import com.khan.ecommerce.customer.CustomerClient;
import com.khan.ecommerce.exception.BusinessException;
import com.khan.ecommerce.product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;

    public Integer createdOrder( OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer exist"));

        // purchase the products --> product-ms

        //persist order

        // persist order lines

        // start payment process

        // send the order confirmation --> notification-ms (kafka)

        return null;
    }
}
