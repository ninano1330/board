package com.jeon.board.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeon.board.service.BoardService;

@Controller
public class MainController{
	@Autowired
	BoardService boardService;
	
	//@GetMapping(value="/main")
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	//TEST
	@RequestMapping(value="/header", method=RequestMethod.GET)
	public String header() {
		return "header/header";
	}
}
