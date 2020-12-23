package com.jeon.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.jeon.board.dto.MemberDto;
import com.jeon.board.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberSerive;
	
	@Autowired
	JoinValidator joinValidator;
	
	
	@InitBinder
	public void memberBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(joinValidator);
		
	}

	// GET /members/joinForm
	@GetMapping(value="/members/join")
	public String memberJoinForm() {
		return "member/joinForm";
	}
	
	// Create
	//  POST /members
	@PostMapping(value="/members/join")
	public String memberJoin(@Valid MemberDto memberDto, Errors error, String emailDomain) {
		
		if(error.hasErrors()) {
			return "member/joinForm";
		}
		//System.out.println(memberDto);
		//System.out.println(emailDomain);
		
		return "main";
	}
	
	
	// Update
	// POST /members/me
	@PostMapping(value="/members/me")
	public String memberUpdate() {
		return "main";
	}
}
