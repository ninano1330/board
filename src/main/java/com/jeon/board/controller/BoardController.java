package com.jeon.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeon.board.dto.BoardDto;
import com.jeon.board.dto.MemberDto;
import com.jeon.board.service.BoardService;

@Controller
//@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;

//	@RequestMapping(value="/post.*")
//	@RequestMapping(value="/post/**/comment")
//	@RequestMapping(value={"/post", "/P"})
//	@RequestMapping(value="/post")
//	@RequestMapping(value={"/post", "/post/", "/post.*"})

	
	//@RequestMapping(value="/detail.do", method=RequestMethod.GET)
	@RequestMapping(value="/boards/{boardNo}", method=RequestMethod.GET)
	public String boardDetail(@PathVariable int boardNo, HttpServletRequest request) {		
		request.setAttribute("board", boardService.getByBoardNo(boardNo));
		
		return "board/boardDetail";
	}
	
	@RequestMapping(value="/boards/all", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getBoardsAll(BoardDto boardDto) {
		List<BoardDto> boardAllList = null;
		
		if(boardDto.getBoardNo() == 0 ) {
			boardAllList = boardService.allList();
		}else {
			
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardAllList", boardAllList);
		
		return map;
	}
	
	//@RequestMapping(value="/write.do", method=RequestMethod.POST)
	@RequestMapping(value="/boards", method=RequestMethod.POST)
	public String boardInsert(BoardDto boardDto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto boardSessionId = (MemberDto) session.getAttribute("boardSessionId");
		
		boardService.write(boardDto, boardSessionId.getMemberNo());
		
		return "main";		
	}
	
	@RequestMapping(value="/boards/me", method=RequestMethod.POST)
	public String boardUpdate(BoardDto boardDto, HttpServletRequest request){
		boardService.update(boardDto);
		
		return "main";
	}
	
	@RequestMapping(value="/boards/me/{boardNo}", method=RequestMethod.POST)
	public String boardDelete(@PathVariable int boardNo){
		boardService.delete(boardNo);
		
		return "main";
	}
	
	@RequestMapping(value="/boards/form", method=RequestMethod.GET)
	public String boardInsertForm() {
		return "board/boardForm";		
	}
	
	@RequestMapping(value="/boards/me/form", method=RequestMethod.POST)
	public String boardUpdateform(BoardDto boardDto, String memberId, HttpServletRequest request) {
		boardDto.getMemberDto().setMemberId(memberId);
		
		request.setAttribute("board", boardDto);
		
		return "board/boardUpdate";
	}
}
