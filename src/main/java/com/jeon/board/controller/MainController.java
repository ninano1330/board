package com.jeon.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController{
	@GetMapping(path="/main")
	public String main() {
		return "main";
	}
	
//	@RequestMapping(path="/main", method=RequestMethod.GET)
//	public String main2() {
//		System.out.println("hi");
//		return "main";
//	}
}
