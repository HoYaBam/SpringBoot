package com.mcs.order.service;

import com.mcs.order.domain.Order;
import com.mcs.order.domain.OrderDetail;

public interface OrderService {

	void saveOrder(Order order);

	void saveOrderDetail(OrderDetail orderDetail);

	
	
}
