package com.mcs.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	// 1.메인페이지(/,/home)
	@GetMapping(value = { "/", "/home" })
	public String homeView() throws Exception {
		System.out.println("메인페이지 요청");
		return "/home";
	}

	// 2.로그인페이지
	@GetMapping("/loginForm")
	public String loginView() {
		System.out.println("로그인페이지 요청 /member/loginForm");
		return "/member/loginForm";
	}

	// 3.회원가입페이지
	@GetMapping("/signupForm")
	public String signupForm() {
		System.out.println("회원가입페이지 요청");
		return "/member/memberForm";
	}
	
	// 3.회원가입페이지(기업용)
		@GetMapping("/companyForm")
		public String companyForm() {
			System.out.println("회원가입페이지 요청");
			return "/company/companyForm";
		}
}
