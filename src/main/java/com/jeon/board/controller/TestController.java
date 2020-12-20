package com.jeon.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController  {
	@RequestMapping(value="/test", method=RequestMethod.POST)
	@ResponseBody
	public String test(HttpServletRequest request) {
		System.out.println("POST");
		return "POST";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.PUT)
	@ResponseBody
	public String test2(HttpServletRequest request) {
		System.out.println("PUT");
		return "PUT";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.DELETE)
	@ResponseBody
	public String test3(HttpServletRequest request) {
		System.out.println("DELETE");
		return "DELETE";
	}
}
