package com.jeon.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeon.board.dto.MemberDto;
import com.jeon.board.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping(value="/login")
	public String loginForm() {
		return "login/loginForm";
	}
	
	@PostMapping(value="/login")
	@ResponseBody
	//public String login(MemberDto memberDto, HttpServletRequest request) {
	public String login(String memberId, String memberPw, HttpServletRequest request) {
		System.out.println(memberId);
		System.out.println(memberPw);
		
		MemberDto memberDto = new MemberDto();
		memberDto.setMemberId(memberId);
		memberDto.setMemberPw(memberPw);
		
		MemberDto boardSessionId = loginService.login(memberDto);

		if(boardSessionId != null) {
			HttpSession session = request.getSession();
			session.setAttribute("boardSessionId", boardSessionId);
			
			//return "<script>window.close();</script>";
			return "1";
		}else {
			//return "<script>alert('로그인이 실패했습니다')</script>";
			return "0";
		}
	}
	
	@PostMapping(value="/logout")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("boardSessionId");
		
		return "main";
	}

}
