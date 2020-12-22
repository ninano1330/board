package com.jeon.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jeon.board.dto.MemberDto;

@Controller
public class MemberController {

	@GetMapping(value="/members/join")
	public String memberJoinForm() {
		return "member/joinForm";
	}
	
	@PostMapping(value="/members/join")
	public String memberJoin(MemberDto memberDto, String emailDomain) {
		//System.out.println(memberDto);
		//System.out.println(emailDomain);
		
		
		
		return "main";
	}
	
	
}
