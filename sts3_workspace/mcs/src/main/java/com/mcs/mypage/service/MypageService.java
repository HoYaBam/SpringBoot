package com.mcs.mypage.service;

import java.util.List;

import com.mcs.member.domain.Member;
import com.mcs.order.domain.Order;
import com.mcs.order.domain.OrderDetail;

public interface MypageService {

	List<Order> findOrderList(Member member);

	Order findOrderTest(String name);


	List<OrderDetail> findtesttest();

	List<OrderDetail> findAll();

	List<OrderDetail> findByOrder(Order order);

	List<Order> findTest(String userid);

	List<OrderDetail> findTest2(String userid);

//	OrderDetail findOrderDetail(Order orderDetail);


//	List<OrderDetail> findOrderDetail(List<Order> orderList);

}
