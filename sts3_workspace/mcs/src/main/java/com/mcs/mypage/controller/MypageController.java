package com.mcs.mypage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mcs.member.domain.Member;
import com.mcs.mypage.service.MypageService;
import com.mcs.order.domain.Order;
import com.mcs.order.domain.OrderDetail;

@Controller
public class MypageController {
	@Autowired
	private MypageService mypageService;
	
	
	// #.마이페이지 주문리스트
//	@Transactional
	@GetMapping("/mypage/orderList")
	public String memberOrderList(@AuthenticationPrincipal Member member,Order order, Model model) {
		
//		List<OrderDetail> ordertest = new ArrayList<>();
		
//		List<Order> orderList = new ArrayList<>();
		
		String userid = member.getUserid();

		List<Order> orderList = mypageService.findOrderList(member); // Order테이블
//		List<Order> orderTest = mypageService.findTest(userid);
//		List<OrderDetail> orderDetailTest = mypageService.findTest2(userid);

//		System.out.println(orderList);

		
		
//		List<Map<Order, Object>> list = orderList;
		
		
//		System.out.println(orderList);
		
		
//		List<OrderDetail> orderDetailList = mypageService.findAll();

		
//		for(Order orders : orderList) {
//			List<OrderDetail> orderDetails = orders.getOrderdetail();
//			for(OrderDetail orderDetail : orderDetails) {
//				OrderDetailDto orderdto = new OrderDetailDto(orderDetail);
//			}
//			ordertest.add(orderdto);
//			
//		}
//		Order test = mypageService.findOrderTest("송민섭");
		
		
//		List<OrderDetail> orderDetail = mypageService.findtesttest();
//		if(orderDetail == null) {
//			System.out.println("ㅎㅇ널값");
//		}
//		
//		List<OrderDetail> test2 = mypageService.findtest(test);
//		System.out.println(test2);
		
//		for(Order orders : orderList) {
//			List<OrderDetail> orderDetail = orders.getOrderDetail();
//			OrderDetail orderDetail2 = mypageService.findOrderDetail(orderDetail);
//		}
//		List<OrderDetail> orderDetail = mypageService.findOrderDetail(orderList); // OrderDetail테이블
//		List<OrderDetail> orderDetail = mypageService.findOrderDetail();
//		System.out.println(orderDetail);
		
//		model.addAttribute("test",orderTest);
		model.addAttribute("orderList",orderList);
//		order.setMember(member)
		return "/mypage/memberOrderList";
	}
	
	// #.마이페이지 주문상세리스트
	@GetMapping("/mypage/orderDetail")
	public String memberOrderDetail() {
		return "/mypage/memberOrderDetail";
	}
	
	
}

