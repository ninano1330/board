package com.jeon.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeon.board.dto.BoardDto;
import com.jeon.board.service.BoardService;

@Controller
public class MainController{
	@Autowired
	BoardService boardService;
	
	@GetMapping(value="/main")
	public String main(Model model) {
	//public Map<String, Object> main(Model model) {
		
//		List<BoardDto> boardAllList = boardService.boardAllList();
		//model.addAttribute("boardAllList", boardAllList);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("boardAllList", boardAllList);
		
		return "main";
	}
	
//	@RequestMapping(path="/main", method=RequestMethod.GET)
//	public String main2() {
//		System.out.println("hi");
//		return "main";
//	}
}
