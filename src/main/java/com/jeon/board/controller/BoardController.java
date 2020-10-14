package com.jeon.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeon.board.dto.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {

//	@RequestMapping(value="/post.*")
//	@RequestMapping(value="/post/**/comment")
//	@RequestMapping(value={"/post", "/P"})

//	@RequestMapping(value="/post")
//	@RequestMapping(value={"/post", "/post/", "/post.*"})

	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public String boardForm() {
		return "board/boardForm";		
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String boardForm(BoardDto boardDto) {
		System.out.println(boardDto.getBoardTitle());
		System.out.println(boardDto.getBoardContent());
		
		return "main";		
	}
}
