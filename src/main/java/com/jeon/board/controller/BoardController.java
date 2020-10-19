package com.jeon.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeon.board.dto.BoardDto;
import com.jeon.board.dto.MemberDto;
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
		HttpSession session = request.getSession();
		MemberDto boardSessionId = (MemberDto) session.getAttribute("boardSessionId");
		
		boardService.write(boardDto, boardSessionId.getMemberNo());
		
		return "main";		
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public String boardUpdateForm(int boardNo, HttpServletRequest request) {
		request.setAttribute("board", boardService.getByBoardNo(boardNo));
		
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String boardUpdate(BoardDto boardDto, HttpServletRequest request) {
		System.out.println("boardNo : " + boardDto.getBoardNo());
		System.out.println("boardTitle : " + boardDto.getBoardTitle());
		System.out.println("boardContent : " + boardDto.getBoardContent());
		
		boardService.update(boardDto);
		
		return "main";
	}
	
	@RequestMapping(value="/detail.do", method=RequestMethod.GET)
	public String boardDetail(int boardNo, HttpServletRequest request) {
		request.setAttribute("board", boardService.getByBoardNo(boardNo));
		
		return "board/boardDetail";
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.GET)
	public String boardDelete(int boardNo) {
		boardService.delete(boardNo);
		
		return "main";
	}
}
