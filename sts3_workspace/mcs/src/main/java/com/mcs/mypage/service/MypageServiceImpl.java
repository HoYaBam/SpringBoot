package com.mcs.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcs.member.domain.Member;
import com.mcs.order.domain.Order;
import com.mcs.order.domain.OrderDetail;
import com.mcs.order.repository.OrderDetailRepository;
import com.mcs.order.repository.OrderRepository;

@Service
public class MypageServiceImpl implements MypageService{
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderDetailRepository orderDetailRepo;

	@Override
	public List<Order> findOrderList(Member member) {
		List<Order> orderList = orderRepo.findByMember(member);
		return orderList;
	}

	@Override
	public Order findOrderTest(String name) {
		Order test = orderRepo.findByName(name);
		return test;
	}

	@Override
	public List<OrderDetail> findtesttest() {
		
		return orderDetailRepo.findAll();
	}

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailRepo.findAll();
	}

	@Override
	public List<OrderDetail> findByOrder(Order order) {
		return orderDetailRepo.findByOrder(order);
	}

	@Override
	public List<Order> findTest(String userid) {
		return orderRepo.oCheck(userid);
	}

	@Override
	public List<OrderDetail> findTest2(String userid) {
		return orderDetailRepo.oCheck(userid);
	}


//	@Override
//	public OrderDetail findOrderDetail(Order orderDetail) {
//		orderDetailRepo.findByOrder(orderDetail);
//		return null;
//	}


		
//	@Override
//	public List<OrderDetail> findOrderDetail(List<Order> order) {
//		List orderDetail = orderDetailRepo.findByOrder(order);
//		return null;
//	}
	
	
	

}
