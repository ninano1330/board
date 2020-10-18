package com.jeon.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeon.board.dto.MemberDto;
import com.jeon.board.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping(value="form.do")
	public String loginForm() {
		return "login/loginForm";
	}
	
	@PostMapping(value="login.do")
	public String login(MemberDto memberDto, HttpServletRequest request) {
		MemberDto boardSessionId = loginService.login(memberDto);
		HttpSession session = request.getSession();
		session.setAttribute("boardSessionId", boardSessionId);
		
		return "main";
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
