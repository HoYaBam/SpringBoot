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
@Table(name = "order_detail")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderDetail_seq")
    @SequenceGenerator(sequenceName = "order_detail_seq", allocationSize = 1, name = "orderDetail_seq")
	private Integer detailnum; //주문상세번호 1~x
	
	private String pay_method; //결제수단
	private Integer order_count; //수량
	private Integer price; //가격
	private String state; //배송상태
	private String pay_refund; //환불여부
	
	@ManyToOne
	@JoinColumn(name = "ordernum")
	private Order order;
	
	@ManyToOne
    @JoinColumn(name = "pronum")
    private Product product;
}
