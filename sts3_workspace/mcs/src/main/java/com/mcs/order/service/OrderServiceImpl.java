package com.mcs.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.order.domain.Order;
import com.mcs.order.domain.OrderDetail;
import com.mcs.order.repository.OrderDetailRepository;
import com.mcs.order.repository.OrderRepository;
import com.mcs.order.repository.RefundRepository;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderInfoRepo;
	@Autowired
	private OrderDetailRepository orderDetailRepo;
	@Autowired
	private RefundRepository refundRepo;

	
	
	@Override
	public void saveOrder(Order order) {
		orderInfoRepo.save(order);
		
	}


	@Override
	public void saveOrderDetail(OrderDetail orderDetail) {
		orderDetailRepo.save(orderDetail);
		
	}

	
	
	
}
