//package com.mcs.cart.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.mcs.order.service.OrderService;
//import com.mcs.product.domin.Product;
//import com.mcs.product.service.ProductService;
//
//@Controller
//public class OrderController {
//	@Autowired
//	private OrderService orderService;
//	@Autowired
//	private ProductService productService;
//	
//	@GetMapping("/productOrder")
//	public String productOrder(@RequestParam("pronum") Integer pronum, Model model) {
//		Product productInfo = productService.productInfo(pronum);
//		model.addAttribute("product",productInfo);
//		return "/order/productOrder";
//	}
//	
//}
