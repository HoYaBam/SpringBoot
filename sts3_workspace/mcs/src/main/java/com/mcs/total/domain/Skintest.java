package com.mcs.total.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Skintest {
	@Id
	private Integer test_num;
	private String userid;
	private Integer balance;
	private Integer sensitivity;
	private Integer melanin;
	private Integer elasticity;
	private String baumann;
	private Date test_date;
}
