package com.mcs.member.domain;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@DynamicInsert
@Data
public class Member implements UserDetails {
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private String userid;
	
	private String password;
	private String gender;	
	private String phone;
	private String email;
	private String name;
	private Date birth;
	private int pw_find;
	private String pw_answer;
	private int mileage;
	private String role;
	
	private String addr_num; //우편번호
	private String addr; //주소
	private String addr2; //상세주소
	

//	//회원가입용 Dto
//	public static Member createMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
//        String enPassword = passwordEncoder.encode(memberDto.getMemberpw());
//        Member member = new Member();
//        member.setMemberid(memberDto.getMemberid());
//        member.setMemberpw(enPassword);
//        member.setName(memberDto.getName());
//        member.setPhone(memberDto.getPhone());
//        member.setEmail(memberDto.getEmail());
//
//        return member;
//	}
	
	//UserDetails
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(role));
		return auth;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return userid;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
