package com.jeon.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

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
	public String login(MemberDto memberDto, HttpServletRequest request) {
//	public String login(String memberId, String memberPw, HttpServletRequest request) {		
//		MemberDto memberDto = new MemberDto();
//		memberDto.setMemberId(memberId);
//		memberDto.setMemberPw(memberPw);
		
//		System.out.println(memberDto.getMemberId());
//		System.out.println(memberDto.getMemberPw());
		
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
	
	@GetMapping(value="/logout")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("boardSessionId");
		
		try {
			response.sendRedirect(request.getContextPath() + "/main");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		//return "main";
	}

}
