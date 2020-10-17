package com.jeon.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeon.board.dto.BoardDto;
import com.jeon.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;

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
	public String boardWrite(BoardDto boardDto, HttpServletRequest request) {
		boardService.boardWrite(boardDto, request);
		
		return "main";		
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.PUT)
	public String boardUpdate() {
		return "main";
	}
	
	@RequestMapping(value="/detail.do", method=RequestMethod.GET)
	public String boardDetail(BoardDto boardDto) {
		
		return "board/boardDetail";
	}
	
}
