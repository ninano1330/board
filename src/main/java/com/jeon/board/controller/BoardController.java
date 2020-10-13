package com.jeon.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BoardController {
	@RequestMapping(path="/board.do", method=RequestMethod.GET)
	public String boardForm() {
		return "board/boardForm";
		//
	}
}
