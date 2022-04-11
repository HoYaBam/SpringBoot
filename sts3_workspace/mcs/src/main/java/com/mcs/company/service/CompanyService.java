package com.mcs.company.service;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.mcs.company.domain.Company;

public interface CompanyService {

	void join(@Valid Company dto);
	
//	UserDetails loadUserByUsername(String company);

}
