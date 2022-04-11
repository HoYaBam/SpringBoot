package com.mcs.company.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mcs.company.domain.Company;
import com.mcs.company.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepo;
	
	@Override
	public void join(@Valid Company dto) {
		companyRepo.save(dto);
	}

//	//2.로그인(submit버튼)
//	@Override
//	public UserDetails loadUserByUsername(String company) throws UsernameNotFoundException {
//			Company comp = companyRepo.findByCompany(company);
//			System.out.println("기업 로그인 실행");
//			System.out.println("대표자명 : " + comp.getCeo_name());
//			System.out.println("기업명 : " + comp.getCompany_name());
//			return comp;			
//	}
	
}
