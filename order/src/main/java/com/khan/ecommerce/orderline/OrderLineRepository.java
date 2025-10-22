package com.khan.ecommerce.orderline;

import com.khan.ecommerce.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository  extends JpaRepository<OrderLine, Integer> {
}
