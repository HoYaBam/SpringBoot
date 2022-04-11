package com.mcs.order.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.mcs.member.domain.Member;

import lombok.Data;

@Entity
@Data
@Table(name="order_info")
@EntityListeners(AuditingEntityListener.class)
public class Order {
	
	@Id
	private String ordernum; //二쇰Ц踰덊샇 �삤�뒛�궇吏�0001~x
	
	private String name; //�닔�졊�씤 
	private String phone; //�닔�졊�씤 �뿰�씫泥�
	private String addr_num; //�슦�렪踰덊샇
	private String addr; //二쇱냼
	private String addr2; //�긽�꽭二쇱냼
	@CreatedDate
	private LocalDateTime order_date;
	private Integer amount;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private Member member;
	
	@BatchSize(size=20)
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	private List<OrderDetail> orderdetail = new ArrayList<>();
	
	
}

