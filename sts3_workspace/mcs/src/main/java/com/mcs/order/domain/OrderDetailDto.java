package com.mcs.order.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mcs.product.domin.Product;

import lombok.Data;

@Entity
@Data
public class OrderDetailDto {
	
	public OrderDetailDto(OrderDetail orderDetail) {
		this.detailnum = orderDetail.getDetailnum(); 
		this.pay_method = orderDetail.getPay_method();
		this.order_count = orderDetail.getPrice();
		this.price = orderDetail.getPrice();
		this.state = orderDetail.getState();
		this.pay_refund = orderDetail.getPay_refund();
	}
	
	@Id
	private Integer detailnum; //주문상세번호 1~x
	private String pay_method; //결제수단
	private Integer order_count; //수량
	private Integer price; //가격
	private String state; //배송상태
	private String pay_refund; //환불여부
	private Integer ordernum;
	private Integer pronum;
	
}
