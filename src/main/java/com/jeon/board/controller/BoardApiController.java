package com.jeon.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeon.board.dto.BoardDto;
import com.jeon.board.service.BoardService;

@RestController("/boards")
public class BoardApiController {

	@Autowired
	BoardService boardService;
	
	@GetMapping
	public Map<String, Object> getBoard(BoardDto boardDto) {
		List<BoardDto> boardAllList = null;
		
		if(boardDto.getBoardNo() == 0 ) {
			boardAllList = boardService.boardAllList();
		}else {
			
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardAllList", boardAllList);
		
		return map;
	}
}
