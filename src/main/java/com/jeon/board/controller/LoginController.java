package com.jeon.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@GetMapping(value="login.do")
	public String loginGet() {
		System.out.println("login.do Get");
		return "login/loginForm";
	}
	
	@PostMapping(value="login.do")
	public String loginPost() {
		System.out.println("login.do Post");
		return "main";
	}
}
