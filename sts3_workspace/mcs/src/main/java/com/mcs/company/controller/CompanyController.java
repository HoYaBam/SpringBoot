package com.mcs.company.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.mcs.company.domain.Company;
import com.mcs.company.service.CompanyService;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private PasswordEncoder encoder;
	
	// 1.회원가입(submit버튼)
	@PostMapping("/company/sginup")
	public String join(@Valid Company dto) throws Exception {
		dto.setPassword(encoder.encode(dto.getPassword()));
		dto.setRole("ROLE_MANAGER");
		companyService.join(dto);
//		model.addAttribute("principal",dto);
		return "/home";
	}
}